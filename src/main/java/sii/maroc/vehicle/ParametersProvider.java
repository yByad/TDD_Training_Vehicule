package sii.maroc.vehicle;

import java.util.HashMap;
import java.util.Map;

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

    public Map<String, Integer> extractConsumptions(final String consumptions) {
	final String[] pourcentagesPerType = consumptions.split(",");
	Map<String, Integer> consumptionPerType = new HashMap<String, Integer>();
	for (String pourcentage : pourcentagesPerType) {
	    final String[] consumption = pourcentage.split(":");
	    consumption[1] = consumption[1].replaceAll("%$", "");
	    final String type = consumption[0];
	    final Integer newPercentage = Integer.parseInt(consumption[1]);
	    consumptionPerType.put(type, newPercentage);
	}
	return consumptionPerType;
    }

}
