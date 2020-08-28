package com.arthurpaiva96.tcgtext.ui;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.retrofit.PokemonRetrofit;
import com.arthurpaiva96.tcgtext.retrofit.service.JsonObjectToPokemonCardObject;
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
    private static List<PokemonCard> pokemonCardsListStatic;

    public PokemonCardsListView(Context context) {
        this.context = context;
    }

    public void configureSearchView(SearchView searchView, ListView pokemonCardList) {

        searchView.setSubmitButtonEnabled(true);
        searchView.setQuery(null,false);

        if(pokemonCardsListStatic != null) configureListView(pokemonCardList);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                pokemonCardsListStatic = getPokemonCardsList(searchView.getQuery());
                configureListView(pokemonCardList);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }


    private void configureListView(ListView pokemonCardList) {

        this.adapter = new PokemonCardListAdapter(pokemonCardsListStatic, context);

        pokemonCardList.setAdapter(adapter);

        pokemonCardList.setOnItemClickListener((adapterView, view, position, l) ->
                startActivityToShowPokemonCard(position, pokemonCardList));


    }

    private void startActivityToShowPokemonCard(int position, ListView pokemonCardList) {
        PokemonCard pokemonCard = (PokemonCard) pokemonCardList.getItemAtPosition(position);
        Intent intent = new Intent(context, PokemonCardActivity.class);

        if(JsonObjectToPokemonCardObject.cardIsAPokemon(pokemonCard.getCardType()))
            intent =  new Intent(context, PokemonCardPokemonActivity.class);

        intent.putExtra(POKEMON_CARD_EXTRA_STRING, pokemonCard);
        context.startActivity(intent);
    }

    public List<PokemonCard> getPokemonCardsList(CharSequence cardName){

        ArrayList<PokemonCard> pokemonCardArrayList = new ArrayList<PokemonCard>();

        //TODO intenet not found
        if(!UtilTCGText.checkInternetConnection(context)) return pokemonCardArrayList;

        PokemonService service = new PokemonRetrofit().getPokemonService();
        Call<PokemonCardJsonArray> call = service.getCardByName(cardName.toString());

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

            pokemonCardArrayList.add(JsonObjectToPokemonCardObject.getPokemonCardObject(card));

        }

        UtilTCGText.makeToastIfCardNotFound(pokemonCardArrayList, context);

    }




}
