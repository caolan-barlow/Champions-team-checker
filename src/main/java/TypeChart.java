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
}
