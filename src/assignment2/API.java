package assignment2;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class API {

    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon/";
    private static final String ANIMATION_URL = "https://play.pokemonshowdown.com/sprites/ani/%s.gif";

    public static String fetchImage(String name) {

        try {

            URL url = new URL(API_URL + name);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            String rawData = "";
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                rawData += scanner.nextLine();
            }

            scanner.close();

            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            try {
                JSONObject data_obj = (JSONObject) parse.parse(rawData);
                JSONObject sprites = (JSONObject) data_obj.get("sprites");
                return sprites.get("front_default").toString();
            }
            catch(ParseException e){
                System.out.println("Invalid JSON format");
            }


        }
        catch(MalformedURLException e){
            System.out.println("malformed url given");
        }
        catch(IOException e) {
            System.out.println("Error grabbing the data");
        }

        return "";


    }

    public static String fetchAnimation(String pokemonName) {

        return String.format(ANIMATION_URL, pokemonName);

    }


}
