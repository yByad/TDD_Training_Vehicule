package sii.maroc.presentation;

public interface Writer {

    String printWhenKO(String vehiculeType, String closedDoors);

    String printWhenOK(String vehiculeType, float gasConsumed);

}
