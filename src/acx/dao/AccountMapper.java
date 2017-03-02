package acx.dao;


import acx.entity.Account;

public interface AccountMapper extends BaseMapper {
	public Account login(Account account);
   
}