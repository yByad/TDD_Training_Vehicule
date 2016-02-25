package sii.maroc.vehicule;

import sii.maroc.presentation.VehiclesTypes;
import sii.maroc.presentation.VehiculeWriter;
import sii.maroc.presentation.Writer;

public class Vehicles {

    final Writer writer;

    public Vehicles(String consumptions) {
	GasTypes.defineConsumptions(consumptions);
	writer = new VehiculeWriter();
    }

    public String move(String vehiculeType, String gasType, String closedDoors, String distanceInKM) {
	final VehiclesTypes typeOfVehicule = VehiclesTypes.valueOf(vehiculeType);
	final GasTypes typeOfGas = GasTypes.valueOf(gasType);
	Vehicule vehicule = new Vehicule(typeOfVehicule, typeOfGas);
	vehicule = vehicule.closeDoors(closedDoors);
	if (vehicule.doorsAreClosed()) {
	    final float gasConsumed = vehicule.move(distanceInKM);
	    return writer.printWhenOK(typeOfVehicule, gasConsumed);
	}
	final String openDoors = vehicule.retrieveOpenDoors();
	return writer.printWhenKO(typeOfVehicule, openDoors);
    }

}
