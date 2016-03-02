package sii.maroc.presentation;

import java.util.Map;

import sii.maroc.presentation.report.Report;
import sii.maroc.presentation.report.ReportFactory;
import sii.maroc.provider.ParametersProvider;
import sii.maroc.vehicle.Fuel;
import sii.maroc.vehicle.Vehicle;
import sii.maroc.vehicle.VehicleFactory;

public class Vehicles {

    final private VehicleFactory factory = VehicleFactory.getInstance();
    final private Map<String, Fuel> fuels;

    public Vehicles(String consumptions) {
	fuels = ParametersProvider.getInstance().extractConsumptions(consumptions);
    }

    public String move(String vehiculeType, String gasType, String closedDoors, String distanceInKM) {
	final Fuel fuel = fuels.get(gasType);
	final Vehicle vehicle = factory.createVehicule(vehiculeType, fuel, closedDoors);
	final Report report = ReportFactory.getInstance().createReport(vehicle, distanceInKM);
	return report.report();
    }
}
