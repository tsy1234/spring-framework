package siyu.rpc.rpcclient;

public class RpcRequest {

	/** rpc服务uniqueId */
	private String uniqueId = "";

	/** 调用方法名 */
	private String methodName;

	/** 传递参数 */
	private Object[] args;

	/** 传递参数类型 */
	private Class<?>[] argsType;

	/**
	 * Getter method for property <tt>uniqueId</tt>.
	 *
	 * @return property value of uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Setter method for property <tt>uniqueId</tt>.
	 *
	 * @param uniqueId value to be assigned to property uniqueId
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * Getter method for property <tt>methodName</tt>.
	 *
	 * @return property value of methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * Setter method for property <tt>methodName</tt>.
	 *
	 * @param methodName value to be assigned to property methodName
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * Getter method for property <tt>args</tt>.
	 *
	 * @return property value of args
	 */
	public Object[] getArgs() {
		return args;
	}

	/**
	 * Setter method for property <tt>args</tt>.
	 *
	 * @param args value to be assigned to property args
	 */
	public void setArgs(Object[] args) {
		this.args = args;
	}

	/**
	 * Getter method for property <tt>argsType</tt>.
	 *
	 * @return property value of argsType
	 */
	public Class<?>[] getArgsType() {
		return argsType;
	}

	/**
	 * Setter method for property <tt>argsType</tt>.
	 *
	 * @param argsType value to be assigned to property argsType
	 */
	public void setArgsType(Class<?>[] argsType) {
		this.argsType = argsType;
	}
}
