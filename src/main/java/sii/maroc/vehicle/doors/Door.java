package sii.maroc.vehicle.doors;

public class Door {
    public enum DoorState {
	OPEN, CLOSED;
    }

    private final DoorPositions position;
    private final DoorState state;

    public Door(DoorPositions position, DoorState state) {
	this.position = position;
	this.state = state;
    }

    public Boolean isClosed() {
	return (this.state.equals(DoorState.CLOSED));
    }

    public DoorPositions getDoorPosition() {
	return this.position;
    }

    public Door close() {
	return new Door(position, DoorState.CLOSED);
    }

    public int getNumberOfDoor() {
	return this.position.getNumberOfDoor();
    }
}
