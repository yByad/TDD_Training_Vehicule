package sii.maroc.vehicle;

class Vehicle {

    private final VehiclesTypes vehiculeType;
    private final GasTypes gasType;

    Vehicle(VehiclesTypes vehiculeType, GasTypes gasType) {
	this.vehiculeType = vehiculeType;
	this.gasType = gasType;
    }

    Double calculateConsumedGas(Double distance) {
	final Double gasConsumed = calculateConsumption(distance);
	return gasConsumed;
    }

    private Double calculateConsumption(Double distance) {
	Double consumedGas = distance * gasType.getConsumptionPercentage() / 100;
	return consumedGas;
    }

    boolean doorsAreClosed(final String closedDoors) {
	if (closedDoors.equals(vehiculeType.getDoors()))
	    return true;
	return false;
    }

}
