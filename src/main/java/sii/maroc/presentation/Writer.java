package sii.maroc.presentation;

import sii.maroc.vehicule.VehiclesTypes;

public interface Writer {

    String writeOpenDoors(VehiclesTypes vehiculeType, String closedDoors);

    String print(VehiclesTypes vehiculeType, float gasConsumed);

}
