package oms.db.jdbc;
/**
 * 歌曲资源库接口的jdbc实现类
 * 
 * @author Huang Jiaxun
 * @version v1.0
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

import oms.db.SongRepository;
import oms.domain.*;
import oms.web.PaginationSupport;
@Repository
public class JdbcSongRepository implements SongRepository{
	private JdbcTemplate jdbc;

	@Autowired
	public JdbcSongRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Song save(Song song) {
		jdbc.update(INSERT_SONG, song.getName(), song.getRelease(), song.getUrl(),song.getLyricURL(),song.getSinger().getId(),
				song.getAlbum().getId(),song.getType().getId());
		return song;
	}

	

	@Override
	public long count() {
		return jdbc.queryForLong("select count(song_id) from song");
	}

	@Override
	public Song findOne(long id) {
		Song song = null;
		try {
			song = jdbc.queryForObject(SELECT_SONG + " song_id=?", new SongRowMapper(), id);
		} catch (DataAccessException e) {
		}
		return song;
	}
	@Override
	public List<Song> findFirstTen() {
		// TODO 自动生成的方法存根
		return jdbc.query(SELECT_SONG+" order by s1.song_clicks desc limit 10",new SongRowMapper());
	}
	@Override
	public PaginationSupport<Song> findBySongName(int pageNo, int pageSize,String songName) {
		int totalCount = (int) count();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Song>(new ArrayList<Song>(0), 0);

		List<Song> items = jdbc.query(SELECT_SONG +" and s1.song_name like ?  order by s1.song_id desc limit ? offset  ?", new SongRowMapper(),"%"+songName+"%",pageSize, startIndex);
		PaginationSupport<Song> ps = new PaginationSupport<Song>(items, totalCount, pageSize, startIndex);
		return ps;
		
	}

	@Override
	public PaginationSupport<Song> findBySingerName(int pageNo, int pageSize,String singerName) {
		int totalCount = (int) count();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Song>(new ArrayList<Song>(0), 0);
		
		List<Song> items = jdbc.query(SELECT_SONG +" and s1.song_name like ?  order by s1.song_id desc limit ? offset  ?", new SongRowMapper(),singerName,pageSize, startIndex);
		PaginationSupport<Song> ps = new PaginationSupport<Song>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public void deleteSong(long id) {
		jdbc.update("delete from song where id=?", id);
	}
	@Override
	public List<Song> findTypeSong(Long type_id){
		return jdbc.query(SELECT_SONG +" and s1.song_type=?", new SongRowMapper(),type_id);
	}

	@Override
	public List<Song> findAll() {
		return jdbc.query(SELECT_SONG + " order by s1.song_id", new SongRowMapper());
	}

	private static class SongRowMapper implements RowMapper<Song> {
		public Song mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("song_id");
			String name = rs.getString("song_name");
			Timestamp release = rs.getTimestamp("song_release");
			String url = rs.getString("song_url");
			String lyricURL = rs.getString("song_lyric_url");
			Long click = rs.getLong("song_clicks");
			Singer singer = new Singer(rs.getLong("singer_id"),rs.getString("singer_name"),rs.getString("singer_sex"),rs.getString("singer_introduct"),rs.getString("singer_picture_url"));
			Album album=new Album(rs.getLong("album_id"),rs.getString("album_name"),rs.getDate("album_release"),singer,rs.getString("album_picture_url"));
			SongType songType=new SongType(rs.getLong("songtype_id"),rs.getString("songtype_name"),rs.getString("songtype_picture_url"));
			
			return new Song(id, name, release, url,lyricURL,click,singer,album,songType);

		}
	}

	@Override
	public PaginationSupport<Song> findPage(int pageNo, int pageSize) {
		int totalCount = (int) count();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Song>(new ArrayList<Song>(0), 0);

		List<Song> items = jdbc.query(SELECT_PAGE_SONGS, new SongRowMapper(), pageSize, startIndex);
		PaginationSupport<Song> ps = new PaginationSupport<Song>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	private static final String INSERT_SONG = "insert into song (song_name, song_release, song_url, song_lyric_url,song_singer,song_album,song_type) values (?, ?, ?, ?, ?, ?, ?)";

	private static final String SELECT_SONG = "select s1.song_id, s1.song_name, s1.song_release, s1.song_url, s1.song_lyric_url, s1.song_clicks, s1.song_singer"
												+ ", s1.song_album, s1.song_type , a.album_id, a.album_name, a.album_release , a.album_singer , a.album_picture_url "
												+ ", s2.songtype_id , s2.songtype_name , s2.songtype_picture_url , s3.singer_id , s3.singer_name , "
												+ "s3.singer_sex , s3.singer_introduct , s3.singer_picture_url from song s1 ,album a,songtype s2 ,singer s3 where s1.song_album = a.album_id and s1.song_type = s2.songtype_id and s1.song_singer = s3.singer_id ";
	
	private static final String SELECT_PAGE_SONGS = SELECT_SONG
			+ " order by s1.song_id desc limit ? offset  ?";

	


	
	
}
