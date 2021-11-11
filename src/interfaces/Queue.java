package interfaces;

import exceptions.EmptyQueueException;

public interface Queue<E> extends BasicCollection {

	public E front() throws EmptyQueueException;

	public void enqueue(E e);

	public E dequeue() throws EmptyQueueException;

}
