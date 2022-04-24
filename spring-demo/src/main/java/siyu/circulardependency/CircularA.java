package siyu.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularA {

	@Autowired
	private CircularB circularB;

	public void hello() {
		circularB.hello();
		System.out.println("this is a");
	}

	public void setCircularB(CircularB circularB) {
		this.circularB = circularB;
	}
}
