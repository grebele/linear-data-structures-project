package classes;

import java.lang.reflect.Array;
import java.util.Arrays;

import exceptions.EmptyStackException;
import exceptions.FullStackException;
import interfaces.Stack;

public class ArrayStack<E> implements Stack<E> {
	private int size;
	private int capacity = 2;
	private Object[] arr;
	
	public ArrayStack() {
		size = 0;
		arr = new Object[capacity] ;
	}
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

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

	@Override
	public void push(E e) {
		if (size == capacity) {
			int newCapacity = capacity*2;
			Object[] newArr = new Object[newCapacity];
			capacity = capacity*2;
			// copy elements to new array
			for (int i=0; i<size; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
			capacity = newCapacity;
		}
		
		arr[size] = e;
		size++;
		
	}

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
	
	@Override
	public String toString() {
		return "ArrayStack [elements=" + Arrays.toString(arr) + "]";
	}
}
