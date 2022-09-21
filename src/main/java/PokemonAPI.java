import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;
import twitter4j.TwitterException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PokemonAPI {
    public static void main(String[] args) throws TwitterException {

        PokemonData newPokemon = fetchPokemon();
        createTweet(newPokemon);

    }

    private static PokemonData fetchPokemon () {

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
        List<File> pokemonSprites = getSprites(randomPokemon.getSprites());

        return new PokemonData(randomPokemon.getId(), randomPokemon.getName(), pokemonType, pokemonSprites);
    }

    // Creates the Tweet using the Pokémon Data
    private static void createTweet(PokemonData randomPokemonData) throws TwitterException {
        TwitterAPI.tweetContents(randomPokemonData.toString(), randomPokemonData.getPokemonSprites().get(0), randomPokemonData.getPokemonSprites().get(1));
        System.out.println("The tweet has been created");
    }

    // Gets the front and back sprites only
    private static List<File> getSprites (PokemonSprites sprites) {
        List<String> spriteList = new ArrayList<>();


        spriteList.add(sprites.getFrontDefault());
        spriteList.add(sprites.getFrontShiny());

        return getPokemonSpritesToFile(spriteList);
    }

    // Converts the image URL String to an image
    private static List<File> getPokemonSpritesToFile(List<String> pokemonSprites) {

        String spriteLocalStorage = System.getProperty("spriteLocalStorage");

        //
        List<File> spriteFiles = new ArrayList<>();

        try
        {
            //Converting string to image and then writing the image into a File
            Image frontSprite = ImageIO.read(new URL(pokemonSprites.get(0)));
            Image frontShinySprite = ImageIO.read(new URL(pokemonSprites.get(1)));
            ImageIO.write((RenderedImage) frontSprite, "png", new File(spriteLocalStorage + "frontSprite.png"));
            ImageIO.write((RenderedImage) frontShinySprite, "png", new File(spriteLocalStorage + "frontShinySprite.png"));

            // Saving image to local file storage
            File frontSpriteImage = new File(spriteLocalStorage + "frontSprite.png");
            File frontShinySpriteImage = new File(spriteLocalStorage + "frontSprite.png");

            spriteFiles.add(0, frontSpriteImage);
            spriteFiles.add(1, frontShinySpriteImage);
        }
        catch (Exception e)
        {
            System.err.println("Error writing image to a file!");
        }

        return spriteFiles;
    }

    // Gets all the available types and adds it to a List
    private static List<String> getTypes(List<PokemonType> types) {
        List<String> nameOfTypes = new ArrayList<>();

        for (PokemonType type : types) {
            nameOfTypes.add(type.getType().getName());

        }
    return nameOfTypes;
    }
}
