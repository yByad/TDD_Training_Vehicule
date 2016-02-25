package sii.maroc.vehicule;

import sii.maroc.presentation.VehiclesTypes;

class Vehicule {

    private final VehiclesTypes vehiculeType;
    private final GasTypes gasType;
    private final String closedDoors;

    Vehicule(VehiclesTypes vehiculeType, GasTypes gasType) {
	this.closedDoors = "";
	this.vehiculeType = vehiculeType;
	this.gasType = gasType;
    }

    private Vehicule(VehiclesTypes vehiculeType, GasTypes gasType, String closedDoors) {
	super();
	this.vehiculeType = vehiculeType;
	this.gasType = gasType;
	this.closedDoors = closedDoors;
    }

    float move(String distanceInKM) {
	distanceInKM = distanceInKM.replaceAll(" KM$", "");
	final int distance = Integer.parseInt(distanceInKM);
	final float gasConsumed = calculateConsumption(distance);
	return gasConsumed;
    }

    private float calculateConsumption(int distance) {
	float consumedGas = distance * gasType.getConsumptionPercentage() / 100;
	return consumedGas;
    }

    boolean doorsAreClosed() {
	if (closedDoors.equals(vehiculeType.getDoors()))
	    return true;
	return false;
    }

    String retrieveOpenDoors() {
	final String possibleDoors = vehiculeType.getDoors().replaceAll(" ", "");
	String openDoors = "";
	for (int i = 0; i < possibleDoors.length(); i++) {
	    final String door = possibleDoors.charAt(i) + "";
	    if (!closedDoors.contains(door))
		openDoors += door;
	}
	return openDoors;
    }

    Vehicule closeDoors(String closedDoors) {
	final String doors = closedDoors.replaceAll(" ", "");
	if (doors.matches(vehiculeType.getTypeRegEx()))
	    return new Vehicule(vehiculeType, gasType, closedDoors);
	throw new IllegalArgumentException();
    }

}
