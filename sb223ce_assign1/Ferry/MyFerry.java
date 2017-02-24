package sb223ce_assign1.Ferry;

import java.util.ArrayList;
import java.util.Iterator;
import sb223ce_assign1.Ferry.Vehicle;

public class MyFerry implements Ferry {

	/* Fields */
	private ArrayList<Vehicle> parking = new ArrayList<Vehicle>();
	private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	private static int countVehicleSpace = 0;
	private final int TOTAL_PASSENGERS = 200;
	private final int TOTAL_PARKING_SPACE = 200; // in terms of bicycle
	private final int PASSENGER_COST = 20;
	private static int passengersOnFerry = 0;
	private static int money = 0;
	private static int countCycle = 0;
	private static int cycleSpace = 0;

	/* Constructor */
	public MyFerry() {

	}

	/* Check the ID(duplicate) of vehicle */
	private boolean checkID(Vehicle v) {

		for (int i = 0; i < parking.size(); i++) {

			if (v.getVehicleID() == parking.get(i).getVehicleID())
				return true;
		}

		return false;

	}

	public int countPassengers() {
		return passengersOnFerry;
	}

	public int countMoney() {
		return money;
	}

	public boolean hasSpaceFor(Vehicle v) {
		return countVehicleSpace + v.getvehicleSize() <= TOTAL_PARKING_SPACE
				&& v.getPassengersOnVehicle() + countPassengers() <= TOTAL_PASSENGERS
				&& v.getPassengersOnVehicle() <= v.maxPassengerInVehicle && v.getPassengersOnVehicle() >= 0;
	}

	public int countVehicleSpace() {

		return countVehicleSpace / 5 + cycleSpace;// change to car size
	}

	public void disembark() {
		parking.clear();
		passengerList.clear();
		countVehicleSpace = 0;
		passengersOnFerry = 0;
		cycleSpace = 0;
		countCycle = 0;
	}

	public void embark(Vehicle v) {
		if (hasSpaceFor(v) == true && checkID(v) == false) {
			passengersOnFerry = passengersOnFerry + v.getPassengersOnVehicle();
			money = money + v.vehicalCost + v.getPassengersOnVehicle() * v.vehiclePassengerCost;
			countVehicleSpace = countVehicleSpace + v.vehicleSize;
			parking.add(v);
			passengerList.addAll(v.getPassengerOnVehicleList());
			if (isCycle(v) == true) {
				countCycle++; // just count vehicle space separately
				if (countCycle == 1)
					cycleSpace++; // count half filled parking space
				else if (countCycle == 5) { // 5 cycle = 1 car
					countCycle = 0;
					cycleSpace = 0;
				}
			}

		}

		// if above conditions are false print the appropriate error
		else {
			// if ferry do not have enough space for parking the vehicle
			if (v.getvehicleSize() + countVehicleSpace > TOTAL_PARKING_SPACE) {
				System.err.println("Cannot embark " + v.getVehicleType() + " because " + " ferry is full.");
			}

			// if ferry do not have enough space for passengers on vehicle
			else if (v.getPassengersOnVehicle() + passengersOnFerry > TOTAL_PASSENGERS) {
				System.err.println(
						"Cannot embark " + v.getVehicleType() + " because the" + " ferry can only take maximum "
								+ (TOTAL_PASSENGERS - passengersOnFerry) + " passenger(s) more and"
								+ " this vehicle have " + v.getPassengersOnVehicle() + " passenger(s).");
			}

			// if passengers on vehicle are more than allowed
			else if (v.getPassengersOnVehicle() > v.maxPassengerInVehicle) {
				System.err.println("Cannot embark " + v.getVehicleType() + " because maximum passengers limit is "
						+ v.maxPassengerInVehicle + " passenger(s) and you are trying to carry "
						+ v.getPassengersOnVehicle() + " passenger(s).");
			}
			// if same vehicle embarking twice
			else if (checkID(v) == true)
				System.err.println("Cannot embark same vehicle (" + v.getVehicleType() + ") twice.");
		}
	}

	public String toString() {
		return "\nFerry status: Ferry have " + countPassengers() + " passenger(s) and " + parking.size()
				+ " vehicle(s) on board. There is/are " + (TOTAL_PARKING_SPACE / 5 - countVehicleSpace())
				+ " space(s) left for parking and " + (TOTAL_PASSENGERS - countPassengers())
				+ " seat(s) left for passenger(s).\n\n" + PassengerList();
	}

	/* Passenger list */
	private String PassengerList() {
		StringBuilder s = new StringBuilder();
		s.append("Passenger List\n");
		for (int i = 0; i < passengerList.size(); i++) {
			s.append(passengerList.get(i));
		}
		return s.toString();
	}

	public boolean hasRoomFor(Passenger b) {
		return countPassengers() + b.getNumberOfPassenger() <= TOTAL_PASSENGERS;
	}

	public void embark(Passenger p) {
		if (hasRoomFor(p) == true && p.getNumberOfPassenger() + passengersOnFerry <= TOTAL_PASSENGERS) {
			money = money + p.getNumberOfPassenger() * PASSENGER_COST;
			passengersOnFerry = passengersOnFerry + p.getNumberOfPassenger();
			passengerList.add(p);

		} else
			System.err.println("No more space for passengers. Ferry is full.");
	}

	public Iterator<Vehicle> iterator() {
		return new VehicleIterator();
	}

	private boolean isCycle(Vehicle v) {
		return v.vehicleSize == 1;
	}

	// Private inner class used by iterator()
	class VehicleIterator implements Iterator<Vehicle> {
		private int count = 0;

		public Vehicle next() {

			return parking.get(count++);
		}

		public boolean hasNext() {

			return count < parking.size();
		}
	}
}