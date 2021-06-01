package oms.domain;

/**
 * 歌单实体
 * @author luochengyun
 *
 */
public class SongList {
	
	private Long id;//歌单ID
	private String name;//歌单名字
	private User user;//歌单使用者
	
	/**
	 * 
	 * @param name
	 * @param user
	 */
	public SongList(String name,User user) {
		this(null,name,user);
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param user
	 */
	public SongList(Long id,String name,User user) {
		this.id=id;
		this.name=name;
		this.user=user;
	}
	
	public SongList() {
		// TODO 自动生成的构造函数存根
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


}
