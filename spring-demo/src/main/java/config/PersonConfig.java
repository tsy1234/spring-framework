package config;

import bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:personConfig.properties"})
public class PersonConfig {

	@Bean
	public Person person2() {

		Person p = new Person();
		p.setAge(22);
		p.setName("sandy");

		return p;
	}
}
