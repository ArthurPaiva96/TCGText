package com.arthurpaiva96.tcgtext.model.pokemon;

import java.util.List;

public class PokemonCardPokemon extends PokemonCard {

    String pokemonType;
    String hP;
    String weakness;
    String resistance;
    String retreatCost;

    List<PokemonAbility> pokemonAbilitiesList;
    List<PokemonAttack> pokemonAttacksList;

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

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String gethP() {
        return hP;
    }

    public void sethP(String hP) {
        this.hP = hP;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    public String getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(String retreatCost) {
        this.retreatCost = retreatCost;
    }

    public List<PokemonAbility> getPokemonAbilitiesList() {
        return pokemonAbilitiesList;
    }

    public void setPokemonAbilitiesList(List<PokemonAbility> pokemonAbilitiesList) {
        this.pokemonAbilitiesList = pokemonAbilitiesList;
    }

    public List<PokemonAttack> getPokemonAttacksList() {
        return pokemonAttacksList;
    }

    public void setPokemonAttacksList(List<PokemonAttack> pokemonAttacksList) {
        this.pokemonAttacksList = pokemonAttacksList;
    }

}
