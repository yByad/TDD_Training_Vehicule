package sii.maroc.vehicle;

import sii.maroc.presentation.VehicleWriter;
import sii.maroc.presentation.VehiclesTypes;
import sii.maroc.presentation.Writer;

public class Vehicles {

    final private Writer writer;
    private Vehicle vehicle;

    public Vehicles(String consumptions) {
	GasTypes.defineConsumptions(consumptions);
	writer = new VehicleWriter();
    }

    public String move(String vehiculeType, String gasType, String closedDoors, String distanceInKM) {
	vehicle = createVehicule(vehiculeType, gasType);
	vehicle = vehicle.closeDoors(closedDoors);
	if (vehicle.doorsAreClosed()) {
	    return printWhenDoorsClosed(vehiculeType, distanceInKM);
	}
	return printWhenDoorsOpen(vehiculeType);
    }

    private Vehicle createVehicule(String vehiculeType, String gasType) {
	final VehiclesTypes typeOfVehicule = VehiclesTypes.valueOf(vehiculeType);
	final GasTypes typeOfGas = GasTypes.valueOf(gasType);
	return new Vehicle(typeOfVehicule, typeOfGas);
    }

    private String printWhenDoorsOpen(String vehiculeType) {
	final String openDoors = vehicle.retrieveOpenDoors();
	return writer.printWhenKO(vehiculeType, openDoors);
    }

    private String printWhenDoorsClosed(String vehiculeType, String distance) {
	distance = distance.replaceAll(" KM$", "");
	final int distanceInKM = Integer.parseInt(distance);
	final float gasConsumed = vehicle.move(distanceInKM);
	return writer.printWhenOK(vehiculeType, gasConsumed);
    }

}
