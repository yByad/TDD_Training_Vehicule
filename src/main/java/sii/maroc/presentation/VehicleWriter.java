package sii.maroc.presentation;

import java.lang.reflect.Method;

public class VehicleWriter implements Writer {

    @Override
    public String printWhenOK(String vehiculeType, float gasConsumed) {
	String consumedGas = String.format("%.2f", gasConsumed);
	consumedGas = consumedGas.replace(",", ".");
	final String result = "DOORS OK, MOVING. The " + vehiculeType + " will consume " + consumedGas + " L";
	return result;
    }

    @Override
    public String printWhenKO(String vehiculeType, String openDoors) {
	String result = "";
	try {
	    final String methodToCall = "writeOpen" + vehiculeType + "Doors";
	    final Class<?> c = Class.forName(this.getClass().getName());
	    final Method method = c.getDeclaredMethod(methodToCall, String.class);
	    result = method.invoke(this, openDoors).toString();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return result;

    }

    private String writeOpenTwoDoorsCarDoors(String openDoors) {
	String result = "DOORS KO, BLOCKED \n" + " _\n" + "  l_l\n";
	result += writeFrontLeftDoorStatus(openDoors);
	result += writeTruckRightDoorStatus(openDoors);
	result += " l_l";
	return result;
    }

    private String writeOpenTRUCKDoors(String openDoors) {
	String result = "DOORS KO, BLOCKED \n" + "  _\n";
	result += writeFrontLeftDoorStatus(openDoors);
	result += writeTruckRightDoorStatus(openDoors);
	return result;
    }

    private String writeOpenCARDoors(String openDoors) {
	String result = "DOORS KO, BLOCKED \n" + "  _\n";
	result += printFrontDoorsStatus(openDoors);
	result += printBackDoorsStatus(openDoors);
	return result;
    }

    private String writeTruckRightDoorStatus(String openDoors) {
	if (openDoors.contains("2"))
	    return DoorPresentations.BACK_RIGHT_OPEN.getDoorRepresentation();
	return DoorPresentations.BACK_RIGHT_CLOSED.getDoorRepresentation();
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
