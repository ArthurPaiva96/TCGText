package com.arthurpaiva96.tcgtext.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAbility;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAttack;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCardPokemon;

public class PokemonCardPokemonView {

    private final Context context;

    public PokemonCardPokemonView (Context context){
        this.context = context;
    }

    public void configurePokemonAbilitiesList(PokemonCardPokemon pokemon, LinearLayout pokemonAbilities) {

        ViewGroup parent = (ViewGroup) pokemonAbilities.getRootView();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
        UtilTCGText.translateText(pokemonAbility.getName(), name);
        UtilTCGText.translateText(pokemonAbility.getText(), text);

    }

    public void configurePokemonAttacksList(PokemonCardPokemon pokemon, LinearLayout pokemonAttacks) {

        ViewGroup parent = (ViewGroup) pokemonAttacks.getRootView();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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

        damage.setText(pokemonAttack.getDamage());

        UtilTCGText.translateText(pokemonAttack.getCost(), cost);
        UtilTCGText.translateText(pokemonAttack.getName(), name);
        UtilTCGText.translateText(pokemonAttack.getText(), text);

    }
}
