package oms.web;

public class AddSong {
	String name;
	String url;
	String lyricURL;
	String singer;
	String album;
	String type;
	
	public AddSong(String name, String url, String lyricURL, String singer, String album, String type) {
		super();
		this.name = name;
		this.url = url;
		this.lyricURL = lyricURL;
		this.singer = singer;
		this.album = album;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLyricURL() {
		return lyricURL;
	}

	public void setLyricURL(String lyricURL) {
		this.lyricURL = lyricURL;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AddSong() {
		// TODO 自动生成的构造函数存根
	}
	
	

}
