/**
 * Siyu Tao
 * Copyright (c) 2015-2022 All Rights Reserved.
 */
package siyu.rpc.rpcserver;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * socket监听器 当容器启动或refresh后会自动开始监听
 */
@Component
public class SocketListener implements ApplicationListener<ContextRefreshedEvent> {

	private final ExecutorService executor = Executors.newCachedThreadPool();

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		ServerSocket serverSocket = null;

		try {
			// 初始化服务端socket 绑定8888端口
			serverSocket = new ServerSocket(8888);

			while (true) {
				// 等待客户端连接 阻塞性质
				System.out.println("fuck");
				Socket socket = serverSocket.accept();
				executor.submit(new SocketServiceProcessHandler(socket));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
