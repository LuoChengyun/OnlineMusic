package oms.db.jdbc;


import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import oms.db.AlbumRepository;
import oms.domain.Album;
import oms.domain.Singer;
import oms.web.PaginationSupport;

@Repository
public class JdbcAlbumRepository implements AlbumRepository {
	
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcAlbumRepository(JdbcTemplate jdbc) {
		this.jdbc =jdbc;
	}
	
	@Override
	public long albumCount() {
		// TODO Auto-generated method stub
		return jdbc.queryForLong("select count(album_id) from album");
	}

	@Override
	public Album findOne(long id) {
		// TODO Auto-generated method stub
		Album album = null;
		try {
			album = jdbc.queryForObject(SELECT_ALBUM + " and a.album_id=?", new AlbumRowMapper(), id);
		} catch (DataAccessException e) {
		}
		return album;
	}
	
	@Override
	public List<Album> findLastFive() {
		// TODO 自动生成的方法存根
		List<Album> list;
		long count=albumCount();
	    list= jdbc.query(SELECT_ALBUM + " order by a.album_id desc limit 5", new AlbumRowMapper());
		return list;
	}

	@Override
	public Album save(Album album) {
		// TODO Auto-generated method stub
		jdbc.update(INSERT_ALBUM,album.getName(),album.getRelease(),album.getSinger().getId(),album.getPicture());
		return album;
	}

	@Override
	public Album alterAlbum(Album album) {
		// TODO Auto-generated method stub
		jdbc.update(UPDATE_ALBUM,album.getName(),album.getId());
		return album;
	}

	@Override
	public int deleteAlbum(long id) {
		// TODO Auto-generated method stub
		int rows=jdbc.update("delete from album where album_id=?",id);
		return rows;
	}
	
	@Override
	public Album findByAlbumName(String albumName) {
		// TODO 自动生成的方法存根
		Album album = null;
		
		try {
			album = jdbc.queryForObject(SELECT_ALBUM + " and a.album_name=?", new AlbumRowMapper(),albumName);
		} catch (DataAccessException e) {
		}
		return album;
	}

	@Override
	public PaginationSupport<Album> findPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		int totalCount = (int) albumCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Album>(new ArrayList<Album>(0), 0);

		List<Album> items = jdbc.query(SELECT_PAGE_ALBUM, new AlbumRowMapper(), pageSize, startIndex);
		PaginationSupport<Album> ps = new PaginationSupport<Album>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public PaginationSupport<Album> findPageByAlbumName(int pageNo, int pageSize, String albumName) {
		int totalCount = (int) albumCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Album>(new ArrayList<Album>(0), 0);

		List<Album> items = jdbc.query(SELECT_ALBUM_ALBUMNAME, new AlbumRowMapper(), "%"+albumName+"%",pageSize, startIndex);
		PaginationSupport<Album> ps = new PaginationSupport<Album>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public PaginationSupport<Album> findPageBySingerName(int pageNo, int pageSize, String singerName) {
		// TODO Auto-generated method stub
		int totalCount = (int) albumCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Album>(new ArrayList<Album>(0), 0);

		List<Album> items = jdbc.query(SELECT_ALBUM_SINGERNAME, new AlbumRowMapper(),singerName, pageSize, startIndex);
		PaginationSupport<Album> ps = new PaginationSupport<Album>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	
	private static class AlbumRowMapper implements RowMapper<Album> {
		public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("album_id");
			String name = rs.getString("album_name");
			Date time = rs.getDate("album_release");
			Singer singer = new Singer(rs.getLong("singer_id"),
					rs.getString("singer_name"),rs.getString("singer_sex"),
					rs.getString("singer_introduct"),rs.getString("singer_picture_url"));
			String pictureurl = rs.getString("album_picture_url");
			
			return new Album(id,name,time,singer,pictureurl);
		}
	}

	private static final String INSERT_ALBUM = "insert into album (album_name,album_release,album_singer,album_picture_url) values (?, ?, ?, ?)";
	
	private static final String SELECT_ALBUM = "select a.album_id,a.album_name,a.album_release,a.album_singer,a.album_picture_url,s.singer_id,s.singer_name,s.singer_sex,s.singer_introduct,s.singer_picture_url from album a ,singer s where a.album_singer=s.singer_id ";
	
	private static final String UPDATE_ALBUM="update album set album_name=?  where album_id=?";
	
	private static final String SELECT_PAGE_ALBUM= SELECT_ALBUM+" order by a.album_id  limit ? offset  ?";
	
	private static final String SELECT_ALBUM_ALBUMNAME= SELECT_ALBUM+" and a.album_name like ?  order by a.album_id desc limit ? offset  ?";
	
	private static final String SELECT_ALBUM_SINGERNAME= SELECT_ALBUM+"  and s.singerName = ?  order by a.album_id desc limit ? offset  ?";

	

	
	
}
