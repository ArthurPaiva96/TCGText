package com.arthurpaiva96.tcgtext.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import android.widget.Toast;

import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.retrofit.PokemonRetrofit;
import com.arthurpaiva96.tcgtext.retrofit.service.JsonObjectToPokemonCard;
import com.arthurpaiva96.tcgtext.retrofit.service.PokemonCardJsonArray;
import com.arthurpaiva96.tcgtext.retrofit.service.PokemonService;
import com.arthurpaiva96.tcgtext.ui.activity.PokemonCardActivity;
import com.arthurpaiva96.tcgtext.ui.activity.PokemonCardPokemonActivity;
import com.arthurpaiva96.tcgtext.ui.adapter.PokemonCardListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_EXTRA_STRING;

public class PokemonCardsListView {

    private final Context context;
    private PokemonCardListAdapter adapter;

    public PokemonCardsListView(Context context) {
        this.context = context;
    }


    public void configureListView(ListView pokemonCardList) {

        this.adapter = new PokemonCardListAdapter(getPokemonCardsList(), context);

        pokemonCardList.setAdapter(adapter);

        pokemonCardList.setOnItemClickListener((adapterView, view, position, l) ->
                startActivityToShowPokemonCard(position, pokemonCardList));


    }

    private void startActivityToShowPokemonCard(int position, ListView pokemonCardList) {
        PokemonCard pokemonCard = (PokemonCard) pokemonCardList.getItemAtPosition(position);
        Intent intent = new Intent(context, PokemonCardActivity.class);

        if(JsonObjectToPokemonCard.cardIsAPokemon(pokemonCard.getCardType()))
            intent =  new Intent(context, PokemonCardPokemonActivity.class);

        intent.putExtra(POKEMON_CARD_EXTRA_STRING, pokemonCard);
        context.startActivity(intent);
    }

    public List<PokemonCard> getPokemonCardsList(){

        ArrayList<PokemonCard> pokemonCardArrayList = new ArrayList<PokemonCard>();

        PokemonService service = new PokemonRetrofit().getPokemonService();
        Call<PokemonCardJsonArray> call = service.getCardByName("Audino");

        getPokemonCardsFromAPI(pokemonCardArrayList, call);

        return pokemonCardArrayList;

    }

    private void getPokemonCardsFromAPI(ArrayList<PokemonCard> pokemonCardArrayList, Call<PokemonCardJsonArray> call) {
        call.enqueue(new Callback<PokemonCardJsonArray>() {

            @Override
            public void onResponse(Call<PokemonCardJsonArray> call, Response<PokemonCardJsonArray> response) {
                PokemonCardJsonArray pokemonCards = response.body();

                addJsonCardsToCardsList(pokemonCards, pokemonCardArrayList);

                PokemonCardsListView.this.adapter.notifyDataSetChanged();
            }


            @Override
            public void onFailure(Call<PokemonCardJsonArray> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addJsonCardsToCardsList(PokemonCardJsonArray pokemonCards, ArrayList<PokemonCard> pokemonCardArrayList) {

        for(PokemonCardJsonArray.PokemonCardJson card : pokemonCards.getCards()){

            pokemonCardArrayList.add(JsonObjectToPokemonCard.getPokemonCardObject(card));

        }
    }





}
