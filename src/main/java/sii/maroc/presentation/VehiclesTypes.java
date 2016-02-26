package sii.maroc.presentation;

public enum VehiclesTypes {

    CAR("1 2 3 4 "), TRUCK("1 2 "), MOTORCYCLE(""), TwoDoorsCar("1 2 ");

    private final String doors;

    private VehiclesTypes(final String doors) {
	this.doors = doors;
    }

    public String getDoors() {
	return doors.trim();
    }

    public String getTypeRegEx() {
	String reg = doors.replaceAll("\\s", "?");
	return reg;
    }

}
