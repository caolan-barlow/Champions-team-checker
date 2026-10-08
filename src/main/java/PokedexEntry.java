import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PokedexEntry(
        String pokemonName,
        List<String> types,
        @JsonProperty("HP") int hp,
        @JsonProperty("Atk") int atk,
        @JsonProperty("Def") int def,
        @JsonProperty("Sp.Atk") int spAtk,
        @JsonProperty("Sp.Def") int spDef,
        @JsonProperty("Speed") int speed) {}