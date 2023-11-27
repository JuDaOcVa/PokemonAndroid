package com.judaocva.pokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCards;
    private PokemonCardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCards = findViewById(R.id.rvCards);
        rvCards.setLayoutManager(new GridLayoutManager(this, 3));

        List<PokemonCard> pokemonCards = generatePokemonCards();
        cardAdapter = new PokemonCardAdapter(this, pokemonCards);
        rvCards.setAdapter(cardAdapter);
    }


    private List<PokemonCard> generatePokemonCards() {
        List<PokemonCard> cards = new ArrayList<>();
        cards.add(new PokemonCard("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png", "Clefairy"));
        cards.add(new PokemonCard("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png", "Pikachu"));
        cards.add(new PokemonCard("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png", "Sniper"));
        cards.add(new PokemonCard("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png", "Clefairy"));
        cards.add(new PokemonCard("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png", "Pikachu 2"));
        cards.add(new PokemonCard("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png", "Fletchinder"));
        return cards;
    }
}
