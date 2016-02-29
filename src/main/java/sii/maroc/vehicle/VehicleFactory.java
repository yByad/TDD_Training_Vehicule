package sii.maroc.vehicle;

public class VehicleFactory {

    private static final VehicleFactory INSTANCE = new VehicleFactory();

    public static VehicleFactory getInstance() {
	return INSTANCE;
    }

    Vehicle createVehicule(String vehiculeType, String gasType) {
	final VehicleTypes typeOfVehicule = VehicleTypes.valueOf(vehiculeType);
	final GasTypes typeOfGas = GasTypes.valueOf(gasType);
	return new Vehicle(typeOfVehicule, typeOfGas);
    }
}
