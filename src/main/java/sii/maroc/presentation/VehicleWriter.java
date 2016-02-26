package sii.maroc.presentation;

public class VehicleWriter implements Writer {

    private static final Writer INSTANCE = new VehicleWriter();

    public static Writer getInstance() {
	// TODO Auto-generated method stub
	return INSTANCE;
    }

    @Override
    public String printMoving(String vehiculeType, Double gasConsumed) {
	String consumedGas = String.format("%.2f", gasConsumed);
	consumedGas = consumedGas.replace(",", ".");
	final String result = "DOORS OK, MOVING. The " + vehiculeType + " will consume " + consumedGas + " L";
	return result;
    }

    @Override
    public String printDoorsOpen(String vehiculeType, String openDoors) {
	final Printer printer = VehiculeDoorsPrinter.getInstance();
	switch (vehiculeType) {
	case "CAR":

	    return printer.writeOpenCARDoors(openDoors);

	case "TRUCK":

	    return printer.writeOpenTRUCKDoors(openDoors);
	case "TwoDoorsCar":

	    return printer.writeOpenTwoDoorsCarDoors(openDoors);
	default:
	    throw new IllegalArgumentException();
	}

    }

}
