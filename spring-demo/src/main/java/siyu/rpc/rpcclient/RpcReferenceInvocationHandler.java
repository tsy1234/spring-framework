/**
 * Siyu Tao
 * Copyright (c) 2015-2022 All Rights Reserved.
 */
package siyu.rpc.rpcclient;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * RpcReference代理对线invoke handler
 */
public class RpcReferenceInvocationHandler implements InvocationHandler {

	private String uniqueId;

	RpcReferenceInvocationHandler(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return null;
	}
}
