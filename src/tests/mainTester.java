package tests;

import classes.ArrayStack;

public class mainTester{
	
	public static void main(String[] args) {
		ArrayStackTest();				
	}
	public static void ArrayStackTest() {
		TestPerson simon = new TestPerson("Simon");
//		TestPerson domingo = new TestPerson("Domingo");
		// Erin
		TestPerson joao = new TestPerson("Joao");		
		System.out.println("hooi");
		
		ArrayStack<TestPerson> people = new ArrayStack<>();
		System.out.println(people);
		people.push(simon);
		System.out.println(people);
		people.push(joao);
		System.out.println(people);
		System.out.println(simon + "hey");

	}
}
