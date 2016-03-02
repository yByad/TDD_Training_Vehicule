package sii.maroc.vehicle.doors;

import java.util.LinkedList;
import java.util.List;

public enum DoorPositions {
    FRONT_LEFT(1), FRONT_RIGHT(2), BACK_LEFT(3), BACK_RIGHT(4);
    private final int numberOfDoor;

    private DoorPositions(int numberOfDoor) {
	this.numberOfDoor = numberOfDoor;
    }

    public int getNumberOfDoor() {
	return this.numberOfDoor;
    }

    public static List<DoorPositions> retrieveDoorPosition(String doors) {
	List<DoorPositions> doorPositions = new LinkedList<>();
	if (doors.contains("1"))
	    doorPositions.add(FRONT_LEFT);
	if (doors.contains("2"))
	    doorPositions.add(FRONT_RIGHT);
	if (doors.contains("3"))
	    doorPositions.add(BACK_LEFT);
	if (doors.contains("4"))
	    doorPositions.add(BACK_RIGHT);
	return doorPositions;
    }

}