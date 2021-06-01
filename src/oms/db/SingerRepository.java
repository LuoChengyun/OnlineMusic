package oms.db;

import java.util.List;

import oms.domain.Singer;
import oms.web.PaginationSupport;

public interface SingerRepository {
	
	/**
	 * 取得用户数量
	 * 
	 * @return
	 */
	long singerCount();
	
	/**
	 * 新建一个用户
	 * 
	 * @param user
	 *            新建的用户
	 * @return 用户
	 */
	Singer save(Singer singer);
	
	/**
	 * 依据id查找用户
	 * 
	 * @param id
	 *            用户ID
	 * @return 用户
	 */
	Singer findOne(long id);
	/**
	 * 查找id前5位的歌手
	 */
	List<Singer> findFirstFive();


	/**
	 * 依据用户名（登录名）查找用户
	 * 
	 * @param userName
	 *            用户名（登录名）
	 * @return 用户	
	 */
	Singer findBySingerName(String firstName);
	/**
	 * 取得全部用户
	 * 
	 * @return 全部用户
	 */
	List<Singer> findAll();
	/**
	 * 通过用户ID修改用户
	 * @param id
	 * @return
	 */
	Singer alterSinger(Singer singer );
	/**
	 * 增加歌手
	 * @param singer
	 * @return
	 */
	int addSinger(Singer singer);
	/**
	 * 通过用户ID删除用户
	 * @param id
	 * @return
	 */
	int deleteBySingerId(long id);
	
	/**
	 * 依据页码和指定页面大小，返回用户列表
	 */
	PaginationSupport<Singer> findPage(int pageNo,int pageSize);
	/**
	 * 依据页码和指定页面大小，返回用户列表
	 */
	PaginationSupport<Singer> findPageBySingerName(int pageNo,int pageSize,String singerName);
	
	
	

}
