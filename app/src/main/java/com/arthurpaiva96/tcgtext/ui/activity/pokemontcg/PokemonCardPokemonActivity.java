package com.arthurpaiva96.tcgtext.ui.activity.pokemontcg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCardPokemon;
import com.arthurpaiva96.tcgtext.ui.PokemonCardPokemonView;
import com.arthurpaiva96.tcgtext.ui.UtilTCGText;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_EXTRA_STRING;
import static com.arthurpaiva96.tcgtext.ui.Constants.SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_STRING;

public class PokemonCardPokemonActivity extends AppCompatActivity {

    private PokemonCardPokemon pokemon;

    private PokemonCardPokemonView pokemonCardPokemonView;

    private boolean toTranslateCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_card_pokemon);

        toTranslateCard = UtilTCGText.getSwitchSettingSharedPreferences(this, SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_STRING);
        pokemonCardPokemonView = new PokemonCardPokemonView(PokemonCardPokemonActivity.this);

        Intent intent = getIntent();
        if(intent.hasExtra(POKEMON_CARD_EXTRA_STRING)){

            this.pokemon = (PokemonCardPokemon) intent.getSerializableExtra(POKEMON_CARD_EXTRA_STRING);

            fillCardInfo();

            setTitle(pokemon.getSerie() + " " + pokemon.getSetCode() + " " + pokemon.getNumber());

        }



    }

    private void fillCardInfo() {

        TextView name = findViewById(R.id.activity_pokemon_card_pokemon_name);
        TextView hp = findViewById(R.id.activity_pokemon_card_pokemon_hp_value);
        TextView pokemonType = findViewById(R.id.activity_pokemon_card_pokemon_pokemon_type_value);
        TextView cardType = findViewById(R.id.activity_pokemon_card_pokemon_card_type_value);
        TextView weakness = findViewById(R.id.activity_pokemon_card_pokemon_weakness_value);
        TextView resistance = findViewById(R.id.activity_pokemon_card_pokemon_resistance_value);
        TextView retreatCost = findViewById(R.id.activity_pokemon_card_pokemon_retreat_value);



        name.setText(pokemon.getName());
        hp.setText(pokemon.gethP());

        UtilTCGText.translateText(pokemon.getPokemonType(), pokemonType, toTranslateCard);
        UtilTCGText.translateText(pokemon.getCardType(), cardType, toTranslateCard);
        UtilTCGText.translateText(pokemon.getWeakness(), weakness, toTranslateCard);
        UtilTCGText.translateText(pokemon.getResistance(), resistance, toTranslateCard);
        UtilTCGText.translateText(pokemon.getRetreatCost(), retreatCost, toTranslateCard);

        fillAbilitiesInfo();
        fillAttacksInfo();

    }



    private void fillAbilitiesInfo() {
        LinearLayout pokemonAbilities = findViewById(R.id.activity_pokemon_card_pokemon_text_relative_layout);
        pokemonCardPokemonView.configurePokemonAbilitiesList(pokemon, pokemonAbilities);
    }

    private void fillAttacksInfo() {
        LinearLayout pokemonAttacks = findViewById(R.id.activity_pokemon_card_pokemon_attacks_relative_layout);
        pokemonCardPokemonView.configurePokemonAttacksList(pokemon, pokemonAttacks);
    }








}