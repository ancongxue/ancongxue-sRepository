package acx.service;


import acx.entity.Account;

public interface AccountService extends BaseService<Account>{

	public Account login(Account account);
}
