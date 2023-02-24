package mmm1;

public class Main {
	public static void main(String[] args) {
		Cylinder C1 = new Cylinder(4,5);
    
		System.out.printf("원기둥의 부피: %.2f\n", C1.getVolume());
		System.out.printf("원기둥의 겉넓이: %.2f\n", C1.getArea());
	}
}
class Cylinder{
	private int radius; // 객체생성 
	private int height;
	
	Cylinder(int r,int h){
		radius = r; // 인스턴스 변수 초기화 
		height = h; // 인스턴스 변수 초기화
	}
	
	public Object getArea() {
		return getArea();
	}

	public Object getVolume() {
		return getVolume();
	}

	static double volume(Cylinder C) {
		return (Math.PI * C.radius * C.radius) * C.height;
	}
	static double area(Cylinder C) {
		double k = Math.PI * C.radius * C.radius;
		double s = Math.PI * C.radius * C.radius * C.height * 2;
		return (k * 2) + s;
	}
	
}
