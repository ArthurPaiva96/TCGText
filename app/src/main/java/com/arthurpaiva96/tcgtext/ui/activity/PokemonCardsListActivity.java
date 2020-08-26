package com.arthurpaiva96.tcgtext.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAbility;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAttack;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCardPokemon;
import com.arthurpaiva96.tcgtext.ui.adapter.PokemonCardListAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_EXTRA_STRING;
import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_LIST_TITLE;
import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_POKEMON_SUPERTYPE;

public class PokemonCardsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pokemon_cards_list);
        setTitle(POKEMON_CARD_LIST_TITLE);
        getSupportActionBar().hide();

        SearchView searchView = findViewById(R.id.activity_pokemon_cards_list_search_bar);
        searchView.setSubmitButtonEnabled(true);

        configureListView();

    }

    private void configureListView() {

        final ListView pokemonCardList = findViewById(R.id.activity_pokemon_cards_list_list_view);
        pokemonCardList.setAdapter(new PokemonCardListAdapter(getPokemonCardsList(), this));

        pokemonCardList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                startActivityToShowPokemonCard(position, pokemonCardList);
            }
        });

    }

    private void startActivityToShowPokemonCard(int position, ListView pokemonCardList) {
        PokemonCard pokemonCard = (PokemonCard) pokemonCardList.getItemAtPosition(position);
        Intent intent = new Intent(PokemonCardsListActivity.this, PokemonCardActivity.class);

        if(pokemonCard.getCardType().trim().toLowerCase().contains(POKEMON_CARD_POKEMON_SUPERTYPE.toLowerCase()))
            intent =  new Intent(PokemonCardsListActivity.this, PokemonCardPokemonActivity.class);

        intent.putExtra(POKEMON_CARD_EXTRA_STRING, pokemonCard);
        startActivity(intent);
    }


    //TODO delete when the api call is completed
    private List<PokemonCard> getPokemonCardsList(){

        ArrayList<PokemonCard> pokemonCardArrayList = new ArrayList<PokemonCard>();

        for(int i = 0; i < 30; i++) {
            PokemonCard pokemonCard;
            if(i%2 == 0 ){
                pokemonCard = new PokemonCard("Holon Transceiver",
                        "Trainer - Pokémon Tool",
                        "EX",
                        "Delta Species",
                        "ex11",
                        "98",
                        "Search your deck for a Supporter card that has Holon in its name, show it to your opponent, and put it into your hand. " +
                                "Shuffle your deck afterward. Or, search your discard pile for a Supporter card that has Holon in its name, show it to your opponent, and put it into your hand.");
            } else {
                pokemonCard = generatePokemonCardPokemonTemp();
            }
            pokemonCardArrayList.add(pokemonCard);
        }
        return pokemonCardArrayList;

    }

    private PokemonCardPokemon generatePokemonCardPokemonTemp() {
        PokemonAbility firestarter = new PokemonAbility("Poké-Power", "Firestarter", "Once during your turn (before your attack), " +
                "you may attach a Fire Energy card from your discard pile to 1 of your Benched Pokémon. This power can't be used if Blaziken is affected by a Special Condition.");

        PokemonAttack firestream = new PokemonAttack("Fogo/Incolor/Incolor", "Firestream", "50",
                "Discard a Fire Energy card attached to Blaziken. If you do, this attack does 10 damage to each of your opponent's Benched Pokémon." +
                        " (Don't apply Weakness and Resistance for Benched Pokémon.)");

        List<PokemonAbility> blazikenAbilities = new ArrayList<>();
        List<PokemonAttack> blazikenAttacks = new ArrayList<>();

        for(int i=0; i < 2; i++){
            blazikenAbilities.add(firestarter);
        }

        for(int i=0; i < 4; i++){
            blazikenAttacks.add(firestream);
        }

        return new PokemonCardPokemon("Blaziken", "Pokémon - Estágio 02", "Sun & Moon", "Guardians Rising", "sm2",
                "01", "", "Fogo/Lutador", "100", "Água x2", "Planta/Lutador -20", "2", blazikenAbilities, blazikenAttacks);
    }


}