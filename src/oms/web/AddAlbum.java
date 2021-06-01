package oms.web;

public class AddAlbum {
	
	String albumName;
	String albumSingerName;
	String picture; 
	
	
	public AddAlbum(String albumName, String albumSingerName, String picture) {
		
		this.albumName = albumName;
		this.albumSingerName = albumSingerName;
		this.picture = picture;
	}
	public AddAlbum() {
		// TODO 自动生成的构造函数存根
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	public String getAlbumSingerName() {
		return albumSingerName;
	}
	public void setAlbumSingerName(String albumSingerName) {
		this.albumSingerName = albumSingerName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	

}
