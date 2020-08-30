package com.arthurpaiva96.tcgtext.retrofit.service;

import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAbility;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAttack;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCardPokemon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_POKEMON_SUPERTYPE;
import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_TYPE_SEPARATOR;

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
        return card.getSupertype() + POKEMON_CARD_TYPE_SEPARATOR + card.getSubtype();
    }

    private static String getCardText(PokemonCardJsonArray.PokemonCardJson card) {
        StringBuilder cardText = new StringBuilder();
        if(card.getText() != null) {

            for (String text : card.getText()) {
                cardText.append(text).append("\n");
            }

        }
        return cardText.toString();
    }

    private static List<PokemonAttack> getPokemonAttacks(ArrayList<PokemonCardJsonArray.PokemonCardJson.Attack> attacksList) {

        List<PokemonAttack> pokemonAttacks = new ArrayList<>();

        if(attacksList != null) {

            for (PokemonCardJsonArray.PokemonCardJson.Attack attack : attacksList) {

                pokemonAttacks.add(new PokemonAttack(
                        attack.getCost().toString().replaceAll("[\\[\\],]", ""),
                        attack.getName(), attack.getDamage(), attack.getText()));
            }

        }

        return pokemonAttacks;
    }

    private static List<PokemonAbility> getPokemonAbilities(PokemonCardJsonArray.PokemonCardJson.Ability ability) {

        if(ability == null) return new ArrayList<>();

        return Collections.singletonList(new PokemonAbility(ability.getType(), ability.getName(), ability.getText()));
    }

    private static String getPokemonResistances(PokemonCardJsonArray.PokemonCardJson card) {

        StringBuilder pokemonResistance = new StringBuilder();

        if(card.getResistances() != null) {

            for (int i = 0; i < card.getResistances().size(); i++) {

                pokemonResistance.append(card.getResistances().get(i).getType()).append(" ").append(card.getResistances().get(i).getValue());
                if (i != card.getResistances().size() - 1) pokemonResistance.append(" ");

            }

        }
        return pokemonResistance.toString();
    }

    private static String getPokemonWeakness(PokemonCardJsonArray.PokemonCardJson card) {
        StringBuilder pokemonWeakness = new StringBuilder();

        if(card.getWeaknesses() != null) {

            for (int i = 0; i < card.getWeaknesses().size(); i++) {

                pokemonWeakness.append(card.getWeaknesses().get(i).getType()).append(" ").append(card.getWeaknesses().get(i).getValue());
                if (i != card.getWeaknesses().size() - 1) pokemonWeakness.append(" ");

            }
        }
        return pokemonWeakness.toString();

    }

    private static String getPokemonTypes(PokemonCardJsonArray.PokemonCardJson card) {
        StringBuilder pokemonType = new StringBuilder();
        for(int i = 0; i < card.getTypes().size(); i++){

            pokemonType.append(card.getTypes().get(i));
            if(i != card.getTypes().size() -1 ) pokemonType.append(" ");
        }

        return pokemonType.toString();
    }


}
