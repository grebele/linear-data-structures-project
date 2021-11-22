package tests;


public class TestPerson {
	
	private String name;

	public TestPerson(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
	

	
}
