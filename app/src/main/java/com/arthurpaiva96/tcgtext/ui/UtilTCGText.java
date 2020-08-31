package com.arthurpaiva96.tcgtext.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.arthurpaiva96.tcgtext.dictionary.PokemonTCGDictionary;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.arthurpaiva96.tcgtext.ui.Constants.CARD_NOT_FOUND;
import static com.arthurpaiva96.tcgtext.ui.Constants.LANGUAGE_MODELS_DOWNLOADED;
import static com.arthurpaiva96.tcgtext.ui.Constants.NO_INTERNET_CONNECTION;
import static com.arthurpaiva96.tcgtext.ui.Constants.NO_WIFI_CONNECTION;
import static com.arthurpaiva96.tcgtext.ui.Constants.SHARED_PREFERENCES_SETTINGS_FILE_KEY;

public class UtilTCGText {

    private static final TranslatorOptions options = new TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.PORTUGUESE)
            .build();

    public static boolean checkInternetConnection(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        boolean internetConnection = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        if(!internetConnection) Toast.makeText(context, NO_INTERNET_CONNECTION, Toast.LENGTH_LONG).show();

        return internetConnection;
    }

    public static void makeToastIfCardNotFound(ArrayList<?> cardsArrayList, Context context) {
        if(cardsArrayList == null || cardsArrayList.isEmpty()) Toast.makeText(context, CARD_NOT_FOUND, Toast.LENGTH_LONG).show();
    }

    private static DownloadConditions getWifiCondition() {
        return new DownloadConditions.Builder()
                .requireWifi()
                .build();
    }

    public static void setSwitchSettingSharedPreferences(Context context, String setting, boolean value){

        SharedPreferences settingsSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_SETTINGS_FILE_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = settingsSharedPreferences.edit();
        editor.putBoolean(setting, value);
        editor.commit();

    }

    public static boolean getSwitchSettingSharedPreferences(Context context, String setting){
        SharedPreferences settingsSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_SETTINGS_FILE_KEY, MODE_PRIVATE);
        return settingsSharedPreferences.getBoolean(setting, false);
    }

    public static void downloadEnglishToPortugueseText(Context context, String setting, boolean value) {

        Translator englishToPortuguese = Translation.getClient(options);

        englishToPortuguese.downloadModelIfNeeded(getWifiCondition())
                .addOnSuccessListener(v -> {

                    setSwitchSettingSharedPreferences(context, setting, value);

                    Toast.makeText(context,LANGUAGE_MODELS_DOWNLOADED,Toast.LENGTH_LONG).show();

                })
                .addOnFailureListener(e -> Toast.makeText(context, NO_WIFI_CONNECTION, Toast.LENGTH_LONG).show());

    }

    public static void translateText(String textToTranslate, TextView textView, boolean toTranslate) {

        textView.setText(textToTranslate);

        final Translator englishToPortugueseTranslator = Translation.getClient(options);

        englishToPortugueseTranslator.downloadModelIfNeeded(getWifiCondition())
                .addOnSuccessListener(
                        v -> {

                            if(toTranslate) translateTextView(englishToPortugueseTranslator, textToTranslate, textView);

                        }
                ).addOnFailureListener(
                        e -> {

                        });


    }

    private static void translateTextView(Translator englishToPortugueseTranslator, String textToTranslate, TextView textView) {

        String textWithGameTermsTranslated = PokemonTCGDictionary.translateGameTerms(textToTranslate);

        englishToPortugueseTranslator.translate(textWithGameTermsTranslated)
                .addOnSuccessListener(
                        textView::setText)
                .addOnFailureListener(
                        e -> {
                            // Error.
                            // ...
                        });
    }
}
