package sii.maroc.vehicle.doors;

import java.util.LinkedList;
import java.util.List;

import sii.maroc.vehicle.VehicleTypes;
import sii.maroc.vehicle.doors.Door.DoorState;

public class DoorsFactory {

    private static final DoorsFactory INSTANCE = new DoorsFactory();

    public static DoorsFactory getInstance() {
	return INSTANCE;
    }

    public Doors createDoorsOf(VehicleTypes vehiculeType, String closedDoors) {
	List<Door> doors = new LinkedList<>();
	final List<DoorPositions> doorsPositions = DoorPositions.retrieveDoorPosition(vehiculeType.getDoors());
	for (DoorPositions doorPositions : doorsPositions) {
	    doors.add(new Door(doorPositions, DoorState.OPEN));
	}
	return new Doors(doors).closeDoors(closedDoors);
    }

}
