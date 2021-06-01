package oms.db;

import java.util.List;

import oms.domain.Song;
import oms.domain.SongList;
import oms.web.PaginationSupport;

public interface SongListRepository {
	
	/**
	 * 取得歌单数量
	 * 
	 * @return
	 */
	long count();
	/**
	 * 添加歌单
	 * 
	 * @param songList
	 *         添加的歌单
	 * @return 歌单
	 */
	SongList save(SongList songList);

	/**
	 * 依据id查找歌单
	 * 
	 * @param id
	 *            歌单ID
	 * @return 歌单
	 */
	SongList findOne(long id);

	
	/**
	 * 取得全部歌单
	 * 
	 * @return 全部歌单
	 */
	List<SongList> findAll();
    /**
     * 根据id删除歌单
     * 
     * @param id
     */
	void deleteSongList(long id);
	/**
	 * 根据歌单ID修改歌单
	 * @param id
	 * @return
	 */
	int alterSongList(long id);
	
    /**
     * 依据页码和指定页面大小，返回歌单列表
     * @param pageNo
     * @param pageSize
     * @return 分页对象
     */
	PaginationSupport<SongList> findPage(int pageNo, int pageSize,long userId);

}
