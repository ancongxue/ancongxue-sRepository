package acx.dao;

import java.util.List;

import acx.entity.Page;

public interface BaseMapper<T> {
   
	public int insert(T entity);
	
	public int deleteByPK(T entity);
	
	public int updateByPK(T entity);
	
	public List<T> select(T entity);
	
	//公用的，查询当前页T的方法
	public List<T> selectPageList(Page<T> page);
	
	//公用的，查询T总数的方法
	public int selectCount(Page<T> page);
	
	//公用的，按主键，批量删除操作
	public int deleteByPK(String[] pks);
	
}