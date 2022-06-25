/**
 * Siyu Tao
 * Copyright (c) 2015-2022 All Rights Reserved.
 */
package siyu.rpc.rpcclient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * RpcReference代理对象invoke handler
 */
public class RpcReferenceInvocationHandler implements InvocationHandler {

	/** 服务uniqueId */
	private String uniqueId;

	RpcReferenceInvocationHandler(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * 生成RpcRequest，通过RpcNetTransport发送
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		RpcRequest request = new RpcRequest();
		request.setUniqueId(uniqueId);
		request.setMethodName(method.getName());
		request.setArgs(args);
		request.setArgsType(method.getParameterTypes());

		return RpcNetTransport.send(request, "127.0.0.1", 8888);
	}
}
