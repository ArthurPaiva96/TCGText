package com.arthurpaiva96.tcgtext.retrofit.service;

import java.util.ArrayList;

public class PokemonCardJsonArray {

    private ArrayList<PokemonCardJson> cards;

    public PokemonCardJsonArray(ArrayList<PokemonCardJson> cards) {
        this.cards = cards;
    }

    public ArrayList<PokemonCardJson> getCards() {
        return cards;
    }

    public void setCards(ArrayList<PokemonCardJson> cards) {
        this.cards = cards;
    }

    public class PokemonCardJson {

        private String name;
        private String supertype;
        private String subtype;
        private String number;
        private String series;
        private String set;
        private String setCode;
        private ArrayList<String> text;

        private ArrayList<String> types;
        private String hp;
        private String convertedRetreatCost;
        private ArrayList<Attack> attacks;
        private ArrayList<Weakness> weaknesses;
        private ArrayList<Resistance> resistances;
        private Ability ability;

        public PokemonCardJson(String name, String supertype, String subtype, String number, String series, String set, String setCode, ArrayList<String> text, ArrayList<String> types, String hp, String convertedRetreatCost, ArrayList<Attack> attacks, ArrayList<Weakness> weaknesses, ArrayList<Resistance> resistances, Ability ability) {
            this.name = name;
            this.supertype = supertype;
            this.subtype = subtype;
            this.number = number;
            this.series = series;
            this.set = set;
            this.setCode = setCode;
            this.text = text;
            this.types = types;
            this.hp = hp;
            this.convertedRetreatCost = convertedRetreatCost;
            this.attacks = attacks;
            this.weaknesses = weaknesses;
            this.resistances = resistances;
            this.ability = ability;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSupertype() {
            return supertype;
        }

        public void setSupertype(String supertype) {
            this.supertype = supertype;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getSeries() {
            return series;
        }

        public void setSeries(String series) {
            this.series = series;
        }

        public String getSet() {
            return set;
        }

        public void setSet(String set) {
            this.set = set;
        }

        public String getSetCode() {
            return setCode;
        }

        public void setSetCode(String setCode) {
            this.setCode = setCode;
        }

        public ArrayList<String> getText() {
            return text;
        }

        public void setText(ArrayList<String> text) {
            this.text = text;
        }

        public ArrayList<String> getTypes() {
            return types;
        }

        public void setTypes(ArrayList<String> types) {
            this.types = types;
        }

        public String getHp() {
            return hp;
        }

        public void setHp(String hp) {
            this.hp = hp;
        }

        public String getConvertedRetreatCost() {
            return convertedRetreatCost;
        }

        public void setConvertedRetreatCost(String convertedRetreatCost) {
            this.convertedRetreatCost = convertedRetreatCost;
        }

        public ArrayList<Attack> getAttacks() {
            return attacks;
        }

        public void setAttacks(ArrayList<Attack> attacks) {
            this.attacks = attacks;
        }

        public ArrayList<Weakness> getWeaknesses() {
            return weaknesses;
        }

        public void setWeaknesses(ArrayList<Weakness> weaknesses) {
            this.weaknesses = weaknesses;
        }

        public ArrayList<Resistance> getResistances() {
            return resistances;
        }

        public void setResistances(ArrayList<Resistance> resistances) {
            this.resistances = resistances;
        }

        public Ability getAbility() {
            return ability;
        }

        public void setAbility(Ability ability) {
            this.ability = ability;
        }

        public class Attack {
            private ArrayList<String> cost;
            private String name;
            private String text;
            private String damage;

            public Attack(ArrayList<String> cost, String name, String text, String damage) {
                this.cost = cost;
                this.name = name;
                this.text = text;
                this.damage = damage;
            }

            public ArrayList<String> getCost() {
                return cost;
            }

            public void setCost(ArrayList<String> cost) {
                this.cost = cost;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getDamage() {
                return damage;
            }

            public void setDamage(String damage) {
                this.damage = damage;
            }
        }

        public class Weakness {
            private String type;
            private String value;

            public Weakness(String type, String value) {
                this.type = type;
                this.value = value;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public class Ability {
            private String name;
            private String text;
            private String type;

            public Ability(String name, String text, String type) {
                this.name = name;
                this.text = text;
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public class Resistance {
            private String type;
            private String value;

            public Resistance(String type, String value) {
                this.type = type;
                this.value = value;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}