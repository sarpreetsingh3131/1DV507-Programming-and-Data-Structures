package sb223ce_assign1.Ferry;

public class Lorry extends Vehicle {

	/* Fields */
	private final int MAX_PASSENGER = 2;
	private final int PASSENGER_COST = 15;
	private final int LORRY_COST = 300;
	private final int PARKING_SPACE = 40; // in terms of bicycle
	private final String TYPE = "LORRY";

	/* Constructor attached with super class */
	public Lorry() {
		super();
		/* Create a lorry with all the requirements */
		setVehicleSize(PARKING_SPACE);
		setVehicalCost(LORRY_COST);
		setMaxPassengerInVehicle(MAX_PASSENGER);
		setVehiclePassengerCost(PASSENGER_COST);
		setVehicleType(TYPE);
		setID(ID + 1);
	}

	/*
	 * Following methods help to identify this vehicle and these methods give
	 * information to super class(Vehicle).
	 */

	/*
	 * I can create these methods in vehicle class but then these methods must
	 * be protected or public. I think that is not good because these methods
	 * update the programs such setvehiclesize() and other methods are quite
	 * important and if user have access to these methods, user can change the
	 * result by giving wrong size of the vehicle or passenger cost and so on.
	 * So it is better to keep these methods private
	 */

	private void setVehicleSize(int size) {
		vehicleSize = size;
	}

	private void setVehiclePassengerCost(int vehiclePassengerCost) {
		this.vehiclePassengerCost = vehiclePassengerCost;
	}

	private void setMaxPassengerInVehicle(int maxPassengerInVehicle) {
		this.maxPassengerInVehicle = maxPassengerInVehicle;
	}

	private void setVehicalCost(int vehicalCost) {
		this.vehicalCost = vehicalCost;
	}

	private void setVehicleType(String name) {
		vehicleType = name;
	}

	private static void setID(int a) {
		ID = a;
	}

}