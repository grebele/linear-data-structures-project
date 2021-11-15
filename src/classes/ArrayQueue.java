package classes;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;
import interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {
	
	private int frontIndex;
	private int size;
	private int capacity;
	private E elements[];
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public E front() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			return elements[frontIndex];
		}
	}

	@Override
	public void enqueue(E e) throws FullQueueException {
		// besser GROWABLE
		if (size == capacity) {
			throw new FullQueueException();
		}
		else {
			elements[(frontIndex + size) % capacity] = e;
			size++;
		}
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			E e = elements[frontIndex];
			frontIndex = (frontIndex + 1) % capacity;
			size--;
			return e;
		}
	}

}
