package sii.maroc.vehicle;

import java.util.Map;

import sii.maroc.presentation.VehicleWriter;
import sii.maroc.presentation.Writer;

public class Vehicles {

    final private Writer writer;
    final private VehicleFactory factory = VehicleFactory.getInstance();
    final private ParametersProvider converter = ParametersProvider.getInstance();

    public Vehicles(String consumptions) {
	final Map<String, Integer> newConsumptions = converter.extractConsumptions(consumptions);
	GasTypes.defineConsumptions(newConsumptions);
	writer = VehicleWriter.getInstance();
    }

    public String move(String vehiculeType, String gasType, String closedDoors, String distanceInKM) {
	final Vehicle vehicle = factory.createVehicule(vehiculeType, gasType);
	final String doors = converter.removeSpaces(closedDoors);
	if (doorsAreOK(vehicle, doors, vehiculeType)) {
	    final Double distance = converter.transformToDistance(distanceInKM);
	    return printWhenDoorsClosed(vehicle, vehiculeType, distance);
	}
	return printWhenDoorsOpen(vehiculeType, doors);
    }

    private String printWhenDoorsClosed(Vehicle vehicle, String vehiculeType, Double distance) {
	final Double gasConsumed = vehicle.calculateConsumedGas(distance);
	return writer.printMoving(vehiculeType, gasConsumed);
    }

    private Boolean doorsAreOK(final Vehicle vehicle, final String closedDoors, final String vehiculeType) {
	final String regularExpression = VehiclesTypes.valueOf(vehiculeType).getTypeRegEx();
	if (closedDoors.matches(regularExpression))
	    return vehicle.doorsAreClosed(closedDoors);
	throw new IllegalArgumentException();
    }

    private String printWhenDoorsOpen(String vehiculeType, String closedDoors) {
	final String openDoors = retrieveOpenDoors(vehiculeType, closedDoors);
	return writer.printDoorsOpen(vehiculeType, openDoors);
    }

    String retrieveOpenDoors(final String vehiculeType, String closedDoors) {
	String openDoors = "";
	final String possibleDoors = VehiclesTypes.valueOf(vehiculeType).getDoors();
	for (int i = 0; i < possibleDoors.length(); i++) {
	    final String possibleDoor = possibleDoors.charAt(i) + "";
	    openDoors += addOpenDoor(possibleDoor, closedDoors);
	}
	return openDoors;
    }

    private String addOpenDoor(final String possibleDoor, final String closedDoors) {
	if (!closedDoors.contains(possibleDoor))
	    return possibleDoor;
	return "";
    }
}
