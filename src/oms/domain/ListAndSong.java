package oms.domain;

public class ListAndSong {
	private Long id;
	private Song song;
	private SongList songlist;

	public ListAndSong(Song song,SongList songlist) {
		this(null,song,songlist);
		// TODO 自动生成的构造函数存根
	}
	public ListAndSong(Long id,Song song,SongList songlist) {
		this.id=id;
		this.song=song;
		this.songlist=songlist;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	public SongList getSonglist() {
		return songlist;
	}
	public void setSonglist(SongList songlist) {
		this.songlist = songlist;
	}
	

}
