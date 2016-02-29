package sii.maroc.vehicle;

import java.util.Map;

enum GasTypes {
    Diesel(5), Fuel(6), Hybrid(3);

    private int consumptionPercentage;

    private GasTypes(int consumption) {
	this.consumptionPercentage = consumption;
    }

    static void defineConsumptions(Map<GasTypes, Integer> newConsumptions) {
	for (GasTypes type : newConsumptions.keySet()) {
	    type.consumptionPercentage = newConsumptions.get(type);
	}
    }

    public Double calculateConsumedGas(Double distance) {
	return distance * this.consumptionPercentage / 100;
    }

}
