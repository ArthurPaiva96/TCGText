package com.arthurpaiva96.tcgtext.dictionary;

public class PokemonTCGDictionary {

    private static String englishPortuguesePokemonTCGTermsDictionary(String word){
        String wordToTranslate = word.trim().toLowerCase();
        switch (wordToTranslate){
            //POKÉMON TYPES
            case "grass":
                return "planta";
            case "fire":
                return "fogo";
            case "water":
                return "água";
            case "lightning":
                return "raio";
            case "psychic":
                return "psíquico";
            case "fighting":
                return "lutador";
            case "darkness":
                return "noturno";
            case "metal":
                return "metal";
            case "colorless":
                return "incolor";
            case "fairy":
                return "fada";
            case "dragon":
                return "dragão";

            //GAME ZONES
            case "deck":
                return "baralho";
            case "pile":
                return "pilha";
            case "hand":
                return "mão";
            case "prize":
                return "prêmio";
            case "prizes":
                return "prêmios";
            case "bench":
                return "banco";
            case "active":
                return "ativo";
            case "zone":
                return "zona";
            case "lost":
                return "perdida";

            //ACTIONS
            case "draw":
                return "compre";
            case "play":
                return "jogar";
            case "discard":
                return "descarte";
            case "evolves":
                return "evolua";
            case "search":
                return "procure";
            case "shuffle":
                return "embaralhe";
            case "retreat":
                return "recuar";
            case "flip":
                return "jogue";


            //GAME OBJECTS
            case "card":
                return "carta";
            case "cards":
                return "cartas";

            //CARD TYPES
            case "energy":
                return "energia";
            case "special":
                return "especial";
            case "trainer":
                return "treinador";
            case "supporter":
                return "apoiador";
            case "stadium":
                return "estádio";
            case "tool":
                return "ferramenta";
            case "stage":
                return "estágio";

             //ETC
            case "top":
                return "topo";
            case "defending":
                return "defensor";
            case "benched":
                return "do banco";
            case "opponent":
                return "oponente";
            case "opponent's":
                return "do oponente";
            case "heads,":
                return "cara,";
            case "tails,":
                return "coroa,";
            case "heads.":
                return "cara.";
            case "tails.":
                return "coroa.";
            case "turn":
                return "turno";

            default:
                return word;



        }
    }

    public static String translateGameTerms(String text){
        String[] textWords = text.split(" ");
        String textWithGameTermsTranslated = "";
        for(int i = 0; i < textWords.length; i++){
            textWithGameTermsTranslated += englishPortuguesePokemonTCGTermsDictionary(textWords[i]);
            if((i != textWords.length -1) && !textWords[i+1].matches("[.|,]")) textWithGameTermsTranslated += " ";
        }

        return textWithGameTermsTranslated;
    }

}
