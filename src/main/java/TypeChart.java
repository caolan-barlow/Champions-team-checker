import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TypeChart {
    private final List<TypeEntry> types;

    public TypeChart() throws IOException {
        InputStream stream = getClass().getResourceAsStream("/types/types.json");
        this.types = new ObjectMapper().readValue(stream, new TypeReference<List<TypeEntry>>() {});
    }

    public List<TypeEntry> getTypes() {
        return types;
    }

    private boolean isValidType(String typeName) {
        
        for (TypeEntry entry : types ) {
            if(typeName.equals(entry.name()) ){
                return true;
            }
        }

        return false;
    }

    private boolean isValidDualType(String typeName1, String typeName2) {
        return !typeName1.equals(typeName2);
}
    

    public double getDamageMultiplierForSingleType(String attackingType, String defendingType) {

        if (!isValidType(attackingType)) {
            throw new IllegalArgumentException("Unknown attacking type: " + attackingType);
        }

        if (!isValidType(defendingType)) {
            throw new IllegalArgumentException("Unknown defending type: " + defendingType);
        }

        double damageMultiplier = 1.0;

            for (TypeEntry entry : types) {
                if (entry.name().equals(defendingType)) {
                    if (entry.takesDoubleFrom().contains(attackingType)) {
                        damageMultiplier = 2.0;
                    } else if(entry.takesHalfFrom().contains(attackingType)) {
                        damageMultiplier = 0.5;
                    } else if(entry.takesNoneFrom().contains(attackingType)) {
                        damageMultiplier = 0.0;
                    }
                }
            }

            return damageMultiplier;
    }

    public double getDamageMultiplierForDualType(String attackingType, String defendingType1, String defendingType2) {

        if (!isValidDualType(defendingType1, defendingType2)) {
            throw new IllegalArgumentException("Defending types must be different, but both were: " + defendingType1);
        }

        double totaldamageMultiplier = 1.0;

        totaldamageMultiplier *= getDamageMultiplierForSingleType(attackingType, defendingType1);

        totaldamageMultiplier *= getDamageMultiplierForSingleType(attackingType, defendingType2);

        return totaldamageMultiplier;
    }

}


