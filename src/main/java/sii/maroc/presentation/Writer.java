package sii.maroc.presentation;

import sii.maroc.vehicule.VehiclesTypes;

public interface Writer {

    String printWhenKO(VehiclesTypes vehiculeType, String closedDoors);

    String printWhenOK(VehiclesTypes vehiculeType, float gasConsumed);

}
