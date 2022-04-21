import bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"bean", "aop", "service", "config"})
public class DemoAnnotation {
	public static void main(String[] args) {
		// 这里会先加载4个类到beanFactory内
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DemoAnnotation.class); // 这里在加载配置类到beanFactory
		context.refresh();

		Person person = (Person) context.getBean("person");
		System.out.println(person.toString());
	}
}
