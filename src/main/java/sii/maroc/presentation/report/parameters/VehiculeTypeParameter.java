package sii.maroc.presentation.report.parameters;

import sii.maroc.vehicle.Vehicle;

public class VehiculeTypeParameter extends Parameter {

    private String vehicleType;

    public VehiculeTypeParameter(Vehicle vehicle) {
	this.vehicleType = vehicle.getVehiculeType().name();
    }

    @Override
    public String getMessage() {
	return "The " + vehicleType + " ";
    }

}
