/**
 * Siyu Tao
 * Copyright (c) 2015-2022 All Rights Reserved.
 */
package siyu.rpc.rpcclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

/**
 * rpc请求发送
 */
public class RpcNetTransport {

	/**
	 * 发送rpc请求
	 */
	public static Object send(RpcRequest request, String address, int port) {

		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;

		try {
			Socket socket = new Socket(address, port);

			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject(request);
			// 将缓冲中的数据向目的地发送（磁盘，网络等）
			outputStream.flush();

			inputStream = new ObjectInputStream(socket.getInputStream());

			return inputStream.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeStream(inputStream, outputStream);
		}
		return null;
	}

	private static void closeStream(InputStream inputStream, OutputStream outputStream) {
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
