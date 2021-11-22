package tests;

import classes.ArrayStack;

public class mainTester{
	
	public static void main(String[] args) {
		ArrayStackTest();				
	}
	
	public static void ArrayStackTest() {
		ArrayStack<Integer> arrStack = new ArrayStack<>();
		arrStack.push(1);
		System.out.println(arrStack);
		arrStack.push(4);
		arrStack.push(8);
		System.out.println(arrStack);
		arrStack.pop();
		System.out.println(arrStack);
		arrStack.push(7);
		System.out.println(arrStack);
		arrStack.push(10);
		System.out.println(arrStack);
		System.out.println(arrStack.size());
	}
}
