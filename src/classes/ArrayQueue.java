package classes;

import exceptions.EmptyQueueException;
import interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {
	
	private int frontIndex;
	private int size;
	private int capacity;
	private Object[] arr;
	
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
	 * 
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
	 * 
	 */
	@Override
	public void enqueue(E e) {
		// besser GROWABLE
		if (size == capacity) {
			if (size == capacity) {
				int newCapacity = capacity*2;
				Object[] newArr = new Object[newCapacity];
				capacity = capacity*2;
				// copy arr to new array
				for (int i=0; i<size; i++) {
					newArr[i] = arr[i];
				}
				arr = newArr;
				capacity = newCapacity;
			}
			
			arr[size] = e;
			size++;
		}
		else {
			arr[(frontIndex + size) % capacity] = e;
			size++;
		}
	}

	/**
	 * 
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

}
