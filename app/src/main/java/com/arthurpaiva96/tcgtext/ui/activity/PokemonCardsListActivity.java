package com.arthurpaiva96.tcgtext.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAbility;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonAttack;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCardPokemon;
import com.arthurpaiva96.tcgtext.ui.PokemonCardsListView;
import com.arthurpaiva96.tcgtext.ui.adapter.PokemonCardListAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_EXTRA_STRING;
import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_LIST_TITLE;
import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_POKEMON_SUPERTYPE;

public class PokemonCardsListActivity extends AppCompatActivity {

    PokemonCardsListView pokemonCardsListView = new PokemonCardsListView(PokemonCardsListActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pokemon_cards_list);
        setTitle(POKEMON_CARD_LIST_TITLE);
        getSupportActionBar().hide();

        SearchView searchView = findViewById(R.id.activity_pokemon_cards_list_search_bar);
        searchView.setSubmitButtonEnabled(true);


        final ListView pokemonCardList = findViewById(R.id.activity_pokemon_cards_list_list_view);

        pokemonCardsListView.configureListView(pokemonCardList);

    }




}