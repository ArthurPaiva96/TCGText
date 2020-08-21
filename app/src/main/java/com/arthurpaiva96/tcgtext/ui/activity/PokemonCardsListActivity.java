package com.arthurpaiva96.tcgtext.ui.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.ui.adapter.PokemonCardListAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_LIST_TITLE;

public class PokemonCardsListActivity extends AppCompatActivity {

    ActionBar actionBar;

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
        ListView pokemonCardList = findViewById(R.id.activity_pokemon_cards_list_list_view);
        pokemonCardList.setAdapter(new PokemonCardListAdapter(getPokemonCardsList(), this));
    }


    //TODO delete when the api call is completed
    private List<PokemonCard> getPokemonCardsList(){

        ArrayList<PokemonCard> pokemonCardArrayList = new ArrayList<PokemonCard>();
        PokemonCard pokemonCard = new PokemonCard("Blaziken", "Pokémon", "XY", "Roaring Skies", "XY6", "01", "");
        for(int i = 0; i < 30; i++) {
            pokemonCardArrayList.add(pokemonCard);
        }
        return pokemonCardArrayList;

    }


}