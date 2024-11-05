package com.stefanos.app;

import java.util.List;
import java.util.ArrayList;

public class Hand {
  private List<Card> cards;

  // Constructor
  public Hand() {
    this.cards = new ArrayList<>();
  }

  // Adds card to hand
  public void addCard(Card card) {
    cards.add(card);
  }

  // Gets value of hand
  public int calculateTotal() {
    int total = 0;
    int acesCount = 0;

    for (Card card : cards) {
      total += card.getValue();
      if (card.getRank().equals("Ace")) {
        acesCount++;
      }
    }

    // If total over 21 but got Ace(s)
    while (total > 21 && acesCount > 0) {
      total -= 10;
      acesCount--;
    }
    return total;
  }

  // Show cards in hand
  public List<Card> getCards() {
    return cards;
  }

  // Checks if hand over 21
  public boolean isBusted() {
    return calculateTotal() > 21;
  }

  // Check if blackjack
  public boolean hasBlackjack() {
    return cards.size() == 2 && calculateTotal() == 21;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Card card : cards) {
      sb.append(card.toString()).append("\n");
    }
    return sb.toString();
  }
}
