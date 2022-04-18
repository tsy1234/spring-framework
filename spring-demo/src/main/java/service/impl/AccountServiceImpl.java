package service.impl;

import service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Override
	public void transfer() {
		// pointcut 身份验证
		System.out.println("转账");
	}
}
