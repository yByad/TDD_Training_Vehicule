package sii.maroc.vehicle;

public enum VehicleTypes {

    CAR("1 2 3 4", "1?2?3?4?"), TRUCK("1 2", "1?2?"), MOTORCYCLE("", ""), TwoDoorsCar("1 2", "1?2?");

    private final String doors;
    private final String reg;

    private VehicleTypes(final String doors, final String reg) {
	this.doors = doors;
	this.reg = reg;
    }

    public String getDoors() {
	return doors;
    }

    public String getTypeRegEx() {
	return reg;
    }
}
