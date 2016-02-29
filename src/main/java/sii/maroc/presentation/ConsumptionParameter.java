package sii.maroc.presentation;

import sii.maroc.vehicle.ParametersProvider;
import sii.maroc.vehicle.Vehicle;

public class ConsumptionParameter extends Parameter {

    private Double consumption;

    public ConsumptionParameter(Vehicle vehicle, String distanceInKM) {
	final Double distance = ParametersProvider.getInstance().transformToDistance(distanceInKM);
	this.consumption = vehicle.calculateConsumedGas(distance);
    }

    @Override
    public String getMessage() {
	final String consumedGas = String.format("%.2f", consumption).replaceAll(",", ".");
	return "will consume " + consumedGas + " L";
    }

}
