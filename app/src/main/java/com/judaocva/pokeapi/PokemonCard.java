package com.judaocva.pokeapi;

public class PokemonCard {
    private String imageUrl;
    private String cardText;

    public PokemonCard(String imageUrl, String cardText) {
        this.imageUrl = imageUrl;
        this.cardText = cardText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCardText() {
        return cardText;
    }
}
