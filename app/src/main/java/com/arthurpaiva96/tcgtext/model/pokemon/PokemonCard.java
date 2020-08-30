package com.arthurpaiva96.tcgtext.model.pokemon;

import java.io.Serializable;

public class PokemonCard implements Serializable {

    final String name;
    final String cardType;
    final String serie;
    final String setName;
    final String setCode;

    public PokemonCard(String name, String cardType, String serie, String setName, String setCode, String number, String text) {
        this.name = name;
        this.cardType = cardType;
        this.serie = serie;
        this.setName = setName;
        this.setCode = setCode;
        this.number = number;
        this.text = text;
    }

    final String number;

    public String getName() {
        return name;
    }

    public String getCardType() {
        return cardType;
    }

    public String getSerie() {
        return serie;
    }

    public String getSetName() {
        return setName;
    }

    public String getSetCode() {
        return setCode;
    }

    public String getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    final String text;

}
