package sb223ce_assign1.Ferry;

import java.util.ArrayList;

public abstract class Vehicle {

	/* Fields */
	private int passengersOnVehicle = 0;
	protected int vehicalCost = 0;
	protected int maxPassengerInVehicle = 0;
	protected int vehicleSize = 0;
	protected int vehiclePassengerCost = 0;
	protected static int ID = 0;
	protected String vehicleType = "";
	private ArrayList<Passenger> vehiclePassengerList = new ArrayList<Passenger>();
	protected int vehicleID = 0;

	/* Constructor */
	public Vehicle() {

		vehicleID = Vehicle.ID; // for handling duplicate vehicles

	}

	/* To get cost of vehicle */
	protected int getVehicalCost() {
		return vehicalCost;
	}

	/* To get how many passengers are on vehicle */
	protected int getMaxPassengerInVehicle() {
		return maxPassengerInVehicle;
	}

	/* To get size of vehicle */
	protected int getVehicleSize() {
		return vehicleSize;
	}

	/* To get vehicle passenger cost */
	protected int getVehiclePassengerCost() {
		return vehiclePassengerCost;
	}

	/* add passengers on vehicle */
	public void addPassenger(Vehicle v, Passenger p) {
		if (p != null) {
			vehiclePassengerList.add(p);
			v.passengersOnVehicle = v.passengersOnVehicle + p.getNumberOfPassenger();
		} else
			v.passengersOnVehicle = v.passengersOnVehicle + 0;

	}

	/* To get size of vehicle */
	protected int getvehicleSize() {
		return vehicleSize;
	}

	/* To String */
	public String toString() {
		return vehicleType;
	}

	/* To get the name of vehicle */
	protected String getVehicleType() {
		return vehicleType;
	}

	/* To get how many passengers are on vehicle */
	protected int getPassengersOnVehicle() {
		return passengersOnVehicle;
	}

	/* To get the list of passengers who are traveling on vehicle */
	protected ArrayList<Passenger> getPassengerOnVehicleList() {
		return vehiclePassengerList;
	}

	/*
	 * To get personal ID of vehicle because one vehicle is only allowed to
	 * embark one time
	 */
	protected int getVehicleID() {
		return vehicleID;
	}

}
