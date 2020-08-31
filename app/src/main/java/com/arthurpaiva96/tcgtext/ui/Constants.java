package com.arthurpaiva96.tcgtext.ui;

public interface Constants {

    String CARD_NOT_FOUND = "Nenhuma carta foi encontrada";
    String NO_INTERNET_CONNECTION = "Sem conexão com a internet";
    String LANGUAGE_MODELS_DOWNLOADED = "Agora as cartas vão ser exibidas com tradução de máquina";
    String NO_WIFI_CONNECTION = "Sem conexão Wi-fi";

    String POKEMON_CARD_LIST_TITLE = "Busca de cartas de Pokémon";
    String POKEMON_CARD_EXTRA_STRING = "pokemonCard";
    String POKEMON_CARD_TYPE_SEPARATOR = " - ";
    String POKEMON_CARD_POKEMON_SUPERTYPE = "Pokémon - ";

    String TITLE_SWITCH_MACHINE_TRANSLATION = "Tradução de máquina";
    String MESSAGE_SWITCH_MACHINE_TRANSLATION = "Deseja ligar a tradução de máquina para ";
    String MESSAGE_SWITCH_MACHINE_TRANSLATION_POKEMON_CARDS = "as cartas de Pokémon?";
    String MESSAGE_SWITCH_MACHINE_TRANSLATION_PACKAGES = "\n(Caso seja necessário, o pacote de tradução Inglês-Português(en-pt) só pode ser baixado ao estar conectado a uma rede Wi-Fi)";
    String OPTION_SWITCH_MACHINE_TRANSLATION_NO = "Não";
    String OPTION_SWITCH_MACHINE_TRANSLATION_YES = "Sim";

    String SHARED_PREFERENCES_SETTINGS_FILE_KEY = "sharedPreferencesSettings";
    String SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_STRING = "sharedPreferencesPokemonMachineTranslation";
    boolean SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_OFF = false;
    boolean SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_ON = true;


}
