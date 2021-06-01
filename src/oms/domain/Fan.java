package oms.domain;
/**
 * 粉丝实体
 * @author luochengyun
 *
 */
public class Fan {
	

	private Long id;//表id
	private User userId;//用户id
	private User fanId;//粉丝ID
	
	/**
	 * 
	 * @param userId
	 * @param fanId
	 */
	public Fan(User userId,User fanId) {
		this(null,userId,fanId);
	}
	/**
	 * 
	 * @param id
	 * @param userId
	 * @param fanId
	 */
	public Fan(Long id,User userId,User fanId) {
		this.id=id;
		this.userId=userId;
		this.fanId=fanId;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public User getFanId() {
		return fanId;
	}
	public void setFanId(User fanId) {
		this.fanId = fanId;
	}
	
}
