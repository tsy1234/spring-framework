package siyu.rpc.rpcserver;

import siyu.rpc.rpcclient.RpcRequest;

import java.util.HashMap;
import java.util.Map;

public class Mediator {

	/** key与bean映射 */
	public static Map<String, Object> ROUTER = new HashMap<>();

	private static volatile Mediator mediator;

	/** 双重检查锁获取实例 这为什么不直接bean呢? */
	public Mediator getInstance() {
		if (mediator == null) {
			synchronized (Mediator.class) {
				if (mediator == null) {
					mediator = new Mediator();
				}
			}
		}
		return mediator;
	}

	/** mediator中介 代为进行服务的调用 */
	public Object process(RpcRequest request) {
		return null;
	}
}
