/**
 * Siyu Tao
 * Copyright (c) 2015-2022 All Rights Reserved.
 */
package siyu.rpc.rpcclient;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * RpcReference 工厂bean
 */
public class RpcReferenceBean implements FactoryBean<Object> {

	private Object object;

	private Class<?> type;

	private String uniqueId;


	/**
	 * 生成代理对象 替换object
	 */
	private void init() {
		this.object = Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[]{type}, new RpcReferenceInvocationHandler(uniqueId));
		System.out.printf("[RpcReferenceBean::init] 服务 %s 代理对象已生成%n", uniqueId);
	}

	@Override
	public Object getObject() throws Exception {
		return this.object;
	}

	@Override
	public Class<?> getObjectType() {
		return this.type;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	/**
	 * Setter method for property <tt>object</tt>.
	 *
	 * @param object value to be assigned to property object
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * Setter method for property <tt>type</tt>.
	 *
	 * @param type value to be assigned to property type
	 */
	public void setType(Class<?> type) {
		this.type = type;
	}

	/**
	 * Setter method for property <tt>uniqueId</tt>.
	 *
	 * @param uniqueId value to be assigned to property uniqueId
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
}
