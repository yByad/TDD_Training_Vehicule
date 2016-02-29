package sii.maroc.vehicle;

import sii.maroc.presentation.Parameter;

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
