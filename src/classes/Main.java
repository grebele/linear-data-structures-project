package classes;

import interfaces.Stack;
import interfaces.Vector;
import tests.Patientenakte;

public class Main {
	public static void main(String args[]) {

		Vector<Integer> vector = new ArrayVector<>();

		System.out.println("Size: " + vector.size());
		System.out.println("Empty: " + vector.isEmpty());

		vector.insertAtRank(0, 1);
		System.out.println("Platz 0:" + vector.elemAtRank(0)); // System.out.println(vector.size());

		vector.insertAtRank(1, 2);
		vector.insertAtRank(2, 3);
		vector.insertAtRank(3, 4);

		System.out.println("Platz 1:" + vector.elemAtRank(1));
		System.out.println("Platz 2:" + vector.elemAtRank(2));
		System.out.println("Platz 3:" + vector.elemAtRank(3));
		System.out.println(vector);

		vector.insertAtRank(2, 222222);
		System.out.println(vector);
		vector.insertAtRank(2, 444444);

		
		System.out.println(vector);
		System.out.println(vector.size());
		// showStack();

	}

	/**
	 * Example to show the function of the ArrayStack Class
	 */
	public static void showStack() {
		Stack<Patientenakte> patients = new ArrayStack<>();
		patients.push(new Patientenakte("Testperson", 0));
		patients.push(new Patientenakte("Testperson1", 1));
		System.out.println(patients);
		patients.push(new Patientenakte("Testperson2", 2));

		System.out.println("Nach Push von Patientenakten " + patients);

		patients.pop();
		System.out.println("Pop von Patientenakte " + patients);

		patients.push(new Patientenakte("Simon", 3));
		System.out.println(patients);

		System.out.println("An erster Stelle: " + patients.top());
	}

}
