package com.arthurpaiva96.tcgtext.ui.activity.pokemontcg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.ui.UtilTCGText;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_EXTRA_STRING;

public class PokemonCardActivity extends AppCompatActivity {

    private PokemonCard card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_card);

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra(POKEMON_CARD_EXTRA_STRING)){

            card = (PokemonCard) intent.getSerializableExtra(POKEMON_CARD_EXTRA_STRING);

            fillCardInfo();

            setTitle(card.getSerie() + " " + card.getSetCode() + " " + card.getNumber());
        }


    }

    private void fillCardInfo(){

        TextView name = findViewById(R.id.activity_pokemon_card_card_name);
        TextView type = findViewById(R.id.activity_pokemon_card_card_type_value);
        TextView text = findViewById(R.id.activity_pokemon_card_card_text_value);

        name.setText(card.getName());
        UtilTCGText.translateText(card.getCardType(), type);
        UtilTCGText.translateText(card.getText(), text);

    }


}