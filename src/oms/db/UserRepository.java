package oms.db;

import java.util.List;
import oms.web.PaginationSupport;

import oms.domain.User;

/**
 * 用户资源库接口
 * 
 * @author nwx
 * @version v1.0
 */
public interface UserRepository {

	/**
	 * 取得用户数量
	 * 
	 * @return
	 */
	long userCount();
	
	/**
	 * 新建一个用户
	 * 
	 * @param user
	 *            新建的用户
	 * @return 用户
	 */
	User save(User user);
	
	/**
	 * 依据id查找用户
	 * 
	 * @param id
	 *            用户ID
	 * @return 用户
	 */
	User findOne(long id);

	/**
	 * 依据用户名（登录名）查找用户
	 * 
	 * @param userName
	 *            用户名（登录名）
	 * @return 用户	
	 */
	User findByUserName(String userName);
	
	/**
	 * 依据用户名（登录名），密码查找用户
	 * 
	 * @param userName
	 *            用户名（登录名）
	 * @param password
	 *            密码
	 * @return 用户
	 */
	User findByUserName(String userName, String password);

	/**
	 * 取得全部用户
	 * 
	 * @return 全部用户
	 */
	List<User> findAll();
	/**
	 * 通过用户ID修改用户
	 * @param id
	 * @return
	 */
	User alterUser(User user );
	/**
	 * 通过用户ID删除用户
	 * @param id
	 * @return
	 */
	int deleteByUserId(long id);
	/**
	 * 禁用用户
	 * @param id
	 * @return
	 */
	int checkUser(long id);
	/**
	 * 依据页码和指定页面大小，返回用户列表
	 */
	PaginationSupport<User> findPage(int pageNo,int pageSize);
	
	PaginationSupport<User> findPageByUserName(int pageNo,int pageSize,String userName);

	User alterManager(User user);
	
	

}
