package sii.maroc.vehicle;

import sii.maroc.vehicle.doors.Doors;
import sii.maroc.vehicle.doors.DoorsFactory;

public class VehicleFactory {

    private static final VehicleFactory INSTANCE = new VehicleFactory();

    public static VehicleFactory getInstance() {
	return INSTANCE;
    }

    public Vehicle createVehicule(String vehiculeType, Fuel fuel, String closedDoors) {
	final VehicleTypes typeOfVehicule = VehicleTypes.valueOf(vehiculeType);
	final Doors doors = DoorsFactory.getInstance().createDoorsOf(typeOfVehicule, closedDoors);
	return new Vehicle(typeOfVehicule, fuel, doors);
    }
}
