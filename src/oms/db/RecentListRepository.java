package oms.db;

import java.util.List;

import oms.domain.RecentList;
import oms.domain.SongList;
import oms.domain.User;
import oms.web.PaginationSupport;

public interface RecentListRepository {
	
	/**
	 * 取得特定用户最近播放内歌曲的数量
	 * 
	 * @return
	 */
	long count(long userId);
	/**
	 * 添加歌单歌曲
	 * @param songList
	 *         添加的歌单
	 */
	void save(RecentList recentList);

	/**
	 * 依据id查找最近播放的实体
	 * 
	 * @param id
	 *            歌单ID
	 * @return 歌单
	 */
	RecentList findOne(long id);

	
	/**
	 * 取得全部歌单
	 * 
	 * @return 全部歌单
	 */
	List<RecentList> findAll();
    /**
     * 根据id删除歌单
     * 
     * @param id
     */
	void deleteRecentList(long id);
	/**
	 * 根据歌单ID修改歌单
	 * @param id
	 * @return
	 */
	int alterRecentList(long id);
	
    /**
     * 依据页码和指定页面大小，返回特定用户的最近列表
     * @param pageNo
     * @param pageSize
     * @return 分页对象
     */
	PaginationSupport<RecentList> findPage(int pageNo, int pageSize,long userId);
	
    /**
     * 依据页码和指定页面大小，搜索特定用户给出歌名的列表
     * @param pageNo
     * @param pageSize
     * @return 分页对象
     */
	PaginationSupport<RecentList> findPageByName(int pageNo, int pageSize,long userId,String songName);

}
