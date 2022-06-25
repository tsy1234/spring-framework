package siyu.rpc.rpcserver;

import siyu.rpc.rpcclient.RpcRequest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Mediator {

	/** key与bean映射 */
	public static Map<String, Object> ROUTER = new HashMap<>();

	private static volatile Mediator mediator;

	/** 双重检查锁获取实例 这为什么不直接bean呢? */
	public static Mediator getInstance() {
		if (mediator == null) {
			synchronized (Mediator.class) {
				if (mediator == null) {
					mediator = new Mediator();
				}
			}
		}
		return mediator;
	}

	/**
	 * mediator中介 代为进行服务的调用
	 *
	 * 根据请求中的uniqueId获取对应的bean
	 * 根据methodName去使用反射直接invoke
	 * 返回对应结果
	 *
	 * @param request
	 * @return
	 */
	public Object process(RpcRequest request) {

		String uniqueId = request.getUniqueId();
		String methodName = request.getMethodName();
		Object[] args = request.getArgs();

		Object targetServiceBean = Mediator.ROUTER.get(uniqueId);

		Class<?> clazz = targetServiceBean.getClass();

		Object result = null;
		try {
			Method method = clazz.getMethod(methodName);
			result = method.invoke(targetServiceBean, args);

		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return result;
	}
}
