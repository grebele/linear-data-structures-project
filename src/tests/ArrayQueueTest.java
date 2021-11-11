package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project2.classes.ArrayQueue;
import project2.exceptions.EmptyQueueException;
import project2.interfaces.Queue;

public class ArrayQueueTest {

	@Test
	public void test1() {
		Queue<Integer> queue = new ArrayQueue<>();

		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());

		// 1
		queue.enqueue(1);
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
		assertEquals(1, (int) queue.front());

		// 2 1
		queue.enqueue(2);
		assertEquals(2, queue.size());
		assertFalse(queue.isEmpty());
		assertEquals(1, (int) queue.front());

		// 3 2 1
		queue.enqueue(3);
		assertEquals(3, queue.size());
		assertFalse(queue.isEmpty());
		assertEquals(1, (int) queue.front());

		// 3 2
		queue.dequeue();
		assertEquals(2, queue.size());
		assertFalse(queue.isEmpty());
		assertEquals(2, (int) queue.front());

		// 3
		queue.dequeue();
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
		assertEquals(3, (int) queue.front());

		//
		queue.dequeue();
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
	}

	@Test
	public void test2() {
		Queue<String> queue = new ArrayQueue<>();
		for (int k = 1; k <= 2; k++) {
			for (int i = 1; i <= 100; i++) {
				queue.enqueue("" + i);
				assertEquals("1", queue.front());
			}
			assertEquals(100, queue.size());
			for (int i = 1; i <= 100; i++) {
				assertEquals("" + i, queue.front());
				queue.dequeue();
			}
			assertEquals(0, queue.size());
		}
	}

	@Test(expected = EmptyQueueException.class)
	public void test3() {
		Queue<String> queue = new ArrayQueue<>();
		queue.dequeue();
	}

	@Test(expected = EmptyQueueException.class)
	public void test4() {
		Queue<String> queue = new ArrayQueue<>();
		queue.front();
	}

}
