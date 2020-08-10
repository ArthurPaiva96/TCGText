package com.arthurpaiva96.tcgtext.ui.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.SearchView;

import com.arthurpaiva96.tcgtext.R;

public class PokemonCardsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_cards_list);
        SearchView searchView = findViewById(R.id.activity_pokemon_cards_list_search_bar);
        searchView.setSubmitButtonEnabled(true);

    }
}