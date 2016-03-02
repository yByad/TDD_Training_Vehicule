package sii.maroc.vehicle;

import sii.maroc.vehicle.doors.Doors;

public class Vehicle {

    private final VehicleTypes vehiculeType;
    private final Fuel gasType;
    private Doors doors;

    Vehicle(VehicleTypes vehiculeType, Fuel gasType, Doors doors) {
	this.vehiculeType = vehiculeType;
	this.gasType = gasType;
	this.doors = doors;
    }

    public Double calculateConsumedGas(Double distance) {
	Double consumedGas = this.gasType.calculateConsumedGas(distance);
	return consumedGas;
    }

    public boolean canMove() {
	return doors.doorsAreClosed();
    }

    public VehicleTypes getVehiculeType() {
	return vehiculeType;
    }

    public String retrieveOpenDoors() {
	return doors.getOpenDoors();
    }

}
