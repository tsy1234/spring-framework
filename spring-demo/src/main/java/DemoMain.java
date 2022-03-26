import bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo.xml");
		Person person = context.getBean(Person.class);
		System.out.println(person.getName());
	}
}
