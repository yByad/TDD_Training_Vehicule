package sii.maroc.vehicule;

import sii.maroc.presentation.VehiculeWriter;

public class Vehicule {

    private final VehiclesTypes vehiculeType;
    private final GasTypes gasType;
    private final String closedDoors;

    public Vehicule(VehiclesTypes vehiculeType, GasTypes gasType) {
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

    public String move(String distanceInKM) {
	distanceInKM = distanceInKM.replaceAll(" KM$", "");
	final int distance = Integer.parseInt(distanceInKM);
	final float gasConsumed = calculateConsumption(distance);
	return new VehiculeWriter().print(vehiculeType, gasConsumed);
    }

    private float calculateConsumption(int distance) {
	float consumedGas = distance * gasType.getConsumptionPercentage() / 100;
	return consumedGas;
    }

    public boolean doorsOK() {
	if (closedDoors.equals(vehiculeType.getDoors()))
	    return true;
	return false;
    }

    public String OpenDoors() {
	final String doors = closedDoors.replaceAll(" ", "");
	if (doors.matches("1?2?3?4?"))
	    return new VehiculeWriter().writeOpenDoors(vehiculeType, closedDoors);
	throw new IllegalArgumentException();
    }

    public Vehicule closeDoors(String closedDoors) {
	return new Vehicule(vehiculeType, gasType, closedDoors);

    }

}
