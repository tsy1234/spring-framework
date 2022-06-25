/**
 * Siyu Tao
 * Copyright (c) 2015-2022 All Rights Reserved.
 */
package siyu.rpc.rpcserver;

import siyu.rpc.rpcclient.RpcRequest;

import java.io.*;
import java.net.Socket;

public class SocketServiceProcessHandler implements Runnable {

	private final Socket socket;

	SocketServiceProcessHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		ObjectInputStream inputStream = null;
		ObjectOutputStream outputStream = null;

		try {
			inputStream = new ObjectInputStream(socket.getInputStream());
			RpcRequest request = (RpcRequest) inputStream.readObject();

			Mediator mediator = Mediator.getInstance();

			Object result = mediator.process(request);

			System.out.printf("服务端调用: %s 服务 %s 方法%n", request.getUniqueId(), request.getMethodName());
			System.out.printf("调用结果: %s %n", result.toString());

			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject(result);
			outputStream.flush();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeStream(inputStream, outputStream);
		}

	}

	private void closeStream(InputStream inputStream, OutputStream outputStream) {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (outputStream != null) {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
