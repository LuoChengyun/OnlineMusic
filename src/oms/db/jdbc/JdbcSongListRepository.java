package oms.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import oms.db.AlbumRepository;
import oms.db.SingerRepository;
import oms.db.SongListRepository;
import oms.db.SongRepository;
import oms.db.SongTypeRepository;
import oms.db.UserRepository;
import oms.domain.*;
import oms.web.PaginationSupport;
@Repository
public class JdbcSongListRepository implements SongListRepository {

	private JdbcTemplate jdbc;
	@Autowired
	public static  UserRepository userRepository;
	
	@Autowired
	public JdbcSongListRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	

	@Override
	public long count() {
		// TODO 自动生成的方法存根
		return jdbc.queryForLong("select count(songlist_id) from songlist");
	}

	@Override
	public SongList save(SongList songList) {
		// TODO 自动生成的方法存根
		jdbc.update(INSERT_SONGLIST, songList.getName(),songList.getUser());
		return songList;
	}

	@Override
	public SongList findOne(long id) {
		// TODO 自动生成的方法存根
		SongList songlist = null;
		try {
			songlist = jdbc.queryForObject(SELECT_SONGLIST + " where songlist_id=?", new SongListRowMapper(), id);
		} catch (DataAccessException e) {
		}
		return songlist;
	}


	@Override
	public List<SongList> findAll() {
		// TODO 自动生成的方法存根
		return jdbc.query(SELECT_SONGLIST + " order by songlist_id", new SongListRowMapper());
	}

	@Override
	public void deleteSongList(long id) {
		// TODO 自动生成的方法存根
		jdbc.update("delete from songlist where songlist_id=?", id);
	}
	
	@Override
	public int alterSongList(long id) {
		// TODO 自动生成的方法存根
		int rows=jdbc.update(UPDATE_SONGLIST,id);
		 return rows;
	}

	@Override
	public PaginationSupport<SongList> findPage(int pageNo, int pageSize ,long userId) {
		// TODO 自动生成的方法存根
		int totalCount = (int) count();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<SongList>(new ArrayList<SongList>(0), 0);
		
		List<SongList> items = jdbc.query(SELECT_PAGE_SONGLISTS, new SongListRowMapper(),userId ,pageSize, startIndex);
		PaginationSupport<SongList> ps = new PaginationSupport<SongList>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	private static class SongListRowMapper implements RowMapper<SongList> {
		public SongList mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("songlist_id");
			String name = rs.getString("songlist_name");
			User user = new User(rs.getLong("users_id"),rs.getString("first_name"),
					rs.getString("last_name"),rs.getString("users_account"), rs.getString("users_password"),rs.getString("users_sex"),rs.getString("users_introduct"),rs.getString("users_picture_url"),rs.getInt("users_status"),rs.getInt("users_remove"),rs.getInt("users_identity"));
			
			return new SongList(id, name, user);

		}
	}
	
	
	String INSERT_SONGLIST="insert into songlist (songlist_name,songlist_users) values (?, ?)";
	
	String SELECT_SONGLIST="select s.songlist_id, s.songlist_name, s.songlist_users ,  u.users_id, u.first_name, u.last_name, u.users_account, u.users_password, u.users_sex, u.users_introduct, u.users_picture_url, u.users_status, u.users_remove, u.users_identity  from songlist s,users u";
	
	String UPDATE_SONGLIST="update songlist set songlist_name= ?";
	
	String SELECT_PAGE_SONGLISTS = SELECT_SONGLIST +
			" where u.users_id = s.songlist_users and u.users_id = ?  order by songlist_id  limit ? offset  ?";


}
