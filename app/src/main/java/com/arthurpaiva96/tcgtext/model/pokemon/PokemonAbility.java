package com.arthurpaiva96.tcgtext.model.pokemon;

import java.io.Serializable;

public class PokemonAbility implements Serializable {
    final String type;
    final String name;
    final String text;

    public PokemonAbility(String type, String name, String text) {
        this.type = type;
        this.name = name;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

}
