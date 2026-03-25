package eus.ehu;

public class MainTest {


    public static Pokemon getPokemon(String id) {
        String json = PokeAPI.request(id);
        return new com.google.gson.Gson().fromJson(json, Pokemon.class);
    }

    public static void main(String[] args) {
        Pokemon pokemon = PokeAPI.getPokemon("pikachu");
        System.out.println("Name: " + pokemon.getName());
        System.out.println("ID: " + pokemon.getId());
        System.out.println("Height: " + pokemon.getHeight());
        System.out.println("Sprite URL: " + pokemon.getSprites().getFrontDefault());
    }

}
