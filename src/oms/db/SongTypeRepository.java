package oms.db;

import java.util.List;

import oms.domain.SongType;
import oms.domain.User;
import oms.web.PaginationSupport;

public interface SongTypeRepository {

	/**
	 * 获取分类数量
	 * @return
	 */
	long SongTypeCount();
	/**
	 * 
	 * @param id
	 * @return
	 */
	SongType findOne(long id);
	/**
	 * 新建分类
	 * @param songtype
	 * @return
	 */
	
	SongType save(SongType songtype);
	/**
	 * 根据分类名搜索分类
	 * @param name
	 * @return
	 */
	SongType findBySongTypeName(String name);
	/**
	 * 删除分类
	 * @param id 分类id
	 * @return
	 */
	int deleteSongType(long id);
	/**
	 * 修改分类
	 * @param songtype 分类
	 * @return
	 */
	SongType altersongType(SongType songtype);
	/**
	 * 列出所有分类
	 * @return
	 */
	List<SongType> findAll();
	/**
	 * 分类列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PaginationSupport<SongType> findPage(int pageNo,int pageSize);
	
	
	

}
