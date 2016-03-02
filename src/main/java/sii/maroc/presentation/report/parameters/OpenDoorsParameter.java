package sii.maroc.presentation.report.parameters;

import sii.maroc.presentation.report.Printer;
import sii.maroc.presentation.report.VehiculePrinter;
import sii.maroc.vehicle.Vehicle;

public class OpenDoorsParameter extends Parameter {

    private final String openDoorsPresenation;

    public OpenDoorsParameter(final Vehicle vehicle) {
	this.openDoorsPresenation = printDoorsOpen(vehicle);
    }

    @Override
    public String getMessage() {
	return openDoorsPresenation;
    }

    private String printDoorsOpen(final Vehicle vehicle) {

	final Printer printer = VehiculePrinter.getInstance();
	final String openDoors = vehicle.retrieveOpenDoors();
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
