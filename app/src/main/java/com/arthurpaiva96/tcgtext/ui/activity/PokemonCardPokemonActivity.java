package com.arthurpaiva96.tcgtext.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAbility;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAttack;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCardPokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonCardPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_card_pokemon);

        PokemonCardPokemon blaziken = generatePokemonCardTemp();

        configurePokemonAbilitiesList(blaziken);

        configurePokemonAttacksList(blaziken);

        fillCardInfo(blaziken);

        //TODO set title as the card code

    }

    private void configurePokemonAbilitiesList(PokemonCardPokemon pokemon) {

        LinearLayout pokemonAbilities = findViewById(R.id.activity_pokemon_card_pokemon_text_relative_layout);

        ViewGroup parent = (ViewGroup) pokemonAbilities.getRootView();

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for(int abilityPosition = 0; abilityPosition < pokemon.getPokemonAbilitiesList().size(); abilityPosition++){

            View createdView = inflater.inflate(R.layout.item_pokemon_card_pokemon_ability, parent, false);
            fillPokemonAbilities(pokemon.getPokemonAbilitiesList().get(abilityPosition), createdView);
            pokemonAbilities.addView(createdView, abilityPosition);

        }


    }


    private void fillPokemonAbilities(PokemonAbility pokemonAbility, View createdView) {

        TextView type = createdView.findViewById(R.id.item_pokemon_card_pokemon_ability_type);
        TextView name = createdView.findViewById(R.id.item_pokemon_card_pokemon_ability_name);
        TextView text = createdView.findViewById(R.id.item_pokemon_card_pokemon_ability_text);

        type.setText(pokemonAbility.getType());
        name.setText(pokemonAbility.getName());
        text.setText(pokemonAbility.getText());

    }

    private void configurePokemonAttacksList(PokemonCardPokemon pokemon) {

        LinearLayout pokemonAttacks = findViewById(R.id.activity_pokemon_card_pokemon_attacks_relative_layout);

        ViewGroup parent = (ViewGroup) pokemonAttacks.getRootView();

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for(int attackPosition = 0; attackPosition < pokemon.getPokemonAttacksList().size(); attackPosition++){

            View createdView = inflater.inflate(R.layout.item_pokemon_card_pokemon_attack, parent, false);
            fillPokemonAttacks(pokemon.getPokemonAttacksList().get(attackPosition), createdView);
            pokemonAttacks.addView(createdView, attackPosition);

        }


    }


    private void fillPokemonAttacks(PokemonAttack pokemonAttack, View createdView) {

        TextView cost = createdView.findViewById(R.id.item_pokemon_card_pokemon_attack_cost);
        TextView name = createdView.findViewById(R.id.item_pokemon_card_pokemon_attack_name);
        TextView damage = createdView.findViewById(R.id.item_pokemon_card_pokemon_attack_damage);
        TextView text = createdView.findViewById(R.id.item_pokemon_card_pokemon_attack_text);

        cost.setText(pokemonAttack.getCost());
        name.setText(pokemonAttack.getName());
        damage.setText(pokemonAttack.getDamage());
        text.setText(pokemonAttack.getText());

    }


    //TODO delete when the api call is completed
    private PokemonCardPokemon generatePokemonCardTemp() {
        PokemonAbility firestarter = new PokemonAbility("Poké-Power", "Firestarter", "Once during your turn (before your attack), " +
                "you may attach a Fire Energy card from your discard pile to 1 of your Benched Pokémon. This power can't be used if Blaziken is affected by a Special Condition.");

        PokemonAttack firestream = new PokemonAttack("Fogo/Incolor/Incolor", "Firestream", "50",
                "Discard a Fire Energy card attached to Blaziken. If you do, this attack does 10 damage to each of your opponent's Benched Pokémon." +
                        " (Don't apply Weakness and Resistance for Benched Pokémon.)");

        List<PokemonAbility> blazikenAbilities = new ArrayList<>();
        List<PokemonAttack> blazikenAttacks = new ArrayList<>();

        for(int i=0; i < 2; i++){
            blazikenAbilities.add(firestarter);
        }

        for(int i=0; i < 4; i++){
            blazikenAttacks.add(firestream);
        }

        return new PokemonCardPokemon("Blaziken", "Estágio 02", "Sun & Moon", "Guardians Rising", "sm2",
                "01", "", "Fogo", "100", "Água x2", "Planta -20", "2", blazikenAbilities, blazikenAttacks);
    }

    private void fillCardInfo(PokemonCardPokemon pokemon) {

        TextView name = findViewById(R.id.activity_pokemon_card_pokemon_name);
        TextView hp = findViewById(R.id.activity_pokemon_card_pokemon_hp_value);
        TextView pokemonType = findViewById(R.id.activity_pokemon_card_pokemon_pokemon_type_value);
        TextView cardType = findViewById(R.id.activity_pokemon_card_pokemon_card_type_value);
        TextView weakness = findViewById(R.id.activity_pokemon_card_pokemon_weakness_value);
        TextView resistance = findViewById(R.id.activity_pokemon_card_pokemon_resistance_value);
        TextView retreatCost = findViewById(R.id.activity_pokemon_card_pokemon_retreat_value);

        name.setText(pokemon.getName());
        hp.setText(pokemon.gethP());
        pokemonType.setText(pokemon.getPokemonType());
        cardType.setText(pokemon.getCardType());
        weakness.setText(pokemon.getWeakness());
        resistance.setText(pokemon.getWeakness());
        retreatCost.setText(pokemon.getRetreatCost());


    }
}