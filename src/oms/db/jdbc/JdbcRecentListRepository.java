package oms.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import oms.db.RecentListRepository;
import oms.domain.Album;
import oms.domain.RecentList;
import oms.domain.Singer;
import oms.domain.Song;
import oms.domain.SongType;
import oms.domain.User;
import oms.web.PaginationSupport;

@Repository
public class JdbcRecentListRepository implements RecentListRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcRecentListRepository(JdbcTemplate jdbc) {
		this.jdbc =jdbc;
	}
	
	@Override
	public long count(long userId) {
		// TODO Auto-generated method stub
		return jdbc.queryForLong("select count(recentlist_id) from recentlist where recentlist_users = ?",userId);
	}

	@Override
	public void save(RecentList recentList) {
		// TODO Auto-generated method stub
		jdbc.update(INSERT_RECENTLIST,recentList.getUser(),recentList.getSong(),recentList.getTime());

	}

	@Override
	public RecentList findOne(long id) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject(SELECT_RECENTLIST+" and r.recentlist_id = ?", new RecentListRowMapper(),id);
	}

	@Override
	public List<RecentList> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecentList(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int alterRecentList(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PaginationSupport<RecentList> findPage(int pageNo, int pageSize, long userId) {
		// TODO Auto-generated method stub
		int totalCount = (int) count(userId);
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<RecentList>(new ArrayList<RecentList>(0), 0);
		
		List<RecentList> items = jdbc.query(SELECT_PAGE_RECENTLIST, new RecentListRowMapper(),userId, pageSize, startIndex);
		PaginationSupport<RecentList> ps = new PaginationSupport<RecentList>(items, totalCount, pageSize, startIndex);
		return ps;
		
	}

	@Override
	public PaginationSupport<RecentList> findPageByName(int pageNo, int pageSize, long userId, String songName) {
		// TODO Auto-generated method stub
		int totalCount = (int) count(userId);
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<RecentList>(new ArrayList<RecentList>(0), 0);
		
		List<RecentList> items = jdbc.query(SELECT_PAGE_BY_SONGNAME, new RecentListRowMapper(),userId, "%"+songName+"%",pageSize, startIndex);
		PaginationSupport<RecentList> ps = new PaginationSupport<RecentList>(items, totalCount, pageSize, startIndex);
		return ps;
	}	
	
	private static class RecentListRowMapper implements RowMapper<RecentList> {
		public RecentList mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			long id = rs.getLong("recentlist_id");
			User user = new User(rs.getLong("recentlist_users"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("users_account"),rs.getString("users_password"),rs.getString("users_sex"),rs.getString("users_introduct"),rs.getString("users_picture_url"),rs.getInt("users_status"),rs.getInt("users_remove"),rs.getInt("users_identity"));
			
			Singer singer = new Singer(rs.getLong("singer_id"),rs.getString("singer_name"),rs.getString("singer_sex"),rs.getString("singer_introduct"),rs.getString("singer_picture_url"));
			Album album=new Album(rs.getLong("album_id"),rs.getString("album_name"),rs.getDate("album_realease"),singer,rs.getString("album_picture_url"));
			SongType songType=new SongType(rs.getLong("songtype_id"),rs.getString("songtype_name"),rs.getString("songtype_picture_url"));
			Song song =new Song(rs.getLong("song_id"),rs.getString("song_name"),rs.getTimestamp("song_release"),rs.getString("song_url"), rs.getString("song_lyric_url"),rs.getLong("song_clicks"),singer,album,songType);
			Date time = rs.getTimestamp("recentlist_time");
			
			return new RecentList(id, user,song,time);
			
		}
	}
	
	private static final String INSERT_RECENTLIST = "insert into recentlist ( recentlist_user, recentlist_song, recentlist_time) values (?, ?, ?)";
	
	private static final String SELECT_RECENTLIST = "select r.recentlist_id ,r.recentlist_users,r.recentlist_song ,r.recentlist_time , u.users_id , u.first_name , u.last_name , u.users_account, u.users_password , u.users_sex , u.users_introduct ,u.users_picture_url, u.users_status , u.users_remove , u.users_identity ,"
			+" s1.song_id, s1.song_name, s1.song_release, s1.song_url, s1.song_lyric_url, s1.song_clicks, s1.song_singer, s1.song_album, s1.song_type , a.album_id, a.album_name, a.album_realease , a.album_singer , a.album_picture_url "
			+ ", s2.songtype_id , s2.songtype_name , s2.songtype_picture_url , s3.singer_id , s3.singer_name , "
			+ "s3.singer_sex , s3.singer_introduct , s3.singer_picture_url from recentlist r , users u , song s1 ,album a,songtype s2 ,singer s3 where r.recentlist_users=u.users_id and r.recentlist_song=s1.song_id and s1.song_album = a.album_id and s1.song_type = s2.songtype_id and s1.song_singer = s3.singer_id ";
	
	private static final String SELECT_PAGE_RECENTLIST = SELECT_RECENTLIST +" and r.recentlist_users = ? order by r.recentlist_time desc limit ? offset  ?";
	
	private static final String SELECT_PAGE_BY_SONGNAME = SELECT_RECENTLIST +" and r.recentlist_users = ?  and s1.song_name like ? order by r.recentlist_time desc limit ? offset  ?";
}
