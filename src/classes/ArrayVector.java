package classes;

import java.util.Arrays;
import exceptions.InvalidRankException;
import interfaces.Vector;

public class ArrayVector<E> implements Vector<E> {
	private Object arr[];
	private int size;
	private int capacity;

	/**
	 * Constructor
	 * Initialize empty Array with capacity of 2 (this size was chosen to demonstrate the enlargement of the array)
	 */
	public ArrayVector() {
		size = 0;
		capacity = 2;
		arr = new Object[capacity];
	}

	/**
	 * returns size of the array
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * check if array is empty -> hasn't any elementens in it return true if array
	 * is empty
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * returns element at rank r, if r is invalid throw exception
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E elemAtRank(int r) throws InvalidRankException {

		if (r < 0 || r > capacity) {
			throw new InvalidRankException();
		}

		return (E) arr[r]; // parse and return element
	}

	/**
	 * insert element at position r move elements from r to n 1 position left, make
	 * space at position r for new element
	 */
	@Override
	public void insertAtRank(int r, E e) throws InvalidRankException {

		if (r < 0 || r > capacity) { //rank isn't valid
			throw new InvalidRankException();
		}
		else if (r < capacity - 1 && arr[r] == null) { //if position r is null, insert element directly
			arr[r] = e;
		} 
		else if (size < capacity - 1) { //if array has enough capacity for another element
			for (int i = size - 1; i >= r; i--) { // move elements 1 position to the back
				arr[i + 1] = elemAtRank(i);
			}
			arr[r] = e; //insert element at free position r
		} 
		else { 
			//array isn't big enough, double the capacity
			capacity *= 2;
			Object[] newArr = new Object[capacity];
			// copy elements to new array
			for (int i = 0; i <= r; i++) {
				newArr[i] = arr[i];
			}
			newArr[r] = e;
			for (int i = r + 1; i <= size(); i++) {
				newArr[i] = arr[i - 1];
			}
			arr = newArr;
		}
		size++;
	}

	/**
	 * remove element at position r
	 */
	@Override
	public E removeAtRank(int r) throws InvalidRankException {
		if (r < 0 || r >= size) { //rank isn't valid
			throw new InvalidRankException();
		}
		for (int i = r; i < size(); i++) { 
			arr[i] = arr[i + 1];
			arr[i + 1] = null;
		}
		size--;
		return elemAtRank(r); 
	}

	/**
	 * Replace element at rank r with the element e
	 */
	@Override
	public E replaceAtRank(int r, E e) throws InvalidRankException {
		if (isEmpty() || r >= size() || r < 0) {
			throw new InvalidRankException();
		} 
		else {
			arr[r] = e;
			return elemAtRank(r);
		}

	}

	/**
	 * swap two elements in the list
	 */
	@Override
	public void swapAtRanks(int r, int s) throws InvalidRankException {
		if (r < 0 || r >= size || s < 0 || s >= size) {
			throw new InvalidRankException();
		} else {
			E temp_r = elemAtRank(r);
			arr[r] = arr[s];
			arr[s] = temp_r;
		}
	}

	/**
	 * return Content from Array
	 */
	@Override
	public String toString() {
		return "ArrayVector [elements=" + Arrays.toString(arr) + ", size=" + size + ", capacity=" + capacity + "]";
	}

}
