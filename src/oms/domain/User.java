package oms.domain;
/**
 * 用实体类
 * @author luochengyun
 *
 */
public class User {
   private Long id;//用户id
   private String firstName;//用户的名
   private String lastName;//用户的性
   private String userName;//用户账号
   private String password;//用户密码
   private String sex;//用户性别
   private String introduct;//用户介绍
   private String pictureURL;//用户头像
   private Integer status;//用户状态
   private Integer remove;//用户删除标识
   private Integer identity;//用户身份标识

   /**
    * 
    * @param firstName
    * @param lastName
    * @param userName
    * @param password
    * @param sex
    * @param introduct
    */
   public User(String firstName,String lastName,String userName,String password,String sex,String introduct,String pictureURL) {
	   this(null,firstName,lastName,userName,password,sex,introduct,pictureURL,null,null,null);
   }
 
   /**
    * 
    * @param id
    * @param firstName
    * @param lastName
    * @param userName
    * @param password
    * @param sex
    * @param introduct
    * @param status
    * @param remove
    * @param identity
    */
   public User( Long id,String firstName,String lastName,String userName,String password,String sex,String introduct,String pictureURL,Integer status,Integer remove,Integer identity) {
	  this.id=id;
	  this.firstName=firstName;
	  this.lastName=lastName;
	  this.userName=userName;
	  this.password=password;
	  this.sex=sex;
	  this.introduct=introduct;
	  this.pictureURL=pictureURL;
	  this.remove=remove;
	  this.status=status;
	  this.identity=identity;
   }

public User() {
	// TODO 自动生成的构造函数存根
}

public User(Long id, String firstName, String lastName, String userName, String password, String sex,
		String introduct) {
	this.id=id;
	  this.firstName=firstName;
	  this.lastName=lastName;
	  this.userName=userName;
	  this.password=password;
	  this.sex=sex;
	  this.introduct=introduct;
	
	// TODO 自动生成的构造函数存根
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public void setIntroduct(String introduct) {
	this.introduct = introduct;
}
public String getIntroduct() {
	return introduct;
}
public String getPictureURL() {
	return pictureURL;
}

public void setPictureURL(String pictureURL) {
	this.pictureURL = pictureURL;
}
public Integer getRemove() {
	return remove;
}
public void setRemove(Integer remove) {
	this.remove = remove;
}
public Integer getIdentity() {
	return identity;
}
public void setIdentity(Integer identity) {
	this.identity = identity;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
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
	User other = (User) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if(sex==null) {
		if(other.sex!=null)
			return false;
	} else if(!sex.equals(other.sex))
		return false;
	if(introduct==null) {
		if(other.introduct!=null)
			return false;
	} else if(!introduct.equals(other.introduct))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (remove == null) {
		if (other.remove != null)
			return false;
	} else if (!remove.equals(other.remove))
		return false;
	if (identity == null) {
		if (other.identity != null)
			return false;
	} else if (!identity.equals(other.identity))
		return false;
	
	return true;
	}
}
