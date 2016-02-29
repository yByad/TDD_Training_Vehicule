package sii.maroc.vehicle;

import java.util.Map;

import sii.maroc.presentation.FailReport;
import sii.maroc.presentation.SuccessReport;

public class Vehicles {

    final private VehicleFactory factory = VehicleFactory.getInstance();

    public Vehicles(String consumptions) {
	final Map<String, Integer> newConsumptions = ParametersProvider.getInstance().extractConsumptions(consumptions);
	GasTypes.defineConsumptions(newConsumptions);
    }

    public String move(String vehiculeType, String gasType, String closedDoors, String distanceInKM) {
	final Vehicle vehicle = factory.createVehicule(vehiculeType, gasType);
	if (vehicle.canMove(closedDoors)) {
	    return new SuccessReport(vehicle, distanceInKM).report();
	}
	return new FailReport(vehicle, closedDoors).report();
    }

}
