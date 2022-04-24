package siyu.circulardependency;

import bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("demo.xml");
		CircularA circularA = context.getBean(CircularA.class);
		circularA.hello();
	}

}
