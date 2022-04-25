package siyu.circulardependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import service.AccountService;

@Configuration
@ComponentScan(value = {"service", "aop.aspect", "siyu"})
@EnableAspectJAutoProxy
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Main.class);
		context.refresh();

		CircularA a = (CircularA) context.getBean("circularA");
		a.hello();

//		AccountService service = (AccountService) context.getBean("accountServiceImpl");
//		service.transfer();
	}
}
