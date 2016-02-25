package sii.maroc.presentation;

public class VehiculeWriter implements Writer {

    @Override
    public String printWhenKO(VehiclesTypes vehiculeType, String openDoors) {
	switch (vehiculeType) {
	case CAR:
	    return writeOpenCarDoors(openDoors);
	case TRUCK:
	    return writeOpenTruckDoors(openDoors);
	default:
	    throw new IllegalArgumentException();
	}
    }

    private String writeOpenTruckDoors(String openDoors) {
	String result = "DOORS KO, BLOCKED \n" + "  _\n";
	result += writeFrontLeftDoorStatus(openDoors);
	result += writeTruckRightDoorStatus(openDoors);
	return result;
    }

    private String writeTruckRightDoorStatus(String openDoors) {
	if (openDoors.contains("2"))
	    return DoorPresentqtions.BACK_RIGHT_OPEN.getDoorRepresentation();
	return DoorPresentqtions.BACK_RIGHT_CLOSED.getDoorRepresentation();
    }

    private String writeOpenCarDoors(String openDoors) {
	String result = "DOORS KO, BLOCKED \n" + "  _\n";
	result += writeFrontLeftDoorStatus(openDoors);
	result += writeFrontRightDoorStatus(openDoors);
	result += writeBackLeftDoorStatus(openDoors);
	result += writeBackRightDoorStatus(openDoors);
	return result;
    }

    private String writeBackRightDoorStatus(String openDoors) {
	if (openDoors.contains("4"))
	    return DoorPresentqtions.BACK_RIGHT_OPEN.getDoorRepresentation();
	return DoorPresentqtions.BACK_RIGHT_CLOSED.getDoorRepresentation();
    }

    private String writeBackLeftDoorStatus(String openDoors) {
	if (openDoors.contains("3"))
	    return DoorPresentqtions.BACK_LEFT_OPEN.getDoorRepresentation();
	return DoorPresentqtions.BACK_LEFT_CLOSED.getDoorRepresentation();
    }

    private String writeFrontRightDoorStatus(String openDoors) {
	if (openDoors.contains("2"))
	    return DoorPresentqtions.FRONT_RIGHT_OPEN.getDoorRepresentation();
	return DoorPresentqtions.FRONT_RIGHT_CLOSED.getDoorRepresentation();
    }

    private String writeFrontLeftDoorStatus(String openDoors) {
	if (openDoors.contains("1"))
	    return DoorPresentqtions.FRONT_LEFT_OPEN.getDoorRepresentation();
	return DoorPresentqtions.FRONT_LEFT_CLOSED.getDoorRepresentation();
    }

    @Override
    public String printWhenOK(VehiclesTypes vehiculeType, float gasConsumed) {
	String consumedGas = String.format("%.2f", gasConsumed);
	consumedGas = consumedGas.replace(",", ".");
	final String result = "DOORS OK, MOVING. The " + vehiculeType.name() + " will consume " + consumedGas + " L";
	return result;
    }

}
