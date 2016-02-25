package sii.maroc.presentation;

public enum DoorPresentations {

    FRONT_LEFT_OPEN(" /"), FRONT_LEFT_CLOSED(" |"), FRONT_RIGHT_OPEN(" \\\n"), FRONT_RIGHT_CLOSED(
	    " |\n"), BACK_LEFT_OPEN(" /"), BACK_LEFT_CLOSED(" |"), BACK_RIGHT_OPEN("_\\"), BACK_RIGHT_CLOSED("_|");

    final private String doorPresentation;

    private DoorPresentations(String doorRepresentation) {
	this.doorPresentation = doorRepresentation;
    }

    public String getDoorRepresentation() {
	return doorPresentation;
    }

}
