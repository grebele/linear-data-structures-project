package classes;

import java.util.Arrays;

import exceptions.EmptyStackException;
import interfaces.Stack;

public class ArrayStack<E> implements Stack<E> {
	private int size;
	private int capacity;
	private Object[] arr;
	
	/**
	 * Constructor
	 * Initialise capacity, array, size
	 */
	public ArrayStack() {
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
	 * return true if array is empty
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * get element on top of the stack
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return (E) arr[size-1];
		}
	}

	/**
	 * add element to the top of the stack
	 */
	@Override
	public void push(E e) {
		if (size == capacity) {
			// initialise new capacity
			capacity *= 2;
			Object[] newArr = new Object[capacity];
			// copy elements to temporary array
			for (int i=0; i<size; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		
		arr[size] = e;
		size++;
		
	}

	/**
	 * remove element from the top of the stack
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			size--;
			return (E) arr[size];
		}
	}
	
	/**
	 * returns elements as string
	 */
	@Override
	public String toString() {
		return "ArrayStack [elements=" + Arrays.toString(arr) + "]";
	}
}
