package sii.maroc.presentation.report;

import java.util.LinkedList;
import java.util.List;

import sii.maroc.presentation.report.parameters.ConsumptionParameter;
import sii.maroc.presentation.report.parameters.OpenDoorsParameter;
import sii.maroc.presentation.report.parameters.Parameter;
import sii.maroc.presentation.report.parameters.VehiculeTypeParameter;
import sii.maroc.vehicle.Vehicle;

public class ReportFactory {
    private static ReportFactory INSTANCE = new ReportFactory();

    private ReportFactory() {
    }

    public static ReportFactory getInstance() {
	return INSTANCE;
    }

    public Report createReport(Vehicle vehicle, String distanceInKM) {
	List<Parameter> parameters = new LinkedList<>();
	if (vehicle.canMove()) {
	    parameters = createSuccessReportParameters(vehicle, distanceInKM);
	    return new SuccessReport(parameters);
	}
	parameters = createFailReportParameters(vehicle);
	return new FailReport(parameters);
    }

    private List<Parameter> createSuccessReportParameters(Vehicle vehicle, String distanceInKM) {
	List<Parameter> parameters = new LinkedList<>();
	final Parameter vehicleType = new VehiculeTypeParameter(vehicle);
	final Parameter consumption = new ConsumptionParameter(vehicle, distanceInKM);
	parameters.add(vehicleType);
	parameters.add(consumption);
	return parameters;
    }

    private List<Parameter> createFailReportParameters(Vehicle vehicle) {
	List<Parameter> parameters = new LinkedList<>();
	final Parameter openDoorsParam = new OpenDoorsParameter(vehicle);
	parameters.add(openDoorsParam);
	return parameters;
    }

}
