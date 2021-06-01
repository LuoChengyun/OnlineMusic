package oms.db.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import oms.db.RecordRepository;
import oms.db.UserRepository;
import oms.domain.Record;
import oms.domain.User;
import oms.web.PaginationSupport;

@Repository
public class JdbcRecordRepository implements RecordRepository{
	
	
	@Autowired
	public static UserRepository userRepository;
	
	private JdbcTemplate jdbc;

	@Autowired
	public JdbcRecordRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public long recordCount() {
		// TODO Auto-generated method stub
		return jdbc.queryForLong("select count(record_id) from record");
	}
	
	@Override
	public void save(Record record) {
		jdbc.update(INSERT_RECORD,record.getUser().getId(),record.getTime());
		
	}


	@Override
	public PaginationSupport<Record> findPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		int totalCount = (int) recordCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Record>(new ArrayList<Record>(0), 0);

		List<Record> items = jdbc.query(SELECT_PAGE_RECORD, new RecordRowMapper(), pageSize, startIndex);
		PaginationSupport<Record> ps = new PaginationSupport<Record>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public PaginationSupport<Record> findPageByName(int pageNo, int pageSize, String userName) {
		int totalCount = (int) recordCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Record>(new ArrayList<Record>(0), 0);

		List<Record> items = jdbc.query(SELECT_RECORD+" and u.users_account like ?   order by r.record_id desc limit ? offset  ?", new RecordRowMapper(),"%"+userName+"%",pageSize, startIndex);
		PaginationSupport<Record> ps = new PaginationSupport<Record>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	
	private static class RecordRowMapper implements RowMapper<Record> {
		public Record mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("record_id");
			User user=new User(rs.getLong("users_id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("users_account"),rs.getString("users_password"),rs.getString("users_sex"),rs.getString("users_introduct"),rs.getString("users_picture_url"),rs.getInt("users_status"),rs.getInt("users_remove"),rs.getInt("users_identity"));
			Timestamp date=rs.getTimestamp("record_time");
			return new Record(id,user,date);
		}
	}
	
	private static final String INSERT_RECORD = "insert into record (record_users,record_time) values (?, ?)";
	
	private static final String SELECT_RECORD = "select  r.record_id, r.record_users , r.record_time , u.users_id, u.first_name , u.last_name , u.users_account , u.users_password , u.users_sex , u.users_introduct , u.users_picture_url,u.users_status , u.users_remove , u.users_identity from record r,users u where r.record_users=u.users_id ";

	private static final String SELECT_PAGE_RECORD= SELECT_RECORD+" order by r.record_id desc limit ? offset  ?";


}
