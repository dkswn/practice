
class SubstractionableCalculator extends Calculator{
	
	public void substract() {
		System.out.println(this.left-this.light);
	}
	public void sum() {
		System.out.println(this.left + this.light);
	}
	public void avg() {
		System.out.println((this.left + this.light)/2);
	}
	public void setOprands(int left, int right) {
		
		
	}
}
public class CalculatorDemo1 {
	public static void main(String[] args) {
		SubstractionableCalculator c1 = new SubstractionableCalculator();
		c1.setOprands(10,20);
		c1.sum();
		c1.avg();
		c1.substract();

	}

}
