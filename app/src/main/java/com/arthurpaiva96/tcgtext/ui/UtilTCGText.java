package com.arthurpaiva96.tcgtext.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.arthurpaiva96.tcgtext.dictionary.PokemonTCGDictionary;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.ui.activity.PokemonCardsListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

import java.util.ArrayList;

import static com.arthurpaiva96.tcgtext.ui.Constants.CARD_NOT_FOUND;
import static com.arthurpaiva96.tcgtext.ui.Constants.LANGUAGE_MODELS_DOWNLOADED;
import static com.arthurpaiva96.tcgtext.ui.Constants.NO_INTERNET_CONNECTION;
import static com.arthurpaiva96.tcgtext.ui.Constants.NO_WIFI_CONNECTION;

public class UtilTCGText {

    private static TranslatorOptions options = new TranslatorOptions.Builder()
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

    private static boolean connectedToWifi(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    public static void downloadEnglishToPortugueseText(Context context) {

        final Toast toastNoWifiConnection = Toast.makeText(context, NO_WIFI_CONNECTION, Toast.LENGTH_LONG);

        if(!connectedToWifi(context)) toastNoWifiConnection.show();

        Translator englishToPortuguese = Translation.getClient(options);

        englishToPortuguese.downloadModelIfNeeded(getWifiCondition())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void v) {

                        Toast.makeText(context,LANGUAGE_MODELS_DOWNLOADED,Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        toastNoWifiConnection.show();
                    }
                });

    }

    public static void translateText(String textToTranslate, TextView textView) {

        textView.setText(textToTranslate);

        final Translator englishToPortugueseTranslator = Translation.getClient(options);

        englishToPortugueseTranslator.downloadModelIfNeeded(getWifiCondition())
                .addOnSuccessListener(
                        new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void v) {

                                translateTextView(englishToPortugueseTranslator, textToTranslate, textView);
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });


    }

    private static void translateTextView(Translator englishToPortugueseTranslator, String textToTranslate, TextView textView) {

        String textWithGameTermsTranslated = PokemonTCGDictionary.translateGameTerms(textToTranslate);

        englishToPortugueseTranslator.translate(textWithGameTermsTranslated)
                .addOnSuccessListener(
                        new OnSuccessListener<String>() {
                            @Override
                            public void onSuccess(@NonNull String translatedText) {
                                textView.setText(translatedText);
                            }
                        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Error.
                                // ...
                            }
                        });
    }
}
