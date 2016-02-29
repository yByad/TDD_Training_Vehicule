package sii.maroc.vehicle;

public class Vehicle {

    private final VehicleTypes vehiculeType;
    private final GasTypes gasType;

    Vehicle(VehicleTypes vehiculeType, GasTypes gasType) {
	this.vehiculeType = vehiculeType;
	this.gasType = gasType;
    }

    public Double calculateConsumedGas(Double distance) {
	Double consumedGas = distance * gasType.getConsumptionPercentage() / 100;
	return consumedGas;
    }

    boolean canMove(String closedDoors) {
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
