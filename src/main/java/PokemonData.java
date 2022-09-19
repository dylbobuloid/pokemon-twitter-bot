import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;
import java.util.List;

// Create an object with the data retrieved from the JSON
class PokemonData {


    // Attributes required for each Pokémon
    private int pokemonId;
    private String pokemonName;
    private List<String> pokemonTypes;

    // Constructor for Pokémon instance
    public PokemonData(int id, String name, List<String> types, List<String> sprites) {
        this.pokemonId = id;
        this.pokemonName = name;
        this.pokemonTypes = types;
        this.pokemonSprites = sprites;

    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public List<String> getPokemonTypes() {
        return pokemonTypes;
    }

    public void setPokemonTypes(List<String> pokemonTypes) {
        this.pokemonTypes = pokemonTypes;
    }

    public List<String> getPokemonSprites() {
        return pokemonSprites;
    }

    public void setPokemonSprites(List<String> pokemonSprites) {
        this.pokemonSprites = pokemonSprites;
    }

    public String toString(){
        if (getPokemonTypes().size() > 1){
            return ("The Pokemon is " + getPokemonName() + " with an ID of " + getPokemonId() + "\n Which is a " + getPokemonTypes().get(0) + " and " + getPokemonTypes().get(1) + " type.");

        }
        return ("The Pokemon is " + getPokemonName() + " with an ID of " + getPokemonId() + "\n Which is a " + getPokemonTypes().get(0) + " type.");

    }

    private List<String> pokemonSprites;

}