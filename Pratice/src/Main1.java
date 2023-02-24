class Calculator {
	int left,light;
	public void setOprands(int left, int light) {
		this.left = left;
		this.light = light;
	}
	public void sum() {
		System.out.println(this.left + this.light);
	}

	public void avg() {
		System.out.println((this.left + this.light) / 2);
	}

}

public class Main1 {
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.setOprands(10,20);
		c1.sum();
		c1.avg();
		
		Calculator c2 = new Calculator();
		c2.setOprands(20, 40);
		c2.sum();
		c2.avg();
	}

}
