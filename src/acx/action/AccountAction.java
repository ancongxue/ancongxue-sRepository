package acx.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acx.entity.Account;
import acx.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountAction {
	
	@Resource
	private AccountService accountService;
	
	//用户登陆
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,HttpSession session,Account account){
		System.out.println("---action.account:"+account);
		try {
			Account acc = accountService.login(account);
			if(acc!=null){
				session.setAttribute("account", acc);			
			}else{
				request.setAttribute("errMsg", "用户名或密码有错！");
				return "forward:/login.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:/WEB-INF/jsp/main.jsp";
	}

}
