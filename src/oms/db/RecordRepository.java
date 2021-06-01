package oms.db;

import oms.web.PaginationSupport;
import oms.domain.Record;

public interface RecordRepository {
	/**
	 * 登录信息总条数
	 * @return
	 */
	public long recordCount();
	/**
	 * 保存登录信息
	 * @param record
	 */
	void save(Record record);

	/**
	 * 分页显示登录信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PaginationSupport<Record> findPage(int pageNo, int pageSize);
	/**
	 * 根据给定用户名显示登录信息
	 * @param pageNo
	 * @param pageSize
	 * @param userName
	 * @return
	 */
	PaginationSupport<Record> findPageByName(int pageNo, int pageSize, String userName);

}
