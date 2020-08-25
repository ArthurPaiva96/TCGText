package com.arthurpaiva96.tcgtext.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;

public class PokemonCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_card);

        PokemonCard card = generateCard();

        fillCardInfo(card);
    }

    private void fillCardInfo(PokemonCard card){

        TextView name = findViewById(R.id.activity_pokemon_card_card_name);
        TextView type = findViewById(R.id.activity_pokemon_card_card_type_value);
        TextView text = findViewById(R.id.activity_pokemon_card_card_text_value);

        name.setText(card.getName());
        type.setText(card.getCardType());
        text.setText(card.getText());

    }

    //TODO delete when the api call is completed
    private PokemonCard generateCard() {
        return new PokemonCard("Holon Transceiver",
                "Trainer - Pokémon Tool",
                "EX",
                "Delta Species",
                "ex11",
                "98",
                "Search your deck for a Supporter card that has Holon in its name, show it to your opponent, and put it into your hand. " +
                        "Shuffle your deck afterward. Or, search your discard pile for a Supporter card that has Holon in its name, show it to your opponent, and put it into your hand.");
    }
}