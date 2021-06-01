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

import oms.web.PaginationSupport;
import oms.db.UserRepository;
import oms.domain.User;

/**
 * 用户资源接口的jdbc实现类
 * @author luochengyun
 *
 */
@Repository
public class JdbcUserRepository implements UserRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcUserRepository(JdbcTemplate jdbc) {
		this.jdbc =jdbc;
	}
	
	@Override
	public long userCount() {
		
		return jdbc.queryForLong("select count(users_id) from Users");
	}

	@Override
	public User save(User user) {
		jdbc.update(INSERT_USER, user.getFirstName(),
				user.getLastName(), user.getUserName(), user.getPassword(),
				user.getSex(),user.getIntroduct(),user.getPictureURL());
		return user;
	}

	@Override
	public User findOne(long id) {
		User user = null;
		try {
			user = jdbc.queryForObject(SELECT_USER + " where users_id=?", new UserRowMapper(), id);
		} catch (DataAccessException e) {
		}
		return user;
	}

	@Override
	public User findByUserName(String userName) {
		User user = null;
		try {
			user = jdbc.queryForObject(SELECT_USER + " where users_account=? ", new UserRowMapper(),userName);
		} catch (DataAccessException e) {
		}
		return user;
	}

	@Override
	public User findByUserName(String userName, String password) {
		User user = null;
		try {
			user = jdbc.queryForObject(SELECT_USER + " where users_account=? and users_password=? ", new UserRowMapper(),
					userName,password);
		} catch (DataAccessException e) {
		}
		return user;
		
	}

	@Override
	public List<User> findAll() {
		return jdbc.query(SELECT_USER + " order by users_id", new UserRowMapper());
	}
	@Override
	public User alterUser(User user) {
		// TODO 自动生成的方法存根
		jdbc.update(UPDATE_USER,user.getFirstName(),user.getLastName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIntroduct(),user.getPictureURL(),user.getId());
		return user;
	}
	@Override
	public User alterManager(User user) {
		// TODO 自动生成的方法存根
		jdbc.update(UPDATE_USER1,user.getFirstName(),user.getLastName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIntroduct(),user.getId());
		return user;
	}
	
	@Override
	public int deleteByUserId(long id) {
		// TODO 自动生成的方法存根
		 int rows=jdbc.update("update users set users_remove=1 where users_id=?",id);	
		   return rows;
	}
	@Override
	public int checkUser(long id) {
		int rows=jdbc.update("update users set users_status=1 where users_id=?",id);
		return rows;
	}
	
	@Override
	public PaginationSupport<User> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int) userCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<User>(new ArrayList<User>(0), 0);

		List<User> items = jdbc.query(SELECT_PAGE_USERS, new UserRowMapper(), pageSize, startIndex);
		PaginationSupport<User> ps = new PaginationSupport<User>(items, totalCount, pageSize, startIndex);
		return ps;
	
	}
	
	
	private static class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getLong("users_id"),rs.getString("first_name"),
					rs.getString("last_name"),rs.getString("users_account"), rs.getString("users_password"),rs.getString("users_sex"),rs.getString("users_introduct"),rs.getString("users_picture_url"),rs.getInt("users_status"),rs.getInt("users_remove"),rs.getInt("users_identity"));
		}
	}
	

	private static final String INSERT_USER = "insert into users (first_name,last_name,users_account, users_password,users_sex,users_introduct,users_picture_url) values (?,?,?,?,?,?,?)";
	
	private static final String SELECT_USER = "select  users_id, first_name, last_name,users_account,users_password,users_sex,users_introduct,users_picture_url,users_status,users_remove,users_identity from users ";
	
	private static final String UPDATE_USER="update users set first_name=?,last_name=?, users_account=?,users_password=?,users_sex=?,users_introduct=? , users_picture_url=? where users_id=?";
	
	private static final String UPDATE_USER1="update users set first_name=?,last_name=?, users_account=?,users_password=?,users_sex=?,users_introduct=?  where users_id=?";
	
	private static final String SELECT_PAGE_USERS= SELECT_USER+" where users_remove=0 order by users_id  limit ? offset  ?";

	@Override
	public PaginationSupport<User> findPageByUserName(int pageNo, int pageSize,String userName) {
		
		int totalCount = (int) userCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<User>(new ArrayList<User>(0), 0);

		List<User> items = jdbc.query(SELECT_USER+" where users_remove=0 and users_account like ? order by users_id  limit ? offset  ?", new UserRowMapper(), "%"+userName+"%",pageSize, startIndex);
		PaginationSupport<User> ps = new PaginationSupport<User>(items, totalCount, pageSize, startIndex);
		return ps;
	
	}
	
	
	

	
	

	
}
