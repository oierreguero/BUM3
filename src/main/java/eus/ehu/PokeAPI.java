package eus.ehu;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class PokeAPI {

    public static String request(String id) {
        OkHttpClient client = new OkHttpClient(); 
        Request request = new Request.Builder() 
                .url("https://pokeapi.co/api/v2/pokemon/" + id) 
                .build(); //
        
        try (Response response = client.newCall(request).execute()) { 
            return response.body().string(); 
        } catch (IOException e) { 
            throw new RuntimeException(e); 
        }
    }

    public static Pokemon getPokemon(String id) {
        String json = request(id); 
        return new Gson().fromJson(json, Pokemon.class); 
    }
}
