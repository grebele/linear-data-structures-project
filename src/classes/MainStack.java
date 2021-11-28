package classes;

import interfaces.Stack;

public class MainStack {
	public static void main(String args[]) {
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Example of saving a text writing history, to show the function of the ArrayStack Class.");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Initialise a new Stack of the Type String");
		Stack<String> stack = new ArrayStack<>();
		System.out.println("Check the size of the stack and look if stack is empty:");
		System.err.println("Size: " + stack.size() + "       | " + " expected = 0");
		System.err.println("Empty: " + stack.isEmpty() + "   | " + " expected = true");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Push 'Last' ");
		stack.push("Last");;
		System.out.println(stack);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Push 'in' ");
		stack.push("in");
		System.out.println(stack);		
		System.out.println("-------------------------------------------------------------------------------");
		System.err.println("Cave: the capacity should double now");
		System.out.println("-> Push 'first' ");
		stack.push("first");
		System.out.println(stack);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Push 'aut' ");
		stack.push("aut");
		System.out.println(stack);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Get element on top ");
		System.err.println("top(): " + stack.top() + "   | expected: ");
		System.out.println(stack);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Pop integer from the stack");
		stack.pop();
		System.out.println(stack);
		System.err.println("Expected: [elements=[Last, in, first, aut] The String 'aut' will be overwritten with the next push ");
		System.err.println("top(): " + stack.top() + " | expected: 3");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> push out");
		stack.push("out");
		System.out.println(stack);
		System.out.println("-------------------------------------------------------------------------------");
		System.err.println("Size: " + stack.size() + "      | " + " expected = 4");
		System.err.println("Empty: " + stack.isEmpty() + " | " + " expected = false");
	}
}
