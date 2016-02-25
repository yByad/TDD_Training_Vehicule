package sii.maroc.vehicule;

import sii.maroc.presentation.VehiclesTypes;
import sii.maroc.presentation.VehiculeWriter;
import sii.maroc.presentation.Writer;

public class Vehicles {

    final private Writer writer;
    private Vehicule vehicule;

    public Vehicles(String consumptions) {
	GasTypes.defineConsumptions(consumptions);
	writer = new VehiculeWriter();
    }

    public String move(String vehiculeType, String gasType, String closedDoors, String distanceInKM) {
	vehicule = createVehicule(vehiculeType, gasType);
	vehicule = vehicule.closeDoors(closedDoors);
	if (vehicule.doorsAreClosed()) {
	    return printWhenDoorsClosed(vehiculeType, distanceInKM);
	}
	return printWhenDoorsOpen(vehiculeType);
    }

    private Vehicule createVehicule(String vehiculeType, String gasType) {
	final VehiclesTypes typeOfVehicule = VehiclesTypes.valueOf(vehiculeType);
	final GasTypes typeOfGas = GasTypes.valueOf(gasType);
	return new Vehicule(typeOfVehicule, typeOfGas);
    }

    private String printWhenDoorsOpen(String vehiculeType) {
	final String openDoors = vehicule.retrieveOpenDoors();
	return writer.printWhenKO(vehiculeType, openDoors);
    }

    private String printWhenDoorsClosed(String vehiculeType, String distanceInKM) {
	final float gasConsumed = vehicule.move(distanceInKM);
	return writer.printWhenOK(vehiculeType, gasConsumed);
    }

}
