package com.xe.b2b.data.access.dao.base;


import com.xe.b2b.data.common.util.Page;

import java.util.List;
import java.util.Map;

/**
 * 共有的mapper方法
 * @author lijk
 * @date 2015-10-27 下午1:45:24
 * @param <T>
 */
public interface BaseMapper<T> {

	/**
	 * 分页用
	 * @param page
	 * @return
	 */
	List<T> selectByPage(Page<T> page);
	int countByPage(Page<T> page);

	/**
	 * 根据map封装的条件过滤数据
	 * @param params
	 * @return
	 */
	List<T> selectByMap(Map<String, Object> params);

	/**
	 * 根据对象封装的条件过滤数据
	 * @param t
	 * @return
	 */
	List<T> selectModel(T t);

	/**
	 * 根据主键获取记录
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(String id);

	/**
	 * 新增数据
	 * @param t
	 * @return
	 */
	int insert(T t);

	/**
	 * 删除(物理删除)
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(String id);
	
	int isActiveByPrimaryKey(T t);

	/**
	 * 更新数据
	 * @param t
	 * @return
	 */
	int updateByPrimaryKeySelective(T t);


	List<T> paging(T t);
}
