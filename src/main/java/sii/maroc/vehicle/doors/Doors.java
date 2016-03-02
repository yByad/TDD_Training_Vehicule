package sii.maroc.vehicle.doors;

import java.util.List;

import sii.maroc.provider.ParametersProvider;

public class Doors {
    private List<Door> doors;

    public Doors(List<Door> doors) {
	this.doors = doors;
    }

    public Boolean doorsAreClosed() {
	for (Door door : doors) {
	    if (!door.isClosed())
		return false;
	}
	return true;
    }

    public Doors closeDoors(String closedDoors) {
	if (doorsOk(closedDoors))
	    return close(closedDoors);
	throw new IllegalArgumentException();
    }

    private boolean doorsOk(String closedDoors) {
	closedDoors = ParametersProvider.getInstance().removeSpaces(closedDoors);
	return closedDoors.matches(getDoorsExpression());
    }

    private Doors close(String closedDoors) {
	final List<Door> doorsClosed = doors;
	for (Door door : doors) {
	    final List<DoorPositions> doorsClosedPositions = DoorPositions.retrieveDoorPosition(closedDoors);
	    if (doorsClosedPositions.contains(door.getDoorPosition()))
		doorsClosed.set(doorsClosed.indexOf(door), door.close());
	}
	return new Doors(doorsClosed);
    }

    private String getDoorsExpression() {
	String regEx = "";
	for (Door door : doors) {
	    regEx += door.getNumberOfDoor() + "?";
	}
	return regEx;
    }

    public String getOpenDoors() {
	String openDoors = "";
	for (Door door : doors) {
	    if (!door.isClosed())
		openDoors += door.getNumberOfDoor() + "";
	}
	return openDoors;
    }
}
