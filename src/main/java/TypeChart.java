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

    public double getDamageMultiplier(String attackingType, String defendingType) {

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

}


