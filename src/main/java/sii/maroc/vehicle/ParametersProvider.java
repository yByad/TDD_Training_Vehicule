package sii.maroc.vehicle;

import java.util.HashMap;
import java.util.Map;

import sii.maroc.vehicle.Fuel.GasTypes;

public class ParametersProvider {

    private static final ParametersProvider INSTANCE = new ParametersProvider();

    public static ParametersProvider getInstance() {
	// TODO Auto-generated method stub
	return INSTANCE;
    }

    public String removeSpaces(final String charactersToremoveSpacesFrom) {
	final String trimmed = charactersToremoveSpacesFrom.replaceAll(" ", "");
	return trimmed;
    }

    public String changeCharacters(final String toChange, final String oldCharacter, final String newCharacter) {
	final String changed = toChange.replaceAll(oldCharacter, newCharacter);
	return changed;

    }

    public Double transformToDistance(String distanceInKM) {
	distanceInKM = distanceInKM.replaceAll(" KM", "");
	final Double distance = Double.valueOf(distanceInKM);
	return distance;
    }

    public Map<String, Fuel> extractConsumptions(final String newConsumptions) {
	Map<String, Fuel> newConsumptionPerType = new HashMap<>();
	final String[] pourcentagesPerType = newConsumptions.split(",");
	for (String pourcentage : pourcentagesPerType) {
	    final String[] consumptions = pourcentage.split(":");
	    consumptions[1] = consumptions[1].replaceAll("%$", "");
	    final GasTypes type = GasTypes.valueOf(consumptions[0]);
	    final Integer newPercentage = Integer.parseInt(consumptions[1]);
	    newConsumptionPerType.put(type.name(), new Fuel(type, newPercentage));
	}
	return newConsumptionPerType;
    }

}
