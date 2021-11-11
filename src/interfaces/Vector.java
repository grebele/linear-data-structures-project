package interfaces;

import exceptions.InvalidRankException;

public interface Vector<E> extends BasicCollection {

	public E elemAtRank(int r) throws InvalidRankException;

	public void insertAtRank(int r, E e) throws InvalidRankException;

	public E removeAtRank(int r) throws InvalidRankException;

	public E replaceAtRank(int r, E e) throws InvalidRankException;

	public void swapAtRanks(int r, int s) throws InvalidRankException;

}
