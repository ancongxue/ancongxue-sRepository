package acx.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

public class sysIntServlet extends HttpServlet{
	
	public void init(){
		Map<String, String> supType= new HashMap<String,String>();
		Map<String, String> goodsColor= new HashMap<String,String>();
		Map<String, Object> sysParam= new HashMap<String,Object>();
		
		supType.put("1", "普通供应商");
    	supType.put("2", "一级供应商");
    	supType.put("3", "二级供应商");
    	
    	goodsColor.put("red", "红色");
    	goodsColor.put("green", "绿色");
    	goodsColor.put("blue", "蓝色"); 
    	
    	sysParam.put("goodsColor", goodsColor);
    	sysParam.put("supType", supType);
    	
    	ServletContext application = this.getServletContext();
    	application.setAttribute("sysParam", sysParam);
		
	}

}
