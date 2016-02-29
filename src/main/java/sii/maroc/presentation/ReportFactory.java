package sii.maroc.presentation;

import java.util.LinkedList;
import java.util.List;

import sii.maroc.vehicle.Vehicle;

public class ReportFactory {
    private static ReportFactory INSTANCE = new ReportFactory();

    private ReportFactory() {
    }

    public static ReportFactory getInstance() {
	return INSTANCE;
    }

    public String createReport(Vehicle vehicle, String distanceInKM, String closedDoors) {
	List<Parameter> parameters = new LinkedList<>();
	if (vehicle.canMove(closedDoors)) {
	    parameters = createSuccessReportParameters(vehicle, distanceInKM);
	    return new SuccessReport(parameters).report();
	}
	parameters = createFailReportParameters(vehicle, closedDoors);
	return new FailReport(parameters).report();
    }

    private List<Parameter> createSuccessReportParameters(Vehicle vehicle, String distanceInKM) {
	List<Parameter> parameters = new LinkedList<>();
	final Parameter vehicleType = new VehiculeTypeParameter(vehicle);
	final Parameter consumption = new ConsumptionParameter(vehicle, distanceInKM);
	parameters.add(vehicleType);
	parameters.add(consumption);
	return parameters;
    }

    private List<Parameter> createFailReportParameters(Vehicle vehicle, String closedDoors) {
	List<Parameter> parameters = new LinkedList<>();
	final Parameter openDoorsParam = new OpenDoorsParameter(vehicle, closedDoors);
	parameters.add(openDoorsParam);
	return parameters;
    }

}
