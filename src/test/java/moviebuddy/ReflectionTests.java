package moviebuddy;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class ReflectionTests {

	@Test
	void objectCreateAndMethodCall() throws Exception {
		// Without relfection
		Duck duck = new Duck();
		duck.quack();
		
		// With reflection
		Class<?> duckClass = Class.forName("moviebuddy.ReflectionTests$Duck");
		Object duckObject = duckClass.getDeclaredConstructor().newInstance();
		Method quackMethod = duckObject.getClass().getDeclaredMethod("quack", new Class<?>[0]);
		quackMethod.invoke(duckObject);
	}
	
	static class Duck {
		void quack() {
			System.out.println("꽥꽥!");
		}
	}
	
}
