package sii.maroc.presentation.report;

public enum VehiculesComponents {

    LEFT_OPEN(" /"), RIGHT_OPEN("\\"), RIGHT_CLOSED("|"), HEAD("  _\n"), TAIL("_"), LEFT_CLOSED(" |");

    final private String doorPresentation;

    private VehiculesComponents(String doorRepresentation) {
	this.doorPresentation = doorRepresentation;
    }

    public String getPresentation() {
	return doorPresentation;
    }

}
