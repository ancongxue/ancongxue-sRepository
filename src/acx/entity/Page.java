package acx.entity;

import java.io.Serializable;
import java.util.List;

/*
 * 定义一个page类，将T的页面展示相关的所有的内容，全部封装在这里面，后面尽管调用page就可以了
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 703240027635386191L;
	private Integer page = 1 ;		//当前是第几页
	private Integer rows = 10;		//每页显示的条数
	private Integer start;			//当前页是从哪条数据开始的
	
	private List<T> list; 			//当前页显示的数据列表	
	private Integer total;			//总记录数
	
	private String keyWord;			//关键字查询
	private T paramEntity;			//多条件查询，其实就是一个有特定属性值的T，把这个T的属性值当作查询条件
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getStart() {
		return start =(page -1)*rows;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public T getParamEntity() {
		return paramEntity;
	}
	public void setParamEntity(T paramEntity) {
		this.paramEntity = paramEntity;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}
