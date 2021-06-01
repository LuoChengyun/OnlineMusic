package oms.db;

import java.util.List;

import oms.domain.CollectList;
import oms.domain.SongList;
import oms.web.PaginationSupport;

public interface CollectListRepository {
	
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
	CollectList save(CollectList collectList);
	/**
	 * 查找
	 * @param id
	 * @return
	 */
	CollectList findOne(long id);
	

    
	
    


}
