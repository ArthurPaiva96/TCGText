package com.arthurpaiva96.tcgtext.ui;

import android.content.Context;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.retrofit.PokemonRetrofit;
import com.arthurpaiva96.tcgtext.retrofit.service.JsonObjectToPokemonCardObject;
import com.arthurpaiva96.tcgtext.retrofit.service.PokemonCardJsonArray;
import com.arthurpaiva96.tcgtext.retrofit.service.PokemonService;
import com.arthurpaiva96.tcgtext.ui.adapter.PokemonCardListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class PokemonCardsListView {

    private final Context context;
    private PokemonCardListAdapter adapter;
    private static List<PokemonCard> pokemonCardsListStatic;

    public PokemonCardsListView(Context context) {
        this.context = context;
    }

    public void configureSearchView(SearchView searchView, RecyclerView pokemonCardList) {

        searchView.setSubmitButtonEnabled(true);
        searchView.setQuery(null,false);

        if(pokemonCardsListStatic != null) configureRecyclerView(pokemonCardList);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                pokemonCardsListStatic = getPokemonCardsList(searchView.getQuery());
                configureRecyclerView(pokemonCardList);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }


    private void configureRecyclerView(RecyclerView pokemonCardList) {

        this.adapter = new PokemonCardListAdapter(pokemonCardsListStatic, context);

        pokemonCardList.setAdapter(adapter);

    }


    public List<PokemonCard> getPokemonCardsList(CharSequence cardName){

        ArrayList<PokemonCard> pokemonCardArrayList = new ArrayList<>();

        if(!UtilTCGText.checkInternetConnection(context)) return pokemonCardArrayList;

        PokemonService service = new PokemonRetrofit().getPokemonService();
        Call<PokemonCardJsonArray> call = service.getCardByName(cardName.toString());

        getPokemonCardsFromAPI(pokemonCardArrayList, call);

        return pokemonCardArrayList;

    }

    private void getPokemonCardsFromAPI(ArrayList<PokemonCard> pokemonCardArrayList, Call<PokemonCardJsonArray> call) {
        call.enqueue(new Callback<PokemonCardJsonArray>() {

            @Override
            @EverythingIsNonNull
            public void onResponse(Call<PokemonCardJsonArray> call, Response<PokemonCardJsonArray> response) {
                PokemonCardJsonArray pokemonCards = response.body();

                if(pokemonCards != null) {
                    addJsonCardsToCardsList(pokemonCards, pokemonCardArrayList);

                    PokemonCardsListView.this.adapter.notifyDataSetChanged();
                }
            }


            @Override
            @EverythingIsNonNull
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
