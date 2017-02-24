package sb223ce_assign1.Ferry;

public class Passenger {

	/*Fields*/
	protected int numberOfPassenger = 0;
	protected String name = "";
	protected int age = 0;

	/*Constructor*/
	public Passenger(String name, int age) {
		this.name = name;
		this.age = age;
		numberOfPassenger = 1;

	}

	/*Method to find how many passenger instance created*/
	protected int getNumberOfPassenger() {
		return numberOfPassenger;
	}

	@Override
	public String toString() { // to string
		return "Name: " + name + "   Age: " + age + "\n";
	}

	/*To get the name of passenger*/
	protected String getName() {
		return name;
	}

	/*To get the age of passenger*/
	protected int getAge() {
		return age;
	}

}