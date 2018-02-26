package zweek13;

/**
 * This code illustrates use of Stack
 * @author java
 *
 */

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {

		Stack<String> stack = new Stack<>();
		stack.push("hello");
		stack.push("Toroto");
		stack.push("Ontario");
		stack.push("Canada");
		
		while (!stack.isEmpty()){
			System.out.println(stack.pop());
		}

	}

}
