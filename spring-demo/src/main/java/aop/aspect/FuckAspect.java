package aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FuckAspect {

	@Before("execution(public * service.AccountService.transfer())")
	public void fuck() {
		System.out.println("fuck aop");
	}

	@After("execution(public * siyu.circulardependency.CircularA.hello())")
	public void fuckCircular() {
		System.out.println("fuck circular");
	}
}
