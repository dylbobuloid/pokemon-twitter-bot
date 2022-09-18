import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;
import java.util.List;

// Create an object with the data retrieved from the JSON
class PokemonData {


    // Attributes required for each Pokémon
    private int pokemonId;
    private String pokemonName;
    private List<String> pokemonTypes;
    private List<String> pokemonSprites;

    // Constructor for Pokémon instance
    public PokemonData(int id, String name, List<String> types, List<String> sprites) {
        this.pokemonId = id;
        this.pokemonName = name;
        this.pokemonTypes = types;
        this.pokemonSprites = sprites;

    }
}