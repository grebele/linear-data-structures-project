package classes;

import java.util.Arrays;

import exceptions.EmptyQueueException;
import interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {
	
	private int frontIndex;
	private int size;
	private int capacity;
	private Object[] arr;
	
	/**
	 * Constructor
	 * Initialise capacity, array, size
	 */
	public ArrayQueue() {
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
	 * returns front element of the queue
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E front() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			return (E) arr[frontIndex];
		}
	}

	/**
	 * add element to the end of the end of the queue
	 */
	@Override
	public void enqueue(E e) {
		if (size == capacity) {
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
		else {
			// insert element to the next available index 
			arr[(frontIndex + size) % capacity] = e;
			size++;
		}
	}

	/**
	 * remove element from the front
	 */
	@Override
	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			try {
				@SuppressWarnings("unchecked")
				E e = (E) arr[frontIndex];
				frontIndex = (frontIndex + 1) % capacity;
				size--;
				return e;
			}
			catch(ClassCastException e) {
				System.err.println("Cast Error");
				return null;
			}
		}
	}

	@Override
	public String toString() {
		return "ArrayQueue [elements=" + Arrays.toString(arr) + ", frontIndex=" + frontIndex + ", size=" + size + ", capacity=" + capacity
				+ "]";
	}
	
	

}
