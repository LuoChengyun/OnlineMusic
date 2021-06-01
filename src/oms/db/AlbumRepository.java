package oms.db;

import java.util.List;


import oms.domain.*;
import oms.web.PaginationSupport;

public interface AlbumRepository {
	
	/**
	 * 获取专辑数量
	 */
	long albumCount();
	
	/**
	 * 查找专辑
	 * @param id
	 * @return
	 */
	Album findOne(long id);
	/**
	 * 查找最新的四张专辑
	 * @return
	 */
	List<Album> findLastFive();
	
	/**
	 * 新建专辑
	 * @param album
	 * @return
	 */
	Album save(Album album);
	
	/**
	 * 修改专辑
	 * @param album
	 * @return
	 */
	Album alterAlbum(Album album);
	
	/**
	 * 删除专辑
	 * @param id
	 * @return
	 */
	int deleteAlbum(long id);
	
	/**
	 * 分页列出所有专辑
	 * @return
	 */
	PaginationSupport<Album> findPage(int pageNo, int pageSize);
	
	/**
	 * 根据专辑名查找专辑列表
	 * @param albumName
	 * @return
	 */
	PaginationSupport<Album> findPageByAlbumName(int pageNo, int pageSize,String albumName);
	
	/**
	 * 根据歌手名查找专辑列表
	 * @param singerName
	 * @return
	 */
	PaginationSupport<Album> findPageBySingerName(int pageNo, int pageSize,String singerName);

	/**
	 * 通过专辑名查找
	 * @param albumName
	 * @return
	 */
	Album findByAlbumName(String albumName);
	
	
	
	
	
	

}
