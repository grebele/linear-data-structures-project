package classes;

import exceptions.InvalidRankException;
import interfaces.Vector; 

public class ArrayVector<E> implements Vector<E>{
	E data;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E elemAtRank(int r) throws InvalidRankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAtRank(int r, E e) throws InvalidRankException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E removeAtRank(int r) throws InvalidRankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E replaceAtRank(int r, E e) throws InvalidRankException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void swapAtRanks(int r, int s) throws InvalidRankException {
		// TODO Auto-generated method stub
		
	} 
	
}
