package sii.maroc.presentation;

import sii.maroc.vehicle.Vehicle;

public class OpenDoorsParameter extends Parameter {

    private final String openDoorsPresenation;

    public OpenDoorsParameter(final Vehicle vehicle, final String closedDoors) {
	this.openDoorsPresenation = printDoorsOpen(vehicle, closedDoors);
    }

    @Override
    public String getMessage() {
	return openDoorsPresenation;
    }

    private String printDoorsOpen(final Vehicle vehicle, final String closedDoors) {

	final Printer printer = VehiculePrinter.getInstance();
	final String openDoors = vehicle.retrieveOpenDoors(closedDoors);
	switch (vehicle.getVehiculeType()) {
	case CAR:
	    return printer.writeOpenCARDoors(openDoors);
	case TRUCK:
	    return printer.writeOpenTRUCKDoors(openDoors);
	case TwoDoorsCar:
	    return printer.writeOpenTwoDoorsCarDoors(openDoors);
	default:
	    throw new IllegalArgumentException();
	}
    }

}
