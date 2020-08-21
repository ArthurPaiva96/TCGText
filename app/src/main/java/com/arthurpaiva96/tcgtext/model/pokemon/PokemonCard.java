package com.arthurpaiva96.tcgtext.model.pokemon;

public class PokemonCard {

    String name;
    String cardType;
    String serie;
    String setName;
    String setCode;

    public PokemonCard(String name, String cardType, String serie, String setName, String setCode, String number, String text) {
        this.name = name;
        this.cardType = cardType;
        this.serie = serie;
        this.setName = setName;
        this.setCode = setCode;
        this.number = number;
        this.text = text;
    }

    String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String text;

}
