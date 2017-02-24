package sb223ce_assign1.Ferry;

import java.util.Iterator;

public class FerryMain {

	public static void main(String[] args) {

		Ferry f = new MyFerry();

		// Passengers
		Passenger p1 = new Passenger("Sunny", 22);
		Passenger p2 = new Passenger("Paula", 23);
		Passenger p3 = new Passenger("William", 26);
		Passenger p4 = new Passenger("Love", 20);
		Passenger p5 = new Passenger("Karan", 20);

		// Embark passengers without vehicle

		for (int i = 0; i < 10; i++) {
			f.embark(p1);
		}

		// Vehicles
		Vehicle bicycle = new Bicycle();
		Vehicle lorry = new Lorry();
		Vehicle car = new Car();
		Vehicle bus = new Bus();

		// Embark vehicles without passengers

		f.embark(car);
		f.embark(lorry);

		// Embark vehicles with 1 passengers
		while (f.hasSpaceFor(lorry)) {
			bicycle = new Bicycle();
			bicycle.addPassenger(bicycle, p2);
			f.embark(bicycle);
		}
		for (int i = 0; i < 1; i++) {
			car = new Car();
			car.addPassenger(car, p3);
			f.embark(car);
		}

		// For adding more passengers in vehicle
		bus = new Bus();
		for (int i = 0; i < 20; i++) {
			bus.addPassenger(bus, p4);
		}
		f.embark(bus);

		while (f.hasSpaceFor(bicycle)) {
			bicycle = new Bicycle();
			bicycle.addPassenger(bicycle, p5);
			f.embark(bicycle);
		}

		// Embark duplicates, program will throw error
		// f.embark(bicycle);
		// f.embark(lorry);
		// f.embark(car);
		// f.embark(bus);

		System.out.println("Has Room For Passenger: " + f.hasRoomFor(p1));
		System.out.println("Has Space For Vehicle: " + f.hasSpaceFor(bicycle));
		System.out.println("Total Passengers: " + f.countPassengers());
		System.out.println("Total Money: " + f.countMoney() + " Kr");
		System.out.println("Used Parking Space: " + f.countVehicleSpace());
		System.out.println(f.toString());

		Iterator<Vehicle> vhh = f.iterator();
		System.out.println("Vehicle Iterator: ");
		int count = 1;
		while (vhh.hasNext()) {
			System.out.println((count++) + "  " +vhh.next());

		}

		f.disembark();
		System.out.println();
		System.out.println("After Disembark:");
		System.out.println(f.toString());
		System.out.println("Total Money: " + f.countMoney() + " Kr");

		Iterator<Vehicle> vh = f.iterator();
		
		while (vh.hasNext()) {
			System.out.println(vh.next());

		}

	}
}