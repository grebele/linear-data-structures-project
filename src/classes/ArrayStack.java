package classes;

import java.util.Arrays;

import exceptions.EmptyStackException;
import exceptions.FullStackException;
import interfaces.Stack;

public class ArrayStack<E> implements Stack<E> {
	private int size;
	private int capacity;
	private E elements[];
	
	public ArrayStack() {
		capacity = 8; 
		size = 1;
	}
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public E top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return elements[size-1];
		}
	}

	@Override
	public void push(E e) throws FullStackException {
//		if (size == capacity) {
//			int newCapacity = capacity*2;
//			E newElements[];
//			//weiter nach Pseudo
//			
//			capacity = capacity*2;
//			for (int i=0; i<size-1; i++) {
//				
//			}
//		}
		
//		MIT EXCEPTION ANSTATT GROWABLE STACK
		if (size == capacity) {
			throw new FullStackException();
		}
		else {
			elements[size] = e;
			size++;
		}
	}

	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			size--;
			return elements[size];
		}
	}
	
	@Override
	public String toString() {
		return "ArrayStack [elements=" + Arrays.toString(elements) + "]";
	}
}
