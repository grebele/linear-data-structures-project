package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project2.classes.ArrayVector;
import project2.exceptions.InvalidRankException;
import project2.interfaces.Vector;

public class ArrayVectorTest {

	@Test
	public void test1() {
		Vector<Integer> vector = new ArrayVector<>();

		assertEquals(0, vector.size());
		assertTrue(vector.isEmpty());

		// 1
		vector.insertAtRank(0, 1);
		assertEquals(1, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(1, (int) vector.elemAtRank(0));

		// 1 2
		vector.insertAtRank(1, 2);
		assertEquals(2, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(1, (int) vector.elemAtRank(0));
		assertEquals(2, (int) vector.elemAtRank(1));

		// 1 2 3
		vector.insertAtRank(2, 3);
		assertEquals(3, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(1, (int) vector.elemAtRank(0));
		assertEquals(2, (int) vector.elemAtRank(1));
		assertEquals(3, (int) vector.elemAtRank(2));

		// 4 1 2 3
		vector.insertAtRank(0, 4);
		assertEquals(4, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(4, (int) vector.elemAtRank(0));
		assertEquals(1, (int) vector.elemAtRank(1));
		assertEquals(2, (int) vector.elemAtRank(2));
		assertEquals(3, (int) vector.elemAtRank(3));

		// 4 5 1 2 3
		vector.insertAtRank(1, 5);
		assertEquals(5, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(4, (int) vector.elemAtRank(0));
		assertEquals(5, (int) vector.elemAtRank(1));
		assertEquals(1, (int) vector.elemAtRank(2));
		assertEquals(2, (int) vector.elemAtRank(3));
		assertEquals(3, (int) vector.elemAtRank(4));

		// 4 5 6 1 2 3
		vector.insertAtRank(2, 6);
		assertEquals(6, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(4, (int) vector.elemAtRank(0));
		assertEquals(5, (int) vector.elemAtRank(1));
		assertEquals(6, (int) vector.elemAtRank(2));
		assertEquals(1, (int) vector.elemAtRank(3));
		assertEquals(2, (int) vector.elemAtRank(4));
		assertEquals(3, (int) vector.elemAtRank(5));

		// 5 6 1 2 3
		vector.removeAtRank(0);
		assertEquals(5, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(5, (int) vector.elemAtRank(0));
		assertEquals(6, (int) vector.elemAtRank(1));
		assertEquals(1, (int) vector.elemAtRank(2));
		assertEquals(2, (int) vector.elemAtRank(3));
		assertEquals(3, (int) vector.elemAtRank(4));

		// 5 6 1 2
		vector.removeAtRank(4);
		assertEquals(4, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(5, (int) vector.elemAtRank(0));
		assertEquals(6, (int) vector.elemAtRank(1));
		assertEquals(1, (int) vector.elemAtRank(2));
		assertEquals(2, (int) vector.elemAtRank(3));

		// 5 6 7 2
		vector.replaceAtRank(2, 7);
		assertEquals(4, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(5, (int) vector.elemAtRank(0));
		assertEquals(6, (int) vector.elemAtRank(1));
		assertEquals(7, (int) vector.elemAtRank(2));
		assertEquals(2, (int) vector.elemAtRank(3));

		// 2 6 7 5
		vector.swapAtRanks(0, 3);
		assertEquals(4, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(2, (int) vector.elemAtRank(0));
		assertEquals(6, (int) vector.elemAtRank(1));
		assertEquals(7, (int) vector.elemAtRank(2));
		assertEquals(5, (int) vector.elemAtRank(3));

		// 2 6 7
		vector.removeAtRank(3);
		assertEquals(3, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(2, (int) vector.elemAtRank(0));
		assertEquals(6, (int) vector.elemAtRank(1));
		assertEquals(7, (int) vector.elemAtRank(2));

		// 6 7
		vector.removeAtRank(0);
		assertEquals(2, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(6, (int) vector.elemAtRank(0));
		assertEquals(7, (int) vector.elemAtRank(1));

		// 7
		vector.removeAtRank(0);
		assertEquals(1, vector.size());
		assertFalse(vector.isEmpty());
		assertEquals(7, (int) vector.elemAtRank(0));

		//
		vector.removeAtRank(0);
		assertEquals(0, vector.size());
		assertTrue(vector.isEmpty());
	}

	@Test
	public void test2() {
		Vector<String> vector = new ArrayVector<>();
		for (int k = 1; k <= 2; k++) {
			for (int i = 1; i <= 100; i++) {
				vector.insertAtRank(0, "" + i);
				assertEquals("" + i, vector.elemAtRank(0));
			}
			assertEquals(100, vector.size());
			for (int i = 100; i >= 1; i--) {
				assertEquals("" + i, vector.elemAtRank(0));
				vector.removeAtRank(0);
			}
			assertEquals(0, vector.size());
		}
	}

	@Test(expected = InvalidRankException.class)
	public void test4() {
		Vector<String> vector = new ArrayVector<>();
		vector.elemAtRank(10);
	}

	@Test(expected = InvalidRankException.class)
	public void test5() {
		Vector<String> vector = new ArrayVector<>();
		vector.insertAtRank(10, "123");
	}

	@Test(expected = InvalidRankException.class)
	public void test6() {
		Vector<String> vector = new ArrayVector<>();
		vector.removeAtRank(10);
	}

	@Test(expected = InvalidRankException.class)
	public void test7() {
		Vector<String> vector = new ArrayVector<>();
		vector.replaceAtRank(10, "123");
	}

	@Test(expected = InvalidRankException.class)
	public void test8() {
		Vector<String> vector = new ArrayVector<>();
		vector.insertAtRank(0, "0");
		vector.insertAtRank(1, "1");
		vector.swapAtRanks(0, 10);
	}
}
