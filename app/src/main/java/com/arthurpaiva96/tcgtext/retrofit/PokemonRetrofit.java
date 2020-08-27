package com.arthurpaiva96.tcgtext.retrofit;

import com.arthurpaiva96.tcgtext.retrofit.service.PokemonService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonRetrofit {

    private final PokemonService pokemonService;

    public PokemonRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.pokemontcg.io/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.pokemonService = retrofit.create(PokemonService.class);
    }

    public PokemonService getPokemonService(){
        return this.pokemonService;
    }
}
