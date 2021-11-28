package classes;

import interfaces.Queue;
import tests.Patientenakte;

public class MainQueue {
	public static void main(String args[]) {
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("Example of a waiting room to show the function of the ArrayQueue Class.");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Initialise a new Queue of the Type String");
		Queue<Patientenakte> queue = new ArrayQueue<>();
		System.out.println("Check the size of the Queue and look if Queue is empty:");
		System.err.println("Size: " + queue.size() + "       | " + " expected = 0");
		System.err.println("Empty: " + queue.isEmpty() + "   | " + " expected = true");
		System.out.println("-------------------------------------------------------------------------------");
		Patientenakte lua = new Patientenakte("Lua", 1234, 717873333);
		System.out.println("-> Enqueue Lua. She's now the first person in the queue ");
		queue.enqueue(lua);
		System.out.println(queue);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Enqueue Lea. Second person waiting");
		Patientenakte lea = new Patientenakte("Lea", 2254, 717877778);
		queue.enqueue(lea);;
		System.out.println(queue);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Enqueue Liz. Third person waiting");
		System.err.println("Cave: the capacity should double now");
		Patientenakte liz = new Patientenakte("Liz", 3236, 712345647);
		queue.enqueue(liz);
		System.out.println(queue);		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Enqueue Kim. Fourth person waiting");
		Patientenakte kim = new Patientenakte("Kim", 6679, 795765600);
		queue.enqueue(kim);
		System.out.println(queue);
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Get Person waiting for the longest time. front() ");
		System.err.println("front(): " + queue.front() + "     | expected: Lua");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Serve the person who has waited the longest (Lua should be removed)");
		queue.dequeue();
		System.out.println(queue);
		System.err.println("Expected: [elements=[Lua, Lea, Liz, Kim]. Lua will be overwritten later, the front index changed only");
		System.err.println("front(): " + queue.front() + "     | expected: Lea");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("-> Enqueue Jil. She's now the last/fourth person waiting, because Lua got removed from the queue");
		Patientenakte jil = new Patientenakte("Jil", 6679, 795765600);
		queue.enqueue(jil);
		System.out.println(queue);
		System.out.println("front(): " + queue.front() + "     | expected: Lea");
		System.out.println("-------------------------------------------------------------------------------");
		System.err.println("Size: " + queue.size() + "          | " + " expected = 4");
		System.err.println("Empty: " + queue.isEmpty() + "     | " + " expected = false");
	}
}
