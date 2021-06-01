package oms.db;
/**
 * 歌曲资源库接口
 * 
 * @author Huang Jiaxun
 * @version v1.0
 */
import java.util.List;

import oms.domain.Song;
import oms.web.PaginationSupport;

public interface SongRepository {
	/**
	 * 取得歌曲数量
	 * 
	 * @return
	 */
	long count();
	/**
	 * 添加一首歌曲
	 * 
	 * @param song
	 *         添加的歌曲
	 * @return 歌曲
	 */
	Song save(Song song);

	/**
	 * 依据id查找歌曲
	 * 
	 * @param id
	 *            歌曲ID
	 * @return 歌曲
	 */
	Song findOne(long id);
	/**
	 * 取得播放量前10首的歌
	 * @return  播放量前10首的歌
	 */
	List<Song> findFirstTen();

//	/**
//	 * 依据歌曲名查找歌曲
//	 * 
//	 * @param name
//	 *            歌曲名
//	 * @return 歌曲
//	 */
//	Song findBySongName(String name);
	/**
	 * 根据歌名搜索列表
	 * @param songName
	 * @return
	 */
	PaginationSupport<Song> findBySongName(int pageNo, int pageSize, String songName);
	
	/**
	 * 根据歌手搜索列表
	 * @param singerName
	 * @return
	 */
	PaginationSupport<Song> findBySingerName(int pageNo, int pageSize,String singerName);

	/**
	 * 取得全部歌曲
	 * 
	 * @return 全部歌曲
	 */
	List<Song> findAll();
    /**
     * 根据id删除歌曲
     * 
     * @param id
     */
	void deleteSong(long id);
    /**
     * 依据页码和指定页面大小，返回歌曲列表
     * @param pageNo
     * @param pageSize
     * @return 分页对象
     */
	PaginationSupport<Song> findPage(int pageNo, int pageSize);
	/**
	 * 通过分类搜索歌曲
	 * @param type_id
	 * @return
	 */
	List<Song> findTypeSong(Long type_id);
	
}