package acx.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import acx.entity.Page;
import acx.entity.Supplier;
import acx.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierAction extends BaseAction {
	
	@Resource
	private SupplierService supplierService;
	
	@RequestMapping("/supplierList")
	public String supplierList(){
		
		return "forward:/WEB-INF/supplier/supplierlist.jsp";
	}
	
	@RequestMapping("/selectPage")
	@ResponseBody
	//这个方法参数中的supplier，在使用时，调用它的jsp页面会先传来两个搜索参数，所以说，是一个有指定参数的supplier
	//此supplier是可以用来做搜索查询条件的
	public Object selectList(Page<Supplier> page, Supplier supplier){
		page.setParamEntity(supplier); //将这个supplier设置为查询条件，此时page有了一个paramEntity参数了
		//被Service这么一搞，page满载信息归来。。。
		page= supplierService.selectPage(page);
		Map<String, Object> pageMap = new HashMap<String, Object>();
		//把page里的T总数、List<T>都放到map里面
		pageMap.put("total", page.getTotal());
		pageMap.put("rows", page.getList());
		//返回这个map,以json的格式
		return pageMap;
	}
	
	//按主键删除
	@RequestMapping("/deleteByPK")
	@ResponseBody	
	public int deleteByPK(String[] pks){		
		return supplierService.deleteByPK(pks);
		
	}
	
	//按主键删除
	@RequestMapping("/insert")
	@ResponseBody	
	public int insert(Supplier supplier){		
		return supplierService.insert(supplier);
		
	}
	
	//按主键更新
	@RequestMapping("/updateByPK")
	@ResponseBody
	public int updateByPK(Supplier supplier){
		return supplierService.updateByPK(supplier);
	}
	

}
