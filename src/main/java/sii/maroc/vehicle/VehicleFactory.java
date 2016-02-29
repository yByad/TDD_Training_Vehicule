package sii.maroc.vehicle;

import sii.maroc.presentation.VehicleTypes;

public class VehicleFactory {

    private static final VehicleFactory INSTANCE = new VehicleFactory();

    public static VehicleFactory getInstance() {
	return INSTANCE;
    }

    public Vehicle createVehicule(String vehiculeType, Fuel fuel) {
	final VehicleTypes typeOfVehicule = VehicleTypes.valueOf(vehiculeType);
	return new Vehicle(typeOfVehicule, fuel);
    }
}
