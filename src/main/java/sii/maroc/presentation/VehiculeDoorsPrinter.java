package sii.maroc.presentation;

public class VehiculeDoorsPrinter implements Printer {

    private static final VehiculeDoorsPrinter INSTANCE = new VehiculeDoorsPrinter();

    public static VehiculeDoorsPrinter getInstance() {
	// TODO Auto-generated method stub
	return INSTANCE;
    }

    @Override
    public String writeOpenTwoDoorsCarDoors(String openDoors) {
	String result = "DOORS KO, BLOCKED \n" + "  _\n" + " l_l\n";
	result += writeFrontLeftDoorStatus(openDoors);
	result += writeTruckRightDoorStatus(openDoors);
	result += " l_l";
	return result;
    }

    @Override
    public String writeOpenTRUCKDoors(String openDoors) {
	String result = "DOORS KO, BLOCKED \n" + "  _\n";
	result += writeFrontLeftDoorStatus(openDoors);
	result += writeTruckRightDoorStatus(openDoors);
	return result;
    }

    @Override
    public String writeOpenCARDoors(String openDoors) {
	String result = "DOORS KO, BLOCKED \n" + "  _\n";
	result += printFrontDoorsStatus(openDoors);
	result += printBackDoorsStatus(openDoors);
	return result;
    }

    private String printBackDoorsStatus(String openDoors) {
	String result = writeBackLeftDoorStatus(openDoors);
	result += writeBackRightDoorStatus(openDoors);
	return result;
    }

    private String printFrontDoorsStatus(String openDoors) {
	String result = writeFrontLeftDoorStatus(openDoors);
	result += writeFrontRightDoorStatus(openDoors);
	return result;
    }

    private String writeTruckRightDoorStatus(String openDoors) {
	if (openDoors.contains("2"))
	    return DoorPresentations.BACK_RIGHT_OPEN.getDoorRepresentation();
	return DoorPresentations.BACK_RIGHT_CLOSED.getDoorRepresentation();
    }

    private String writeBackRightDoorStatus(String openDoors) {
	if (openDoors.contains("4"))
	    return DoorPresentations.BACK_RIGHT_OPEN.getDoorRepresentation();
	return DoorPresentations.BACK_RIGHT_CLOSED.getDoorRepresentation();
    }

    private String writeBackLeftDoorStatus(String openDoors) {
	if (openDoors.contains("3"))
	    return DoorPresentations.BACK_LEFT_OPEN.getDoorRepresentation();
	return DoorPresentations.BACK_LEFT_CLOSED.getDoorRepresentation();
    }

    private String writeFrontRightDoorStatus(String openDoors) {
	if (openDoors.contains("2"))
	    return DoorPresentations.FRONT_RIGHT_OPEN.getDoorRepresentation();
	return DoorPresentations.FRONT_RIGHT_CLOSED.getDoorRepresentation();
    }

    private String writeFrontLeftDoorStatus(String openDoors) {
	if (openDoors.contains("1"))
	    return DoorPresentations.FRONT_LEFT_OPEN.getDoorRepresentation();
	return DoorPresentations.FRONT_LEFT_CLOSED.getDoorRepresentation();
    }

}
