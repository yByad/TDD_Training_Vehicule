package sii.maroc.vehicle;

enum GasTypes {
    Diesel(5), Fuel(6), Hybrid(3);

    private int consumptionPercentage;

    private GasTypes(int consumption) {
	this.setConsumptionPurcentage(consumption);
    }

    int getConsumptionPercentage() {
	return consumptionPercentage;
    }

    private void setConsumptionPurcentage(final int consumptionPurcentage) {
	this.consumptionPercentage = consumptionPurcentage;
    }

    static void defineConsumptions(final String consumptions) {
	String[] pourcentagesPerType = consumptions.split(",");
	for (String pourcentage : pourcentagesPerType) {
	    final String[] consumption = pourcentage.split(":");
	    consumption[1] = consumption[1].replaceAll("%$", "");
	    final int newPercentage = Integer.parseInt(consumption[1]);
	    GasTypes.valueOf(consumption[0]).consumptionPercentage = newPercentage;
	}
    }

}
