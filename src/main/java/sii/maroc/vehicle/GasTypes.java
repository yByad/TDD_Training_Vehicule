package sii.maroc.vehicle;

import java.util.Map;

enum GasTypes {
    Diesel(5), Fuel(6), Hybrid(3);

    private int consumptionPercentage;

    private GasTypes(int consumption) {
	this.setConsumptionPurcentage(consumption);
    }

    int getConsumptionPercentage() {
	return consumptionPercentage;
    }

    public void setConsumptionPurcentage(final int consumptionPurcentage) {
	this.consumptionPercentage = consumptionPurcentage;
    }

    static void defineConsumptions(Map<String, Integer> consumptionPerType) {
	for (String type : consumptionPerType.keySet()) {
	    GasTypes.valueOf(type).setConsumptionPurcentage(consumptionPerType.get(type));
	}
    }

}
