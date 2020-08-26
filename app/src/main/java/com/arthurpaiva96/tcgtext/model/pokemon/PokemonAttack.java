package com.arthurpaiva96.tcgtext.model.pokemon;

import java.io.Serializable;

public class PokemonAttack implements Serializable {
    String cost;
    String name;
    String damage;
    String text;

    public PokemonAttack(String cost, String name, String damage, String text) {
        this.cost = cost;
        this.name = name;
        this.damage = damage;
        this.text = text;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
