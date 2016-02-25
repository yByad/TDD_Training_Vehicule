package sii.maroc.presentation;

public interface Writer {

    String printWhenKO(VehiclesTypes vehiculeType, String closedDoors);

    String printWhenOK(VehiclesTypes vehiculeType, float gasConsumed);

}
