package classes;


import interfaces.Vector;

public class Main {
	public static void main(String args[]) {
		Vector<Integer> vector = new ArrayVector<>();
		

		System.out.println("Size: "+vector.size());
		System.out.println("Empty: "+vector.isEmpty());
		
		vector.insertAtRank(0, 1);
		System.out.println("Platz 0:" +vector.elemAtRank(0));
		//System.out.println(vector.size());
		
		vector.insertAtRank(1, 2);
		vector.insertAtRank(2, 3);
		vector.insertAtRank(3, 4);
		
		System.out.println("Platz 1:" +vector.elemAtRank(1));
		System.out.println("Platz 2:" +vector.elemAtRank(2));
		System.out.println("Platz 3:" +vector.elemAtRank(3));
	}

}
