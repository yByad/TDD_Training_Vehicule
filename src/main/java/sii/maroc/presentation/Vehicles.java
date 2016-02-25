package sii.maroc.presentation;

import sii.maroc.vehicule.GasTypes;
import sii.maroc.vehicule.VehiclesTypes;
import sii.maroc.vehicule.Vehicule;

public class Vehicles {

    public Vehicles(String consumptions) {
	GasTypes.defineConsumptions(consumptions);
    }

    public String move(String vehiculeType, String gasType, String closedDoors, String distanceInKM) {
	final VehiclesTypes typeOfVehicule = VehiclesTypes.valueOf(vehiculeType);
	final GasTypes typeOfGas = GasTypes.valueOf(gasType);
	Vehicule vehicule = new Vehicule(typeOfVehicule, typeOfGas);
	vehicule = vehicule.closeDoors(closedDoors);
	if (vehicule.doorsOK())
	    return vehicule.move(distanceInKM);

	return vehicule.OpenDoors();
    }

}
