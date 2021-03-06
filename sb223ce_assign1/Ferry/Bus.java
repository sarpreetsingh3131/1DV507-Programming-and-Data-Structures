package sb223ce_assign1.Ferry;

public class Bus extends Vehicle {

	/* Fields */
	private final int MAX_PASSENGER = 20;
	private final int PASSENGER_COST = 10;
	private final int BUS_COST = 200;
	private final int PARKING_SPACE = 20; // in terms of bicycle
	private final String TYPE = "BUS";

	/* Constructor attached with super class */
	public Bus() {
		super();

		/* Create a bus with all the requirements */
		setVehicleSize(PARKING_SPACE);
		setVehicalCost(BUS_COST);
		setMaxPassengerInVehicle(MAX_PASSENGER);
		setVehiclePassengerCost(PASSENGER_COST);
		setVehicleType(TYPE);
		setID(ID + 1);
	}

	/*
	 * Following methods help to identify this vehicle and these methods give
	 * information to super class(Vehicle)
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
