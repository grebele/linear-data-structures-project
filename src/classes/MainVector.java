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
		Vector<Object> vector = new ArrayVector<>();
		System.out.println("Check the size of the vector and look if vector is empty:");
		System.err.println("Size: " + vector.size() + "     | " + " expected = 0");
		System.err.println("Empty: " + vector.isEmpty() + " | " + " expected = true");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add 20 at rank 0 ");
		vector.insertAtRank(0, 20);
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add 18 at rank 1 ");
		System.err.println("Cave: the capacity should double now");
		vector.insertAtRank(1, 18);
		System.out.println(vector);		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add 15 at rank 2 ");
		vector.insertAtRank(2, 15);
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add we love algorithms at rank 3 ");
		System.err.println("Cave: the capacity should double now");
		vector.insertAtRank(3, "we love algorithms");
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Add 16 at rank 2 ");
		vector.insertAtRank(2, 16);
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Swap elements at rank 0 and 4");
		vector.swapAtRanks(0, 4);
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Replace 'we love algorithms' at rank 0 with 'algorithms are ok'");
		vector.replaceAtRank(0, "algorithms are ok");
		System.out.println(vector);
		System.err.println("elemAtRank(0): " + vector.elemAtRank(0));
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("remove element at rank 0");
		vector.removeAtRank(0);
		System.out.println(vector);
		System.out.println("-------------------------------------------------------------------------------");
		System.err.println("Size: " + vector.size() + "      | " + " expected = 4");
		System.err.println("Empty: " + vector.isEmpty() + " | " + " expected = false");
	}

}
