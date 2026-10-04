import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class PokedexTests {
    @Test
    void thereAreAlotOfPokemon() throws Exception {
        Pokedex pokedex = new Pokedex();
        assertEquals(1171, pokedex.getPokemonList().size());
    }

    @Test
    void toxapexTypeIsPoisonAndWater() throws Exception {
        Pokedex pokedex = new Pokedex();
        assertEquals(List.of("Poison", "Water"), pokedex.getPokemonTypes("Toxapex"));
    }
    
}
