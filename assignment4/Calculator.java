package assignment4;

public class Calculator <T>{
	private T a;
	private T b;
	private T ans;
	
//	public Calculator(T a, T b) {
//		this.setA(a);
//		this.setB(b);
//		if (a instanceof Integer) {
//			calculateInt(a, b);
//		}
//		else if (a instanceof String) {
//			calculateString(a, b);
//		}
//	}   
	
	public boolean calcuate() {
		if (a instanceof Integer) {
			return calculateInt(a, b);
		}
		else if (a instanceof String) {
			return calculateString(a, b);
		}
		else {
			return false;
		}

	}

	private boolean calculateString(T a2, T b2) {
		// TODO Auto-generated method stub
		String answer = a2.toString() + b2.toString();
		return answer.equals(getAns());
	}

	private boolean calculateInt(T a2, T b2) {
		// TODO Auto-generated method stub
		int answer = ((Integer) a2)/((Integer) b2);
		return (answer == ((Integer) getAns()));
	}

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}

	public T getB() {
		return b;
	}

	public void setB(T b) {
		this.b = b;
	}

	public T getAns() {
		return ans;
	}

	public void setAns(T ans) {
		this.ans = ans;
	}
}