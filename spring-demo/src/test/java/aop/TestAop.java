package aop;

import aop.advice.AccountIdentityAdvice;
import org.springframework.aop.framework.ProxyFactory;
import service.AccountService;
import service.impl.AccountServiceImpl;

import java.lang.reflect.Proxy;

public class TestAop {

	public static void main(String[] args) {
		// 创建代理工厂
		ProxyFactory factory = new ProxyFactory();
		// 配置目标对象
		factory.setTarget(new AccountServiceImpl());
		// 配置增强advice
		factory.addAdvice(new AccountIdentityAdvice());

		AccountService service = (AccountService) factory.getProxy();
		service.transfer();

	}

}
