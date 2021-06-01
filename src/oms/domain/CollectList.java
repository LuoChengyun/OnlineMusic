package oms.domain;
/**
 * 收藏歌单实体
 * @author luochengyun
 *
 */
public class CollectList {
	
	private Long id;
	private String name;
	private User user;
	private Song song;//歌曲
	/**
	 * 
	 * @param name
	 * @param user
	 */
	public CollectList(String name,User user,Song song) {
		this(null,name,user,song);
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param user
	 */
	public CollectList(Long id,String name,User user,Song song) {
		this.id=id;
		this.name=name;
		this.user=user;
		this.song=song;
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
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}

}
