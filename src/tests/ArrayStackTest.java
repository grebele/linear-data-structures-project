package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project2.classes.ArrayStack;
import project2.exceptions.EmptyStackException;
import project2.interfaces.Stack;

public class ArrayStackTest {

	@Test
	public void test1() {
		Stack<Integer> stack = new ArrayStack<>();

		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());

		// 1
		stack.push(1);
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals(1, (int) stack.top());

		// 1 2
		stack.push(2);
		assertEquals(2, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals(2, (int) stack.top());

		// 1 2 3
		stack.push(3);
		assertEquals(3, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals(3, (int) stack.top());

		// 1 2
		stack.pop();
		assertEquals(2, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals(2, (int) stack.top());

		// 1
		stack.pop();
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals(1, (int) stack.top());

		//
		stack.pop();
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}

	@Test
	public void test2() {
		Stack<String> stack = new ArrayStack<>();
		for (int k = 1; k <= 2; k++) {
			for (int i = 1; i <= 100; i++) {
				stack.push("" + i);
				assertEquals("" + i, stack.top());
			}
			assertEquals(100, stack.size());
			for (int i = 100; i >= 1; i--) {
				assertEquals("" + i, stack.top());
				stack.pop();
			}
			assertEquals(0, stack.size());
		}
	}

	@Test(expected = EmptyStackException.class)
	public void test3() {
		Stack<String> stack = new ArrayStack<>();
		stack.pop();
	}

	@Test(expected = EmptyStackException.class)
	public void test4() {
		Stack<String> stack = new ArrayStack<>();
		stack.top();
	}

}
