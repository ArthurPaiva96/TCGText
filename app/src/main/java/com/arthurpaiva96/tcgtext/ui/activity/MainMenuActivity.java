package com.arthurpaiva96.tcgtext.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.ui.activity.pokemontcg.PokemonCardsListActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        configurePokemonTCGButton();

        configureSettingsButtons();

    }

    private void configurePokemonTCGButton() {
        Button pokemonTCGButton = findViewById(R.id.activity_main_menu_pokemontcg);
        pokemonTCGButton.setOnClickListener(view -> startActivity(new Intent(MainMenuActivity.this, PokemonCardsListActivity.class)));
    }

    private void configureSettingsButtons() {
        Button settingsButton = findViewById(R.id.activity_main_menu_settings);
        settingsButton.setOnClickListener(view -> startActivity(new Intent(MainMenuActivity.this, SettingsActivity.class)));
    }
}