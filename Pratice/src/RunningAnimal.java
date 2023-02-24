
public class RunningAnimal {
	public static void main(String[] args) {
		Animal anil = new Animal();
		anil.setname ("강아지");
		anil.age = 5;
		
		System.out.print(anil.getname());
		System.out.print(anil.age);

	}

}

class Animal {
	
	private String name;
	int age;
	
	public void setname(String pname) {
		name=pname;
	}
	
	public String getname() {
		return name;
				
	}
}
