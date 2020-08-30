package com.arthurpaiva96.tcgtext.model.pokemon;

import java.io.Serializable;

public class PokemonAttack implements Serializable {
    final String cost;
    final String name;
    final String damage;
    final String text;

    public PokemonAttack(String cost, String name, String damage, String text) {
        this.cost = cost;
        this.name = name;
        this.damage = damage;
        this.text = text;
    }

    public String getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDamage() {
        return damage;
    }

    public String getText() {
        return text;
    }

}
