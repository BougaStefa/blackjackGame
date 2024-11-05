package com.stefanos.app;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Deck {
  private List<Card> cards;

  // Constructor to initialize the Deck
  public Deck() {
    this.cards = new ArrayList<>();
    initDeck();
  }

  // Method to create a standard 52 card Deck
  private void initDeck() {
    String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    for (String suit : suits) {
      for (int i = 0; i < ranks.length; i++) {
        int value = i < 10 ? i + 2 : 10;
        cards.add(new Card(suit, value, ranks[i]));
      }
    }
  }

  // Deck shuffling
  public void shuffle() {
    Collections.shuffle(cards);
  }

  // Draw the top card
  public Card draw() {
    if (!cards.isEmpty()) {
      return cards.remove(cards.size() - 1); // Draw and remove top card
    }
    return null; // Deck is empty
  }

  // Check remaining cards
  public int cardsRemaining() {
    return cards.size();
  }
}
