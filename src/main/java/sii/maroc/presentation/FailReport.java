package sii.maroc.presentation;

import java.util.LinkedList;
import java.util.List;

import sii.maroc.vehicle.OpenDoorsParameter;
import sii.maroc.vehicle.Vehicle;

public class FailReport implements Report {

    private final List<Parameter> parameters;

    public FailReport(Vehicle vehicle, String closedDoors) {
	final Parameter openDoorsParam = new OpenDoorsParameter(vehicle, closedDoors);
	this.parameters = new LinkedList<Parameter>();
	this.parameters.add(openDoorsParam);

    }

    @Override
    public String report() {
	String report = "DOORS KO, BLOCKED \n";
	for (Parameter parameter : parameters) {
	    report += parameter.getMessage();
	}
	return report;
    }

}
