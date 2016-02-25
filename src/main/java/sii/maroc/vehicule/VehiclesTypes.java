package sii.maroc.vehicule;

public enum VehiclesTypes {

    CAR("1 2 3 4"), TRUCK("1 2"), MOTORCYCLE("");

    private final String doors;

    private VehiclesTypes(final String doors) {
	this.doors = doors;
    }

    public String getDoors() {
	return doors;
    }

}
