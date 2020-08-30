package com.arthurpaiva96.tcgtext.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arthurpaiva96.tcgtext.R;
import com.arthurpaiva96.tcgtext.model.pokemon.PokemonCard;
import com.arthurpaiva96.tcgtext.retrofit.service.JsonObjectToPokemonCardObject;
import com.arthurpaiva96.tcgtext.ui.activity.pokemontcg.PokemonCardActivity;
import com.arthurpaiva96.tcgtext.ui.activity.pokemontcg.PokemonCardPokemonActivity;

import java.util.List;

import static com.arthurpaiva96.tcgtext.ui.Constants.POKEMON_CARD_EXTRA_STRING;


public class PokemonCardListAdapter extends RecyclerView.Adapter<PokemonCardListAdapter.PokemonCardViewHolder> {

    private final List<PokemonCard> pokemonCardsList;
    private Context context;

    public PokemonCardListAdapter(List<PokemonCard> pokemonCardsList, Context context){
        this.pokemonCardsList = pokemonCardsList;
        this.context = context;
    }



    @NonNull
    @Override
    public PokemonCardListAdapter.PokemonCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View createdView = LayoutInflater.from(context).inflate(R.layout.item_pokemon_card, viewGroup, false);

        return new PokemonCardViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonCardListAdapter.PokemonCardViewHolder holder, int position) {
        PokemonCard pokemonCard = pokemonCardsList.get(position);
        holder.configureHolderWithCardInfo(pokemonCard);

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return pokemonCardsList.size();
    }


    class PokemonCardViewHolder extends RecyclerView.ViewHolder {


        private final TextView cardName;
        private final TextView cardType;
        private final TextView cardSerie;
        private final TextView cardSetName;
        private final TextView cardSetCode;
        private final TextView cardNumber;

        public PokemonCardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardName = itemView.findViewById(R.id.item_pokemon_card_name);
            cardType = itemView.findViewById(R.id.item_pokemon_card_type_value);
            cardSerie = itemView.findViewById(R.id.item_pokemon_card_serie);
            cardSetName = itemView.findViewById(R.id.item_pokemon_card_set_name);
            cardSetCode = itemView.findViewById(R.id.item_pokemon_card_set_code);
            cardNumber = itemView.findViewById(R.id.item_pokemon_card_number_value);
        }

        public void configureHolderWithCardInfo(PokemonCard pokemonCard) {
            fillViewHolderWithCardInfo(pokemonCard);
            configureClickListener(pokemonCard);
        }

        private void fillViewHolderWithCardInfo(PokemonCard pokemonCard){
            cardName.setText(pokemonCard.getName());
            cardType.setText(pokemonCard.getCardType());
            cardSerie.setText(pokemonCard.getSerie());
            cardSetName.setText(pokemonCard.getSetName());
            cardSetCode.setText(pokemonCard.getSetCode());
            cardNumber.setText(pokemonCard.getNumber());
        }

        private void configureClickListener(PokemonCard pokemonCard){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivityToShowPokemonCard(pokemonCard);
                }
            });
        }

        private void startActivityToShowPokemonCard(PokemonCard pokemonCard) {
            Intent intent = new Intent(context, PokemonCardActivity.class);

            if(JsonObjectToPokemonCardObject.cardIsAPokemon(pokemonCard.getCardType()))
                intent =  new Intent(context, PokemonCardPokemonActivity.class);

            intent.putExtra(POKEMON_CARD_EXTRA_STRING, pokemonCard);
            context.startActivity(intent);
        }
    }

}
