package sii.maroc.vehicule;

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

    public float move(String distanceInKM) {
	distanceInKM = distanceInKM.replaceAll(" KM$", "");
	final int distance = Integer.parseInt(distanceInKM);
	final float gasConsumed = calculateConsumption(distance);
	return gasConsumed;
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

    public String retrieveOpenDoors() {
	final String doors = closedDoors.replaceAll(" ", "");
	if (doors.matches("1?2?3?4?")) {
	    final String openDoors = fetchOpenDoors();
	    return openDoors;
	}
	throw new IllegalArgumentException();
    }

    private String fetchOpenDoors() {
	final String possibleDoors = VehiclesTypes.CAR.getDoors().replaceAll(" ", "");
	String openDoors = "";
	for (int i = 0; i < possibleDoors.length(); i++) {
	    final String door = possibleDoors.charAt(i) + "";
	    if (!closedDoors.contains(door))
		openDoors += door;
	}
	return openDoors;
    }

    public Vehicule closeDoors(String closedDoors) {
	return new Vehicule(vehiculeType, gasType, closedDoors);
    }

}
