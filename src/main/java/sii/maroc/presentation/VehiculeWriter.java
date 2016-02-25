package sii.maroc.presentation;

import sii.maroc.vehicule.VehiclesTypes;

public class VehiculeWriter implements Writer {

    @Override
    public String writeOpenDoors(VehiclesTypes vehiculeType, String closedDoors) {
	switch (vehiculeType) {
	case CAR:
	    return writeOpenCarDoors(closedDoors);
	case TRUCK:
	    return writeOpenTruckDoors(closedDoors);
	case MOTORCYCLE:
	    return writeOpenMotorDoors(closedDoors);
	default:
	    throw new IllegalArgumentException();
	}
    }

    private String writeOpenMotorDoors(String closedDoors) {
	if (!closedDoors.equals(VehiclesTypes.MOTORCYCLE.getDoors()))
	    throw new IllegalArgumentException();
	return closedDoors;
    }

    private String writeOpenTruckDoors(String closedDoors) {
	String result = "DOORS KO, BLOCKED \n" + "  _\n";
	result += writeFrontLeftDoorStatus(closedDoors);
	result += writeTruckRightDoorStatus(closedDoors);
	return result;
    }

    private String writeTruckRightDoorStatus(String closedDoors) {
	if (closedDoors.contains("2"))
	    return DoorPresentqtions.BACK_RIGHT_CLOSED.getDoorRepresentation();
	return DoorPresentqtions.BACK_RIGHT_OPEN.getDoorRepresentation();
    }

    private String writeOpenCarDoors(String closedDoors) {
	String result = "DOORS KO, BLOCKED \n" + "  _\n";
	result += writeFrontLeftDoorStatus(closedDoors);
	result += writeFrontRightDoorStatus(closedDoors);
	result += writeBackLeftDoorStatus(closedDoors);
	result += writeBackRightDoorStatus(closedDoors);
	return result;
    }

    private String writeBackRightDoorStatus(String closedDoors) {
	if (closedDoors.contains("4"))
	    return DoorPresentqtions.BACK_RIGHT_CLOSED.getDoorRepresentation();
	return DoorPresentqtions.BACK_RIGHT_OPEN.getDoorRepresentation();
    }

    private String writeBackLeftDoorStatus(String closedDoors) {
	if (closedDoors.contains("3"))
	    return DoorPresentqtions.BACK_LEFT_CLOSED.getDoorRepresentation();
	return DoorPresentqtions.BACK_LEFT_OPEN.getDoorRepresentation();
    }

    private String writeFrontRightDoorStatus(String closedDoors) {
	if (closedDoors.contains("2"))
	    return DoorPresentqtions.FRONT_RIGHT_CLOSED.getDoorRepresentation();
	return DoorPresentqtions.FRONT_RIGHT_OPEN.getDoorRepresentation();
    }

    private String writeFrontLeftDoorStatus(String closedDoors) {
	if (closedDoors.contains("1"))
	    return DoorPresentqtions.FRONT_LEFT_CLOSED.getDoorRepresentation();
	return DoorPresentqtions.FRONT_LEFT_OPEN.getDoorRepresentation();
    }

    @Override
    public String print(VehiclesTypes vehiculeType, float gasConsumed) {
	String consumedGas = String.format("%.2f", gasConsumed);
	consumedGas = consumedGas.replace(",", ".");
	final String result = "DOORS OK, MOVING. The " + vehiculeType.name() + " will consume " + consumedGas + " L";
	return result;
    }

}
