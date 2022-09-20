import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
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

    public String getPokemonName() {
        pokemonName = pokemonName.substring(0,1).toUpperCase() + pokemonName.substring(1).toLowerCase();
        return pokemonName;
    }

    public List<String> getPokemonTypes() {
        return pokemonTypes;
    }

    public List<String> getPokemonSprites() {
        return pokemonSprites;
    }

    // Converts the image URL String to an image
    public List<File> getPokemonSpritesToFile() throws URISyntaxException {

        //
        List<File> spriteFiles = new ArrayList<File>();

            try
            {
                //Converting string to image and then writing the image into a File
                Image frontSprite = ImageIO.read(new URL(pokemonSprites.get(0)));
                Image frontShinySprite = ImageIO.read(new URL(pokemonSprites.get(1)));
                ImageIO.write((RenderedImage) frontSprite, "png", new File("C://Users/dylan/Desktop/Pokemon Sprites/frontSprite.png"));
                ImageIO.write((RenderedImage) frontShinySprite, "png", new File("C:/Users/dylan/Desktop/Pokemon Sprites/frontShinySprite.png"));

                // Saving image to local file storage
                File frontSpriteImage = new File("C://Users/dylan/Desktop/Pokemon Sprites/frontSprite.png");
                File frontShinySpriteImage = new File("C:/Users/dylan/Desktop/Pokemon Sprites/frontShinySprite.png");

                spriteFiles.add(0, frontSpriteImage);
                spriteFiles.add(1, frontShinySpriteImage);
            }
            catch (Exception e)
            {
                System.err.println("Error writing image to a file!");
            }

        return spriteFiles;
    }


    public String toString(){
        if (getPokemonTypes().size() > 1){
            return ("The Pokemon is " + getPokemonName() + ", a " + getPokemonTypes().get(0) + " and " + getPokemonTypes().get(1) + " type." + "\nWith an ID of " + getPokemonId() );

        }
        return ("The Pokemon is " + getPokemonName() + ", a " + getPokemonTypes().get(0) + " type." + "\nWith an ID of " + getPokemonId() );

    }

    private List<String> pokemonSprites;

}