package sii.maroc.vehicle;

public class Fuel {

    public enum GasTypes {
	Diesel, Fuel, Hybrid;
    }

    private final GasTypes type;
    private final int consumptionPercentage;

    public Fuel(GasTypes type, Integer consumtion) {
	this.type = type;
	this.consumptionPercentage = consumtion;
    }

    public Double calculateConsumedGas(Double distance) {
	return (distance * this.consumptionPercentage) / 100;
    }

    public GasTypes getType() {
	return type;
    }

}
