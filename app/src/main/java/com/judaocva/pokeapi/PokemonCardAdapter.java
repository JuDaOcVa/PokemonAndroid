package com.judaocva.pokeapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;

public class PokemonCardAdapter extends RecyclerView.Adapter<PokemonCardAdapter.ViewHolder> {

    private List<PokemonCard> pokemonCards;
    private Context context;

    public PokemonCardAdapter(Context context, List<PokemonCard> pokemonCards) {
        this.context = context;
        this.pokemonCards = pokemonCards;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pokemon_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PokemonCard pokemonCard = pokemonCards.get(position);
        new DownloadImageTask(holder.imageView).execute(pokemonCard.getImageUrl());
        holder.textView.setText(pokemonCard.getCardText());
        holder.textView.setText(pokemonCard.getCardText());
    }

    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;

        DownloadImageTask(ImageView imageView) {
            imageViewReference = new WeakReference<>(imageView);
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            try {
                InputStream in = new java.net.URL(url).openStream();
                return BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (imageViewReference.get() != null && result != null) {
                ImageView imageView = imageViewReference.get();
                imageView.setImageBitmap(result);
            }
        }
    }

    @Override
    public int getItemCount() {
        return pokemonCards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgCard);
            textView = itemView.findViewById(R.id.txtCard);
        }
    }
}