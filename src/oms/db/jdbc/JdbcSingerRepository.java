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

import oms.db.SingerRepository;
import oms.domain.Album;
import oms.domain.Singer;
import oms.domain.Song;
import oms.domain.User;
import oms.web.PaginationSupport;
@Repository
public class JdbcSingerRepository implements SingerRepository {
	
	private JdbcTemplate jdbc;

	@Autowired
	public JdbcSingerRepository(JdbcTemplate jdbc) {
		// TODO 自动生成的构造函数存根
		this.jdbc =jdbc;
	}

	@Override
	public long singerCount() {
		// TODO 自动生成的方法存根
		return jdbc.queryForLong("select count(singer_id) from singer");
	}

	@Override
	public Singer save(Singer singer) {
		// TODO 自动生成的方法存根
		
		jdbc.update(INSERT_SINGER, singer.getName(),
				singer.getSex(),singer.getIntroduct(),singer.getPictureURL());
		return singer;
	}
	


	@Override
	public Singer findOne(long id) {
		Singer singer = null;
		try {
			singer = jdbc.queryForObject(SELECT_SINGER + " where singer_id=?", new SingerRowMapper(), id);
		} catch (DataAccessException e) {
		}
		return singer;
	}

	@Override
	public Singer findBySingerName(String name) {
		// TODO 自动生成的方法存根
		Singer singer = null;
		
		try {
			singer = jdbc.queryForObject(SELECT_SINGER + " where singer_name=?", new SingerRowMapper(),name);
		} catch (DataAccessException e) {
		}
		return singer;
	}

	@Override
	public List<Singer> findAll() {
		// TODO 自动生成的方法存根
		return jdbc.query(SELECT_SINGER + " order by singer_id", new SingerRowMapper());
	}

	@Override
	public Singer alterSinger(Singer singer) {
		// TODO 自动生成的方法存根
		jdbc.update(UPDATE_SINGER,singer.getName(),singer.getSex(),singer.getIntroduct(),singer.getPictureURL(),singer.getId());
		return singer;
	}

	@Override
	public int deleteBySingerId(long id) {
		// TODO 自动生成的方法存根
		int rows=jdbc.update("delete from singer where singer_id=?",id);	
		   return rows;
	}
	
	@Override
	public int addSinger(Singer singer) {
		int rows=jdbc.update(INSERT_SINGER,singer.getName(),singer.getSex(),singer.getIntroduct(),singer.getPictureURL());
		return rows;
		// TODO 自动生成的方法存根
		
	}
	@Override
	public List<Singer> findFirstFive() {
		// TODO 自动生成的方法存根
		return jdbc.query(SELECT_SINGER+"limit 5", new SingerRowMapper());
	}
	
	

	@Override
	public PaginationSupport<Singer> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int) singerCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Singer>(new ArrayList<Singer>(0), 0);

		List<Singer> items = jdbc.query(SELECT_PAGE_SINGER, new SingerRowMapper(), pageSize, startIndex);
		PaginationSupport<Singer> ps = new PaginationSupport<Singer>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	
	@Override
	public PaginationSupport<Singer> findPageBySingerName(int pageNo, int pageSize, String singerName) {
		// TODO 自动生成的方法存根
		int totalCount = (int) singerCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Singer>(new ArrayList<Singer>(0), 0);

		List<Singer> items = jdbc.query(SELECT_SINGER_SINGERNAME, new SingerRowMapper(),"%"+singerName+"%", pageSize, startIndex);
		PaginationSupport<Singer> ps = new PaginationSupport<Singer>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	
	private static class SingerRowMapper implements RowMapper<Singer> {
		public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Singer(rs.getLong("singer_id"),
					rs.getString("singer_name"),
					rs.getString("singer_sex"),
					rs.getString("singer_introduct"),
					rs.getString("singer_picture_url"));
		}
	}
	
	
	
	private static final String SELECT_SINGER ="select singer_id,singer_name,singer_sex,singer_introduct,singer_picture_url from singer ";
	
	private static final String INSERT_SINGER = "insert into singer (singer_name,singer_sex,singer_introduct,singer_picture_url) values (?,?,?,?)";
	
	private static final String UPDATE_SINGER="update singer set singer_name=?,singer_sex=?, singer_introduct=?,singer_picture_url=? where singer_id=? ";
	
	private static final String SELECT_PAGE_SINGER=SELECT_SINGER+"  order by singer_id  limit ? offset  ?";
	
	private static final String SELECT_SINGER_SINGERNAME=SELECT_SINGER+" where singer_name like ? order by singer_id limit ? offset ?";

	
	

	
}
