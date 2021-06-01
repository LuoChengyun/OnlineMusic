package oms.domain;

/**
 * 歌曲类型实体
 * @author luochengyun
 *
 */
public class SongType {
    private Long id;//类型ID
    private String name;//类型名
    private String picture;//类型图片
    
    /**
     * 
     * @param name
     * @param picture
     */
    public SongType(String name,String picture) {
    	this(null,name,picture);
    }
    /**
     * 
     * @param id
     * @param name
     * @param picture
     */
    public SongType(Long id,String name,String picture) {
    	this.id=id;
    	this.name=name;
    	this.picture=picture;
    }
    

	public SongType() {
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
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPicture() {
		return picture;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SongType other = (SongType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
