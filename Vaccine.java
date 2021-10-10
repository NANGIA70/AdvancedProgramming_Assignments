package assignment1;

public class Vaccine {
	String name;
	int dosesReq;
	int gap;
	
	public Vaccine(String name, int dosesReq, int gap) {
		this.name = name;
		this.dosesReq = dosesReq;
		this.gap = gap;
	}
	
	public void display() {
		System.out.println("Vaccine Name: " + this.name);
		System.out.println("Number of Doses: " + this.dosesReq);
		System.out.println("Gap Between Doses: " + this.dosesReq);
	}

	public String getName() {
		return name;
	}

	public int getDosesReq() {
		return dosesReq;
	}

	public int getGap() {
		return gap;
	}
}

