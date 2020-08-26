package com.arthurpaiva96.tcgtext.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCardPokemon;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_EXTRA_STRING;

public class PokemonCardActivity extends AppCompatActivity {

    private PokemonCard card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_card);

        Intent intent = getIntent();
        if(intent.hasExtra(POKEMON_CARD_EXTRA_STRING)){

            card = (PokemonCard) intent.getSerializableExtra(POKEMON_CARD_EXTRA_STRING);

            fillCardInfo();

            //TODO set title as the card code
        }


    }

    private void fillCardInfo(){

        TextView name = findViewById(R.id.activity_pokemon_card_card_name);
        TextView type = findViewById(R.id.activity_pokemon_card_card_type_value);
        TextView text = findViewById(R.id.activity_pokemon_card_card_text_value);

        name.setText(card.getName());
        type.setText(card.getCardType());
        text.setText(card.getText());

    }


}