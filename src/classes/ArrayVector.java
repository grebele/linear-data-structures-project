package classes;

import java.lang.reflect.Array;
import exceptions.FullVectorException;
import exceptions.InvalidRankException;
import interfaces.Vector;

public class ArrayVector<E> implements Vector<E> {
	private Object elements[];
	//private int size;
	private int n;

	private static final int INITIAL_SIZE = 100;

	public ArrayVector() {
		elements = new Object[INITIAL_SIZE];
	}

	/**
	 * n ist die Anzahl Elemente im Vector iteriert durch Array, wenn Element null
	 * ist wird noch +1 für den nächsten freien platz
	 * @return 
	 * 
	 */
	public int getN() {
		for (int i = 0; i < size(); i++) {
			if (elemAtRank(i) == null) {
				return i+1;
			} else {
				//System.out.println(elemAtRank(i));
			}
		}
		return -1;
	}

	@Override
	/**
	 * returns size of the array
	 */
	public int size() {
		return Array.getLength(elements);
	}

	@Override
	/**
	 * return true if array is empty
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	/**
	 * retruns Element at rank r, if r is invalid throw exception
	 */
	public E elemAtRank(int r) throws InvalidRankException {
		/*
		 * if (r < 0 || r >= size()) { throw new InvalidRankException(); }
		 */
		return (E) elements[r];
	}

	@Override
	/**
	 * Element an Position r einfügen alle Elemente ab r einen Platz nach hinten
	 * verschieben, um Platz zu machen für e
	 */
	public void insertAtRank(int r, E e) throws InvalidRankException {
		/*
		 * if (r < 0 && r > size()) { throw new InvalidRankException(); }
		 */
		n=getN();
		if (isEmpty()) {
			elements[0] = e;
		} else if (n + 1 < size()) {
			for (int i = n; i <= n+1; i++) { // alle Elemente ab r ein Platz nach hinten verschieben
				E temp = elemAtRank(i);
				elements[i + 1] = temp;
				elements[i] = null;
			}
			elements[r] = e;
		} else {
			throw new FullVectorException();
		}

	}

	@Override
	/**
	 * Element an stelle r löschen, alle Elemente links von r um einen Platz nach
	 * vorne verschieben n wird danach zu n-1
	 */
	public E removeAtRank(int r) throws InvalidRankException {
		if (r >= 0 && r < size()) {
			throw new InvalidRankException();
		}
		for (int i = r; i < size(); i++) { // alle Elemente ab r ein Platz nach hinten verschieben
			elements[i] = elements[i + 1];
			elements[i + 1] = null;
		}
		//setN();// n aktualisieren
		return elemAtRank(r); // neues Element an Platz r
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
		E temp_r = elemAtRank(r);
		elements[r] = elements[s];
		elements[s] = temp_r;

	}

}
