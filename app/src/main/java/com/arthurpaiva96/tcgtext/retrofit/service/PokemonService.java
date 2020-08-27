package com.arthurpaiva96.tcgtext.retrofit.service;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonService {

    @GET("cards")
    Call<PokemonCardJsonArray> getCardByName(@Query("name") String cardName);
}
