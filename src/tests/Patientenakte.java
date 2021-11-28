package tests;


public class Patientenakte {
	
	private String name;
	private int ahvNb;
	private int telnumb;
	

	public Patientenakte(String name, int ahvNb) {
		this.name = name;
		this.ahvNb = ahvNb; 
	}
	
	public Patientenakte(String name, int ahvNb, int telnumb) {
		this.name = name;
		this.ahvNb = ahvNb;
		this.telnumb = telnumb;
	}
	
	public String getName() {
		return name;
	}
	
	public int getahvNb() {
		return ahvNb;
	}
	

	public int getTelnumb() {
		return telnumb;
	}

	public void setTelnumb(int telnumb) {
		this.telnumb = telnumb;
	}

	@Override
	public String toString() {
		return name;
	}
	

	
}
