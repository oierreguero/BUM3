package eus.ehu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class PokedexController {

    @FXML
    private Button btnNext;

    @FXML
    private Button btnPrevious;

    @FXML
    private TextField heightField;

    @FXML
    private TextField idField;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField nameField;

    @FXML
    private TextArea typesArea;

    private int currentId = 1;

    @FXML
    void initialize() {
        loadPokemon(currentId);
    }

    private void loadPokemon(int id) {
        Pokemon pokemon = PokeAPI.getPokemon(String.valueOf(id));
        nameField.setText(pokemon.getName());
        idField.setText(String.valueOf(pokemon.getId()));
        heightField.setText(String.valueOf(pokemon.getHeight()));
        imageView.setImage(new javafx.scene.image.Image(pokemon.getSprites().getFrontDefault()));
        StringBuilder types = new StringBuilder();
        for (Pokemon.TypeSlot typeSlot : pokemon.getTypes()) {
            types.append(typeSlot.getType().getName()).append("\n");
        }
        typesArea.setText(types.toString());

    }

    @FXML
    void onNextClick() {
        currentId++;
        loadPokemon(currentId);

    }

    @FXML
    void onPreviousClick() {
        if (currentId > 1) {
            currentId--;
            loadPokemon(currentId);
        }

    }

}

