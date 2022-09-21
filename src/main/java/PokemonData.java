
import java.io.File;
import java.util.List;

// Create an object with the data retrieved from the JSON
class PokemonData {

    // Attributes required for each Pokémon
    private int pokemonId;
    private String pokemonName;
    private List<String> pokemonTypes;
    private List<File> pokemonSprites;

    // Constructor for Pokémon instance
    public PokemonData(int id, String name, List<String> types, List<File> sprites) {
        this.pokemonId = id;
        this.pokemonName = name;
        this.pokemonTypes = types;
        this.pokemonSprites = sprites;

    }

    public int getPokemonId() {
        return pokemonId;
    }

    public String getPokemonName() {
        pokemonName = pokemonName.substring(0,1).toUpperCase() + pokemonName.substring(1).toLowerCase();
        return pokemonName;
    }

    public List<String> getPokemonTypes() {
        return pokemonTypes;
    }

    public List<File> getPokemonSprites() {
        return pokemonSprites;
    }

    public String toString(){
        if (getPokemonTypes().size() > 1){
            return (getPokemonName() + "! A " + getPokemonTypes().get(0) + " and " + getPokemonTypes().get(1) + " type Pokemon." + "\nWith an ID of " + getPokemonId() );

        }
        return (getPokemonName() + "! A " + getPokemonTypes().get(0) + " type Pokemon." + "\nWith an ID of " + getPokemonId() );

    }



}