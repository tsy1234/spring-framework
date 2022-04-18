package aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AccountIdentityAdvice implements MethodInterceptor {

	@Nullable
	@Override
	public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {

		identity();
		Object result = invocation.proceed();

		return result;
	}

	private void identity() {
		System.out.println("身份验证");
	}
}
