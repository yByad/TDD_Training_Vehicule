package sii.maroc.presentation;

import java.util.LinkedList;
import java.util.List;

import sii.maroc.vehicle.ConsumptionParameter;
import sii.maroc.vehicle.Vehicle;
import sii.maroc.vehicle.VehiculeTypeParameter;

public class SuccessReport implements Report {

    private List<Parameter> parameters;

    public SuccessReport(Vehicle vehicle, String distanceInKM) {
	final Parameter vehicleType = new VehiculeTypeParameter(vehicle);
	final Parameter consumption = new ConsumptionParameter(vehicle, distanceInKM);
	parameters = new LinkedList<Parameter>();
	parameters.add(vehicleType);
	parameters.add(consumption);
    }

    @Override
    public String report() {
	String report = "DOORS OK, MOVING. ";
	for (Parameter parameter : parameters) {
	    report += parameter.getMessage();
	}
	return report;
    }

}
