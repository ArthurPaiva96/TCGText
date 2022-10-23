# TCGText
TCGText is an Android app that uses [Retrofit](https://square.github.io/retrofit/) to get Pokémon cards information from an [API](https://pokemontcg.io/) and displays it only using text to minimize mobile data use.
It also has the option to translate the cards' texts using [machine translation](https://developers.google.com/ml-kit/language/translation) from English to Brazilian Portuguese with some [hard-coded translations](app/src/main/java/com/arthurpaiva96/tcgtext/dictionary/PokemonTCGDictionary.java) for some game terms.

# How to use

## Card search

1. Open the app.
2. Tap the menu item "BUSCAR CARTAS DE POKÉMON".
3. Tap the search bar "Digite o nome da carta aqui".
4. Write the card name (or part of it) in English.
5. Tap the icon ">" in the search bar.
6. A list of cards that have the searched term(step 4) will be displayed.
7. Tap on the card that you wish to see its information.

## Machine translation

1. Make sure you have a Wi-Fi connection.
2. Open the app.
3. Tap the menu item "CONFIGURAÇÕES".
4. If off, tap the "Tradução de máquina das cartas de Pokémon" switch to turn it on.
5. If it wasn't downloaded yet, the machine translation package is going to be downloaded. Wait for the download and its installation to finish.
6. Search for a card and choose one from the list.
7. Wait some moments and the text will be translated.

# Warnings

- This app was made with Brazilian users in mind, and because of that, its interface is in Brazilian Portuguese. The same can be said about its machine translation option.
- The last time this project was updated was in 2020. So the [API](https://pokemontcg.io/) could have been updated(new cards) causing the app to crash.
