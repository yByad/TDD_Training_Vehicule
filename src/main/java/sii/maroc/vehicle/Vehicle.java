package sii.maroc.vehicle;

import sii.maroc.presentation.VehicleTypes;

public class Vehicle {

    private final VehicleTypes vehiculeType;
    private final Fuel gasType;

    Vehicle(VehicleTypes vehiculeType, Fuel gasType) {
	this.vehiculeType = vehiculeType;
	this.gasType = gasType;
    }

    public Double calculateConsumedGas(Double distance) {
	Double consumedGas = this.gasType.calculateConsumedGas(distance);
	return consumedGas;
    }

    public boolean canMove(String closedDoors) {
	if (closedDoors.equals(vehiculeType.getDoors())) {
	    return true;
	}
	return verifyDoors(closedDoors);
    }

    public VehicleTypes getVehiculeType() {
	return vehiculeType;
    }

    public String retrieveOpenDoors(String closedDoors) {
	String openDoors = "";
	final String possibleDoors = vehiculeType.getDoors();
	for (int i = 0; i < possibleDoors.length(); i++) {
	    final String possibleDoor = possibleDoors.charAt(i) + "";
	    if (!closedDoors.contains(possibleDoor))
		openDoors += possibleDoor;
	}
	return openDoors;
    }

    private boolean verifyDoors(String closedDoors) {
	closedDoors = new ParametersProvider().removeSpaces(closedDoors);
	if (closedDoors.matches(vehiculeType.getTypeRegEx())) {
	    return false;
	}
	throw new IllegalArgumentException();
    }

}
