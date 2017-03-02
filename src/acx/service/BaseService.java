package acx.service;

import java.util.List;

import acx.entity.Page;

public interface BaseService<T> {

	public int insert(T entity);
	
	public int deleteByPK(T entity);
	
	public int  updateByPK(T entity);
	
	public List<T> select(T entity);
	
	//公用的，对page进行操作，返回我们想要的，承载着所有T的页面展示信息的，page的方法
	public Page<T> selectPage(Page<T> page);
	
	//批量，按主键删除，返回删除数量
	public int deleteByPK(String[] pks);
	
}
