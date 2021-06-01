package oms.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import oms.db.SongTypeRepository;
import oms.domain.Song;
import oms.domain.SongType;
import oms.domain.User;
import oms.web.PaginationSupport;

@Repository
public class JdbcSongTypeRepository implements SongTypeRepository {

	private JdbcTemplate jdbc;
	@Autowired
	public JdbcSongTypeRepository(JdbcTemplate jdbc) {
		// TODO 自动生成的构造函数存根
		this.jdbc =jdbc;
	}
	@Override
	public long SongTypeCount() {
		// TODO 自动生成的方法存根
		return jdbc.queryForLong("select count(songtype_id) from songtype");
	}

	@Override
	public SongType findOne(long id) {
		// TODO 自动生成的方法存根
		SongType songtype=null;
//		System.out.println(id);
		try {
			songtype=jdbc.queryForObject(SELECT_SONGTYPE+" where songtype_id=?",new SongTypeRowMapper(),id);
		}catch(DataAccessException e) {
			System.out.println(e);
		}
		return songtype;
	}

	@Override
	public SongType save(SongType songtype) {
		// TODO 自动生成的方法存根
		jdbc.update(INSERT_SONGTYPE,songtype.getName(),songtype.getPicture());
		return songtype;
	}

	@Override
	public SongType findBySongTypeName(String songtypename) {
		// TODO 自动生成的方法存根
		SongType songtype=null;
		try {
			songtype=jdbc.queryForObject(SELECT_SONGTYPE+" where songtype_name=?",new SongTypeRowMapper(),songtypename);
		}catch(DataAccessException e) {
	
		}
		return songtype;
	}

	@Override
	public int deleteSongType(long id) {
		// TODO 自动生成的方法存根
		int rows=jdbc.update("delete from songtype where songtype_id=?",id);	
		   return rows;
	}

	@Override
	public SongType altersongType(SongType songtype) {
		// TODO 自动生成的方法存根
		jdbc.update(UPDATE_SONGTYPE,songtype.getName(),songtype.getPicture(),songtype.getId());
		return songtype;
	}

	@Override
	public List<SongType> findAll() {
		// TODO 自动生成的方法存根
		 return jdbc.query(SELECT_SONGTYPE + " order by songtype_id",new SongTypeRowMapper());
	}

	@Override
	public PaginationSupport<SongType> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int)SongTypeCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<SongType>(new ArrayList<SongType>(0), 0);
		List<SongType> items = jdbc.query(SELECT_PAGE_SONGTYPES, new SongTypeRowMapper(), pageSize, startIndex);
		PaginationSupport<SongType> ps = new PaginationSupport<SongType>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	
	private static class SongTypeRowMapper implements RowMapper<SongType>{

		@Override
		public SongType mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO 自动生成的方法存根
			return new SongType(rs.getLong("songtype_id"),
					rs.getString("songtype_name"),
					rs.getString("songtype_picture_url"));
		}
		
	}
	
	String SELECT_SONGTYPE="select songtype_id,songtype_name,songtype_picture_url from songtype ";
	
	String INSERT_SONGTYPE="insert into songtype(songtype_name,songtype_picture_url) values (?, ?)";
	
	String UPDATE_SONGTYPE="update songtype set songtype_name=?,songtype_picture_url=? where songtype_id=?";

	String SELECT_PAGE_SONGTYPES = SELECT_SONGTYPE+" order by songtype_id  limit ? offset  ?";
}
