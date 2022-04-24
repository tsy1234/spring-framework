package siyu.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularB {

	@Autowired
	private CircularA circularA;

	public void hello() {
		System.out.println("this is B");
	}

	public void setCircularA(CircularA circularA) {
		this.circularA = circularA;
	}
}
