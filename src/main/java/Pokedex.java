import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Pokedex {
    private final List<PokedexEntry> pokemon;

    public Pokedex() throws IOException {
        InputStream stream = getClass().getResourceAsStream("/pokedex/pokedex.json");
        this.pokemon = new ObjectMapper().readValue(stream, new TypeReference<List<PokedexEntry>>() {});
    }

    public List<PokedexEntry> getPokemonList() {
        return pokemon;
    }

    public List<String> getPokemonTypes(String pokemonName){

        for(PokedexEntry entry : pokemon) {
            if(entry.pokemonName().equals(pokemonName)) {
                return entry.types();
            }
        }

       throw new IllegalArgumentException("Unable to find the pokemon with the name: " + pokemonName );
    }

}
