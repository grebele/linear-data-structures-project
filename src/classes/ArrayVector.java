package classes;

import java.lang.reflect.Array;
import java.util.Arrays;
import exceptions.InvalidRankException;
import interfaces.Vector;

public class ArrayVector<E> implements Vector<E> {
	private Object elements[];
	private int size;
	private int n;

	private static final int INITIAL_SIZE = 5;
	private int capacity = INITIAL_SIZE;

	/**
	 * Constructor, initialize Array with given size
	 */
	public ArrayVector() {
		elements = new Object[INITIAL_SIZE];
		size = 0;
	}

	@Override
	/**
	 * returns size of the array
	 */
	public int size() {
		return size;
	}

	/**
	 * counts the elements in array and returns amount
	 * 
	 * @return
	 */
	public int getLength() {
		for (int i = 0; i < Array.getLength(elements); i++) {
			if (elements[i] == null) {
				return i;
			}
		}
		return -1;
	}

	@Override
	/**
	 * check if array is empty -> hasn't any elementens in it return true if array
	 * is empty
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * returns element at rank r, if r is invalid throw exception
	 */
	public E elemAtRank(int r) throws InvalidRankException {

		if (r < 0 || r > capacity) {
			throw new InvalidRankException();
		}

		return (E) elements[r]; // parse and return element
	}

	@Override
	/**
	 * insert element at position r move elements from r to n 1 position left, make
	 * space at position r for new element
	 */
	public void insertAtRank(int r, E e) throws InvalidRankException {

		if (r < 0 || r > capacity) { //rank isn't valid
			throw new InvalidRankException();
		}

		n = size();
		if (isEmpty()) { //array without elements in it
			elements[0] = e;
		} else if (elements[r] == null) { //if position r is null, insert element directly
			elements[r] = e;
		} else if (n + 1 < capacity) { //if array has enough capacity for another element
			for (int i = n - 1; i >= r; i--) { // move elements 1 position 
				E temp = elemAtRank(i);
				elements[i + 1] = temp;
			}
			elements[r] = e;//insert element at position r
		} else { //array isn't big enough, double the capacity
			int newCapacity = capacity * 2;
			Object[] newArr = new Object[newCapacity];
			capacity = capacity * 2;
			// copy elements to new array
			for (int i = 0; i <= r; i++) {
				newArr[i] = elements[i];
			}
			newArr[r] = e;
			for (int i = r + 1; i <= size(); i++) {
				newArr[i] = elements[i - 1];
			}
			elements = newArr;
			capacity = newCapacity;
		}
		size++;
	}

	@Override
	/**
	 * remove element at position r
	 */
	public E removeAtRank(int r) throws InvalidRankException {
		if (r < 0 || r >= size()) { //rank isn't valid
			throw new InvalidRankException();
		}
		for (int i = r; i < size(); i++) { 
			elements[i] = elements[i + 1];
			elements[i + 1] = null;
		}
		size--;
		return elemAtRank(r); 
	}

	@Override
	/**
	 * Replace element at rank r with the element e
	 */
	public E replaceAtRank(int r, E e) throws InvalidRankException {
		if (isEmpty() || r >= size() || r < 0) {
			throw new InvalidRankException();
		} else {
			elements[r] = e;
			return elemAtRank(r);
		}

	}

	@Override
	/**
	 * swap two elements in the list
	 */
	public void swapAtRanks(int r, int s) throws InvalidRankException {
		if (r < 0 || r > capacity || s < 0 || s > capacity) {
			throw new InvalidRankException();
		} else {
			E temp_r = elemAtRank(r);
			elements[r] = elements[s];
			elements[s] = temp_r;
		}
	}

	@Override
	/**
	 * return Content from Array
	 */
	public String toString() {
		return "ArrayVector [elements=" + Arrays.toString(elements) + ", n=" + n + ", capacity=" + capacity + "]";
	}

}
