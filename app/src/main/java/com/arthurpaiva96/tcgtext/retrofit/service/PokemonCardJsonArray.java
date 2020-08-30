package com.arthurpaiva96.tcgtext.retrofit.service;

import java.util.ArrayList;

public class PokemonCardJsonArray {

    private ArrayList<PokemonCardJson> cards;

    public ArrayList<PokemonCardJson> getCards() {
        return cards;
    }

    public static class PokemonCardJson {

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

        public String getName() {
            return name;
        }

        public String getSupertype() {
            return supertype;
        }


        public String getSubtype() {
            return subtype;
        }


        public String getNumber() {
            return number;
        }


        public String getSeries() {
            return series;
        }


        public String getSet() {
            return set;
        }


        public String getSetCode() {
            return setCode;
        }


        public ArrayList<String> getText() {
            return text;
        }

        public ArrayList<String> getTypes() {
            return types;
        }


        public String getHp() {
            return hp;
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

        public ArrayList<Weakness> getWeaknesses() {
            return weaknesses;
        }


        public ArrayList<Resistance> getResistances() {
            return resistances;
        }



        public Ability getAbility() {
            return ability;
        }



        public static class Attack {
            private ArrayList<String> cost;
            private String name;
            private String text;
            private String damage;

            public ArrayList<String> getCost() {
                return cost;
            }


            public String getName() {
                return name;
            }

            public String getText() {
                return text;
            }

            public String getDamage() {
                return damage;
            }

        }

        public static class Weakness {
            private String type;
            private String value;

            public String getType() {
                return type;
            }


            public String getValue() {
                return value;
            }

        }

        public static class Ability {
            private String name;
            private String text;
            private String type;

            public String getName() {
                return name;
            }

            public String getText() {
                return text;
            }

            public String getType() {
                return type;
            }

        }

        public static class Resistance {
            private String type;
            private String value;

            public String getType() {
                return type;
            }


            public String getValue() {
                return value;
            }

        }
    }
}