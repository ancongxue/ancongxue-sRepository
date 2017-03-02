package acx.service.impl;

import org.springframework.stereotype.Service;
import acx.entity.Account;
import acx.service.AccountService;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{

	@Override
	public Account login(Account account) {
	
		return accountMapper.login(account);
	}




}
