package sii.maroc.presentation;

import java.util.Map;

import sii.maroc.vehicle.Fuel;
import sii.maroc.vehicle.ParametersProvider;
import sii.maroc.vehicle.Vehicle;
import sii.maroc.vehicle.VehicleFactory;

public class Vehicles {

    final private VehicleFactory factory = VehicleFactory.getInstance();
    final private Map<String, Fuel> fuels;

    public Vehicles(String consumptions) {
	final ParametersProvider provider = ParametersProvider.getInstance();
	fuels = provider.extractConsumptions(consumptions);
    }

    public String move(String vehiculeType, String gasType, String closedDoors, String distanceInKM) {
	final Fuel fuel = fuels.get(gasType);
	final Vehicle vehicle = factory.createVehicule(vehiculeType, fuel);
	final Report report = ReportFactory.getInstance().createReport(vehicle, distanceInKM, closedDoors);
	return report.report();
    }
}
