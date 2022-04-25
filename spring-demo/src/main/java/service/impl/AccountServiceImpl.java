package service.impl;

import org.springframework.stereotype.Service;
import service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Override
	public void transfer() {
		// pointcut 身份验证
		System.out.println("转账");
	}
}
