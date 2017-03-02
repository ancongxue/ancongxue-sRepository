package acx.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import acx.dao.AccountMapper;
import acx.dao.BaseMapper;
import acx.dao.BuyOrderMapper;
import acx.dao.SupplierMapper;
import acx.entity.Page;
import acx.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	protected AccountMapper accountMapper;
	@Autowired
	protected SupplierMapper supplierMapper;
	@Autowired
	protected BuyOrderMapper buyOrderMapper;
	protected BaseMapper<T> baseMapper;

	@Autowired
	@PostConstruct // 在构造方法后，初化前执行
	protected void initBaseMapper() throws Exception {
		//this指对象本身，这里是指实现类，即子类，例如SupplerServiceImpl
		//获取带有泛型的父类,即BaseServiceImpl<Supplier>
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获取父类所含的泛型的第一个泛型，泛型可能有多个的。。。这里得到类Supplier
		Class clazz = (Class) type.getActualTypeArguments()[0];		
		//泛型首字母小写，拼接Mapper，得到了supplierMapper
		String localField = clazz.getSimpleName().substring(0, 1).toLowerCase() 
				+ clazz.getSimpleName().substring(1)+ "Mapper";
		//获取父类的supplierMapper属性
		Field field = this.getClass().getSuperclass().getDeclaredField(localField);
		//获取父类baseMapper属性
		Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
		//field.get(this)-->拿到SupplierServiceImpl的supplierMapper属性的值
		//baseField.set(this,value)-->把SupplierServiceImpl的supplierMapper属性的值
		//赋给baseMapper属性
		baseField.set(this, field.get(this));

	}

	@Override
	public int insert(T entity) {
		return baseMapper.insert(entity);
	}

	@Override
	public int deleteByPK(T entity) {
		return baseMapper.deleteByPK(entity);
	}

	@Override
	public int updateByPK(T entity) {
		return baseMapper.updateByPK(entity);

	}

	@Override
	public List<T> select(T entity) {
		return baseMapper.select(entity);
	}

	@Override
	public Page<T> selectPage(Page<T> page) {
		//按搜索条件，查询出List<T>
		List<T> baseList=baseMapper.selectPageList(page);
		//按搜索条件，查询出T的总数
		int total= baseMapper.selectCount(page);
		//将得出的List<T>,T总数，再赋回给page
		page.setList(baseList);
		page.setTotal(total);
		//此时返回的page已经承载了supplier页面展示的有用信息，包括List<supplier>:有此page,页面不愁！
		return page;
	}

	@Override
	public int deleteByPK(String[] pks) {
		return baseMapper.deleteByPK(pks);
	}

}
