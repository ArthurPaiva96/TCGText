package com.arthurpaiva96.tcgtext.model.pokemon;

import java.io.Serializable;
import java.util.List;

public class PokemonCardPokemon extends PokemonCard implements Serializable {

    final String pokemonType;
    final String hP;
    final String weakness;
    final String resistance;
    final String retreatCost;

    final List<PokemonAbility> pokemonAbilitiesList;
    final List<PokemonAttack> pokemonAttacksList;

    public PokemonCardPokemon(String name, String cardType, String serie, String setName, String setCode, String number, String text, String pokemonType, String hP, String weakness, String resistance, String retreatCost, List<PokemonAbility> pokemonAbilitiesList, List<PokemonAttack> pokemonAttacksList) {
        super(name, cardType, serie, setName, setCode, number, text);
        this.pokemonType = pokemonType;
        this.hP = hP;
        this.weakness = weakness;
        this.resistance = resistance;
        this.retreatCost = retreatCost;
        this.pokemonAbilitiesList = pokemonAbilitiesList;
        this.pokemonAttacksList = pokemonAttacksList;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public String gethP() {
        return hP;
    }

    public String getWeakness() {
        return weakness;
    }

    public String getResistance() {
        return resistance;
    }

    public String getRetreatCost() {
        return retreatCost;
    }

    public List<PokemonAbility> getPokemonAbilitiesList() {
        return pokemonAbilitiesList;
    }

    public List<PokemonAttack> getPokemonAttacksList() {
        return pokemonAttacksList;
    }

}
