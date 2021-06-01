package oms.domain;
/**
 * 歌手实体
 * @author luochengyun
 *
 */
public class Singer {
  private Long id;//歌手ID
  private String name;//歌手名
  private String sex;//歌手性别
  private String introduct;//歌手介绍
  private String pictureURL;//歌手图片
  
  	/**
  	 * 
  	 * @param name
  	 * @param sex
  	 * @param introduct
  	 * @param pictureURL
  	 */
    public Singer(String name,String sex,String introduct,String pictureURL) {
	  this(null,name,sex,introduct,pictureURL);
  }
  public Singer(Long id,String name,String sex,String introduct, String pictureURL) {
	  this.id=id;
	  this.name=name;
	  this.sex=sex;
	  this.introduct=introduct;
	  this.pictureURL=pictureURL;
  }
public Singer() {
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
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getIntroduct() {
	return introduct;
}
public void setIntroduct(String introduct) {
	this.introduct = introduct;
}
public String getPictureURL() {
	return pictureURL;
}
public void setPictureURL(String pictureURL) {
	this.pictureURL = pictureURL;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
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
	Singer other = (Singer) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (pictureURL == null) {
		if (other.pictureURL != null)
			return false;
	} else if (!pictureURL.equals(other.pictureURL))
		return false;
	if (sex == null) {
		if (other.sex != null)
			return false;
	} else if (!sex.equals(other.sex))
		return false;
	if (introduct == null) {
		if (other.introduct != null)
			return false;
	} else if (!introduct.equals(other.introduct))
		return false;
	return true;
}


}
