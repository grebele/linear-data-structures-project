package classes;

import interfaces.Vector;

public class MainVector {
	/**
	 * Example to show the function of the ArrayVector Class
	 */
	public static void main(String args[]) {
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Example to show the function of the ArrayVector Class.");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Initialise a new Vector of the Type Integer");
		Vector<Integer> vector = new ArrayVector<>();
		System.out.println("Check the size of the vector and look if vector is empty:");
		System.err.println("Size: " + vector.size() + "     | "+ " expected = 0");
		System.err.println("Empty: " + vector.isEmpty() + " | "+ " expected = true");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add 1 at rank 0 ");
		vector.insertAtRank(0, 1);
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add 2 at rank 1 ");
		System.err.println("Cave: the capacity should double now");
		vector.insertAtRank(1, 2);
		System.out.println(vector);		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add 3 at rank 2 ");
		vector.insertAtRank(2, 3);
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add 4 at rank 3 ");
		System.err.println("Cave: the capacity should double now");
		vector.insertAtRank(3, 4);
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add 7 at rank 2 ");
		vector.insertAtRank(2, 7);
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println(vector);
		System.out.println(vector.size());
	}

}
