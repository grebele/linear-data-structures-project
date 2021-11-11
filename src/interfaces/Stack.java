package interfaces;

import exceptions.EmptyStackException;

public interface Stack<E> extends BasicCollection {

	public E top() throws EmptyStackException;

	public void push(E e);

	public E pop() throws EmptyStackException;

}
