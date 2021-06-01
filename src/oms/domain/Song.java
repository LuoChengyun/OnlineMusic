package oms.domain;

import java.util.Date;
import oms.domain.*;

/**
 * 歌曲类
 * 
 * @author Huang Jiaxun+luochengyun
 * @version v1.0
 */

public class Song {
	private Long id;//歌曲ID
	private String name;//歌曲名
	private Date release;//歌曲发布时间
	private String url;//歌曲路径
	private String lyricURL;//歌曲歌词
	private Long click;//歌曲播放量
	private Singer singer;//歌曲的歌手
	private Album album;//歌曲专辑
	private SongType type;//歌曲类型
    
    /**
	 * 构造方法
	 * @param name
	 *            姓名
	 * @param release
	 *            发布日期
	 * @param url
	 *            歌曲文件地址
	 * @param lyricURL
	 *            歌词文件地址
	 * @param click
	 * 			播放量
	 * @param singer
	 *            歌手
	 * @param album
	 *            专辑
	 * @param type
	 * 			类型          
	 */
	public Song(String name, Date release, String url,String lyricURL,Singer singer,Album album,SongType type) {
		this(null, name, release, url,lyricURL,null,singer,album,type);
	}
	public SongType getType() {
		return type;
	}
	public void setType(SongType type) {
		this.type = type;
	}
	public void setClick(Long click) {
		this.click = click;
	}
	/**
	 * 构造方法
	 * @param id
	 *            序号
	 * @param name
	 *            姓名
	 * @param release
	 *            发布日期
	 * @param url
	 *            歌曲文件地址
	 * @param lyricURL
	 *            歌词文件地址
	 * @param click
	 * 			播放量
	 * @param singer
	 *            歌手
	 * @param album2
	 *            专辑
	 * @param songType
	 * 			类型             
	 */
		public Song(Long id,String name, Date release,String url,String lyricURL, Long click,Singer singer,Album album,SongType songType) {
			this.id=id;
			this.name=name;
			this.release=release;
			this.url=url;
			this.lyricURL=lyricURL;
			this.click=click;
			this.singer=singer;
			this.album=album;
			this.type=songType;
			
		}
	public Song() {
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
	public Date getRelease() {
		return release;
	}
	public void setRelease(Date release) {
		this.release = release;
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
	public long getClick() {
		return click;
	}
	public void setClick(long click) {
		this.click=click;
	}
	public Singer getSinger() {
		return singer;
	}
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public SongType getSongType() {
		return type;
	}
	public void setSongType(SongType type) {
		this.type = type;
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
		Song other = (Song) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lyricURL == null) {
			if (other.lyricURL != null)
				return false;
		} else if (!lyricURL.equals(other.lyricURL))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (click == null) {
			if (other.click != null)
				return false;
		} else if (!click.equals(other.click))
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
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	

}
