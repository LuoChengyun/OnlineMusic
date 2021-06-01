package oms.domain;

import java.sql.Timestamp;
import java.util.Date;


/**
 * 登录记录实体
 * @author luochengyun
 *
 */
public class Record {
	
	private Long id;//登录记录ID
	private User user;//登录用户
	private Timestamp time;//登录时间
	
	/**
	 * 
	 * @param user
	 * @param time
	 */
	public Record(User user,Timestamp time) {
		this(null,user,time);
		
	}
	
	/**
	 * 
	 * @param id
	 * @param user
	 * @param time
	 */
	public Record(Long id,User user,Timestamp time) {
		this.id=id;
		this.user=user;
		this.time=time;
		
	}

	public Record() {
		// TODO 自动生成的构造函数存根
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	

}
