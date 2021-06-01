package oms.domain;

import java.util.Date;
/**
 * 专辑实体
 * @author luochengyun
 *
 */
public class Album {
 private Long id;//专辑ID
 private String name;//专辑名
 private Date release;//专辑发布时间
 private Singer singer;//专辑的歌手
 private String picture;//专辑图片
/**
 * 构造方法
 * @param name
 *            姓名
 * @param release
 *            发布日期
 * @param singer
 *            歌手
 * @param picture
 * 			   图片
 */
	public Album(String name, Singer singer,String picture) {
		this(null, name ,new Date(), singer,picture);
	}
	
	
	 /**
		 * 构造方法
		 * @param id
		 *            序号
		 * @param name
		 *            姓名
		 * @param release
		 *            发布日期
		 * @param singer
		 *            歌手
		 * @param picture
		 * 			   图片
		 */
		public Album(Long id,String name, Date release, Singer singer,String picture) {
			this.id=id;
			this.name=name;
			this.release=release;
			this.singer=singer;
			this.picture=picture;
			
		}
		
		
	public Album() {
		// TODO 自动生成的构造函数存根
	}
	public Album(Long id, String name) {
		// TODO 自动生成的构造函数存根
		this(id,name,null,null,null);
	}


	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public Date getRelease() {
		return release;
	}
	public void setRelease(Date release) {
		this.release = release;
	}
	public Singer getSinger() {
		return singer;
	}
	public void setSinger(Singer singer) {
		this.singer = singer;
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
		Album other = (Album) obj;
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
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		if (singer == null) {
			if (other.singer != null)
				return false;
		} else if (!singer.equals(other.singer))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		return true;
	}
	

   
 
}
