package com.arthurpaiva96.tcgtext.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;

import java.util.List;


public class PokemonCardListAdapter extends BaseAdapter {

    private final List<PokemonCard> pokemonCardsList;
    private Context context;

    public PokemonCardListAdapter(List<PokemonCard> pokemonCardsList, Context context){
        this.pokemonCardsList = pokemonCardsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.pokemonCardsList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.pokemonCardsList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View createdView = LayoutInflater.from(context).inflate(R.layout.item_pokemon_card, viewGroup, false);

        fillPokemonCardCardView(position, createdView);

        return createdView;
    }

    private void fillPokemonCardCardView(int position, View createdView) {
        PokemonCard pokemonCard = pokemonCardsList.get(position);

        TextView cardName = createdView.findViewById(R.id.item_pokemon_card_name);
        TextView cardType = createdView.findViewById(R.id.item_pokemon_card_type_value);
        TextView cardSerie = createdView.findViewById(R.id.item_pokemon_card_serie);
        TextView cardSetName = createdView.findViewById(R.id.item_pokemon_card_set_name);
        TextView cardSetCode = createdView.findViewById(R.id.item_pokemon_card_set_code);
        TextView cardNumber = createdView.findViewById(R.id.item_pokemon_card_number_value);

        cardName.setText(pokemonCard.getName());
        cardType.setText(pokemonCard.getCardType());
        cardSerie.setText(pokemonCard.getSerie());
        cardSetName.setText(pokemonCard.getSetName());
        cardSetCode.setText(pokemonCard.getSetCode());
        cardNumber.setText(pokemonCard.getNumber());
    }
}
