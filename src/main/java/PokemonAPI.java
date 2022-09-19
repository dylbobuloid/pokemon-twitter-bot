import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PokemonAPI {
    public static void main(String[] args) throws TwitterException {

        // Creating a PokemonAPI instance
        PokeApi pokeApi = new PokeApiClient();

        // Retrieving the total number of Pokemon in the Database
        int numOfPokemon = pokeApi.getPokemonList(1,10000).getResults().size();

        // Generating a random number between 0 and the total size of the PokemonList
        Random rand = new Random();
        int randomNumber = rand.nextInt(numOfPokemon);

        // Retrieving the id from the randomly selected element in the PokemonList
        int randomId = pokeApi.getPokemonList(1,100048).getResults().get(randomNumber).getId();

        // Retrieving the JSON information on this endpoint
        Pokemon randomPokemon = pokeApi.getPokemon(randomId);

        List<String> pokemonType = getTypes(randomPokemon.getTypes());
        List<String> pokemonSprites = getSprites(randomPokemon.getSprites());
        PokemonData currentPokemon = new PokemonData(randomPokemon.getId(), randomPokemon.getName(), pokemonType, pokemonSprites);

        createTweet(currentPokemon);

        //System.out.println(randomPokemon);

    }

    // Creates the Tweet using the Pokémon Data
    private static void createTweet(PokemonData randomPokemonData) throws TwitterException {
        TwitterAPI.tweetContents(randomPokemonData.toString());
        System.out.println("The tweet has been created");
    }

    // Gets the front and back sprites only
    private static List<String> getSprites (PokemonSprites sprites){
        List<String> spriteList = new ArrayList<String>();

        spriteList.add(sprites.getFrontDefault());
        spriteList.add(sprites.getFrontShiny());

        return spriteList;
    }

    // Gets all the available types and adds it to a List
    private static List<String> getTypes(List<PokemonType> types) {
        List<String> nameOfTypes = new ArrayList<String>();

        for (int i = 0; i<types.size(); i++){
            nameOfTypes.add(types.get(i).getType().getName());

        }
    return nameOfTypes;
    }
}
