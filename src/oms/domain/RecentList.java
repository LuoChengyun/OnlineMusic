package oms.domain;

import java.util.Date;

/**
 * 最近播放歌单实体
 * @author luochengyun
 *
 */
public class RecentList {
	
	private Long id;//最近播放歌单id
	private User user;//歌单使用用户
	private Song song;//歌曲
	private Date time;//播放时间
	
	/***
	 * 
	 * @param name
	 * @param user
	 * @param song
	 * @param time
	 */
	public RecentList(User user,Song song,Date time) {
		this(null,user,song,time);
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param user
	 * @param song
	 * @param time
	 */
	public RecentList(Long id,User user,Song song,Date time) {
		this.id=id;
		this.user=user;
		this.song=song;
		this.time=time;
	}
	
	public RecentList() {
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}


}
