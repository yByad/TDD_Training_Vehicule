package sii.maroc.vehicle;

enum VehiclesTypes {

    CAR("1 2 3 4 "), TRUCK("1 2 "), MOTORCYCLE(""), TwoDoorsCar("1 2 ");

    private final String doors;

    private VehiclesTypes(final String doors) {
	this.doors = doors;
    }

    String getDoors() {
	return new ParametersProvider().removeSpaces(doors);
    }

    String getTypeRegEx() {
	String reg = new ParametersProvider().changeCharacters(doors, " ", "?");
	return reg;
    }
}
