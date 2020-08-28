package com.arthurpaiva96.tcgtext.retrofit.service;

import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAbility;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAttack;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCardPokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_POKEMON_SUPERTYPE;

public class JsonObjectToPokemonCardObject {



    public static PokemonCard getPokemonCardObject(PokemonCardJsonArray.PokemonCardJson card){

        String cardText = getCardText(card);
        String cardType = getCardType(card);

        PokemonCard pokemonCardObject = generateNonPokemonCard(card, cardText, cardType);

        if(cardIsAPokemon(cardType)) pokemonCardObject = generatePokemonCard(card);

        return pokemonCardObject;
    }


    public static boolean cardIsAPokemon(String cardType){
        return cardType.trim().toLowerCase().contains(POKEMON_CARD_POKEMON_SUPERTYPE.toLowerCase());
    }

    private static PokemonCard generateNonPokemonCard(PokemonCardJsonArray.PokemonCardJson card, String cardText, String cardType) {

        return new PokemonCard(card.getName(),
                cardType, card.getSeries(),
                card.getSet(), card.getSetCode(), card.getNumber(), cardText);

    }

    private static PokemonCard generatePokemonCard(PokemonCardJsonArray.PokemonCardJson card) {

        if(card.getConvertedRetreatCost() == null) card.setConvertedRetreatCost("");

        return  new PokemonCardPokemon(card.getName(), getCardType(card), card.getSeries(), card.getSet(), card.getSetCode(),
                card.getNumber(), getCardText(card), getPokemonTypes(card), card.getHp(), getPokemonWeakness(card),
                getPokemonResistances(card), card.getConvertedRetreatCost(), getPokemonAbilities(card.getAbility()), getPokemonAttacks(card.getAttacks()));

    }

    private static String getCardType(PokemonCardJsonArray.PokemonCardJson card){
        if(card.getSubtype().isEmpty()) return card.getSupertype();
        return card.getSupertype() + " - " + card.getSubtype();
    }

    private static String getCardText(PokemonCardJsonArray.PokemonCardJson card) {
        String cardText = "";
        if(card.getText() != null) {

            for (String text : card.getText()) {
                cardText += text + "\n";
            }

        }
        return cardText;
    }

    private static List<PokemonAttack> getPokemonAttacks(ArrayList<PokemonCardJsonArray.PokemonCardJson.Attack> attacksList) {

        List<PokemonAttack> pokemonAttacks = new ArrayList<>();

        if(attacksList != null) {

            for (PokemonCardJsonArray.PokemonCardJson.Attack attack : attacksList) {

                pokemonAttacks.add(new PokemonAttack(attack.getCost().toString(), attack.getName(), attack.getDamage(),
                        attack.getText()));
            }

        }

        return pokemonAttacks;
    }

    private static List<PokemonAbility> getPokemonAbilities(PokemonCardJsonArray.PokemonCardJson.Ability ability) {

        if(ability == null) return new ArrayList<>();

        return Arrays.asList(new PokemonAbility(ability.getType(), ability.getName(), ability.getText()));
    }

    private static String getPokemonResistances(PokemonCardJsonArray.PokemonCardJson card) {

        String pokemonResistance = "";

        if(card.getResistances() != null) {

            for (int i = 0; i < card.getResistances().size(); i++) {

                pokemonResistance += card.getResistances().get(i).getType() + " " +
                        card.getResistances().get(i).getValue();
                if (i != card.getTypes().size() - 1) pokemonResistance += "/";

            }

        }
        return pokemonResistance;
    }

    private static String getPokemonWeakness(PokemonCardJsonArray.PokemonCardJson card) {
        String pokemonWeakness = "";

        if(card.getWeaknesses() != null) {

            for (int i = 0; i < card.getWeaknesses().size(); i++) {

                pokemonWeakness += card.getWeaknesses().get(i).getType() + " " +
                        card.getWeaknesses().get(i).getValue();
                if (i != card.getTypes().size() - 1) pokemonWeakness += "/";

            }
        }
        return pokemonWeakness;

    }

    private static String getPokemonTypes(PokemonCardJsonArray.PokemonCardJson card) {
        String pokemonType = "";
        for(int i = 0; i < card.getTypes().size(); i++){

            pokemonType += card.getTypes().get(i);
            if(i != card.getTypes().size() -1 ) pokemonType += "/";
        }

        return pokemonType;
    }


}
