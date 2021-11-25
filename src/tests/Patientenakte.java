package tests;


public class Patientenakte {
	
	private String name;
	private int patID;
	private int telnumb;
	

	public Patientenakte(String name, int patID) {
		this.name = name;
		this.patID = patID; 
	}
	
	public Patientenakte(String name, int patID, int telnumb) {
		this.name = name;
		this.patID = patID;
		this.telnumb = telnumb;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPatID() {
		return patID;
	}
	

	public int getTelnumb() {
		return telnumb;
	}

	public void setTelnumb(int telnumb) {
		this.telnumb = telnumb;
	}

	@Override
	public String toString() {
		return "Patienten ID: " + patID + ", Name: " + name + ", Telefon Nummer: " + telnumb;
	}
	

	
}
