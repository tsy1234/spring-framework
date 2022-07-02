package siyu.rpc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import siyu.rpc.service.PersonService;
import siyu.rpc.service.RpcTestBean;
import siyu.rpc.service.impl.StudentServiceImpl;

@ComponentScan(value = "siyu.rpc")
@Configuration
@PropertySource(value = {"classpath:rpcTransport.properties"})
public class RpcMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RpcMain.class);
		RpcTestBean rpcTestBean = (RpcTestBean) context.getBean("rpcTestBean");
		rpcTestBean.test();
	}
}
