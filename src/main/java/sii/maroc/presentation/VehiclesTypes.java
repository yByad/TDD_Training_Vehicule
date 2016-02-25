package sii.maroc.presentation;

public enum VehiclesTypes {

    CAR("1 2 3 4"), TRUCK("1 2"), MOTORCYCLE("");

    private final String doors;

    private VehiclesTypes(final String doors) {
	this.doors = doors;
    }

    public String getDoors() {
	return doors;
    }

    public String getTypeRegEx() {
	String reg = doors.replaceAll("\\s", "?");
	if (reg.isEmpty())
	    return reg;
	reg += "?";
	return reg;
    }

}
