package com.arthurpaiva96.tcgtext.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CompoundButton;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.ui.UtilTCGText;

import static com.arthurpaiva96.tcgtext.ui.Constants.MESSAGE_SWITCH_MACHINE_TRANSLATION;
import static com.arthurpaiva96.tcgtext.ui.Constants.MESSAGE_SWITCH_MACHINE_TRANSLATION_PACKAGES;
import static com.arthurpaiva96.tcgtext.ui.Constants.MESSAGE_SWITCH_MACHINE_TRANSLATION_POKEMON_CARDS;
import static com.arthurpaiva96.tcgtext.ui.Constants.OPTION_SWITCH_MACHINE_TRANSLATION_NO;
import static com.arthurpaiva96.tcgtext.ui.Constants.OPTION_SWITCH_MACHINE_TRANSLATION_YES;
import static com.arthurpaiva96.tcgtext.ui.Constants.SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_OFF;
import static com.arthurpaiva96.tcgtext.ui.Constants.SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_ON;
import static com.arthurpaiva96.tcgtext.ui.Constants.SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_STRING;
import static com.arthurpaiva96.tcgtext.ui.Constants.TITLE_SWITCH_MACHINE_TRANSLATION;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        configurePokemonTCGMachineTranslation();
    }

    private void configurePokemonTCGMachineTranslation() {
        SwitchCompat pokemonTCGMachineTranslationSwitch = findViewById(R.id.activity_settings_pokemontcg_translation_switch);

        pokemonTCGMachineTranslationSwitch.setChecked(
                UtilTCGText.getSwitchSettingSharedPreferences(this, SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_STRING));

        pokemonTCGMachineTranslationSwitch.setOnClickListener(view -> {
            if(pokemonTCGMachineTranslationSwitch.isChecked()){
                pokemonTCGMachineTranslationSwitch.setChecked(false);
                machineTranslationAlertDialog(MESSAGE_SWITCH_MACHINE_TRANSLATION_POKEMON_CARDS, pokemonTCGMachineTranslationSwitch);
            }else{
                UtilTCGText.setSwitchSettingSharedPreferences(SettingsActivity.this,
                        SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_STRING,
                        SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_OFF);
            }
        });
    }

    private void machineTranslationAlertDialog(String machineTranslationCardGameMessage, CompoundButton switchButton) {

        new AlertDialog
                .Builder(SettingsActivity.this)
                .setTitle(TITLE_SWITCH_MACHINE_TRANSLATION)
                .setMessage(MESSAGE_SWITCH_MACHINE_TRANSLATION + machineTranslationCardGameMessage + MESSAGE_SWITCH_MACHINE_TRANSLATION_PACKAGES)
                .setNegativeButton(OPTION_SWITCH_MACHINE_TRANSLATION_NO, (dialogInterface, i) -> UtilTCGText.setSwitchSettingSharedPreferences(SettingsActivity.this,
                        SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_STRING,
                        SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_OFF))
                //DELETE THE REMINDER
                .setPositiveButton(OPTION_SWITCH_MACHINE_TRANSLATION_YES, (dialog, which) -> {

                    UtilTCGText.downloadEnglishToPortugueseText(SettingsActivity.this,
                            SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_STRING,
                            SHARED_PREFERENCES_POKEMON_MACHINE_TRANSLATION_ON);


                    switchButton.setChecked(true);
                })
                .show();
    }
}