package com.stefanos.app;

public class Card {
  private String rank;
  private String suit;
  private int value;
  private boolean hidden;

  // Constructor
  public Card(String suit, int value, String rank) {
    this.suit = suit;
    this.value = value;
    this.rank = rank;
    this.hidden = false; // Cards are visible by default
  }

  // Getters & Setters
  public String getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }

  public String getRank() {
    return rank;
  }

  public boolean getHidden() {
    return hidden;
  }

  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  // Print object
  @Override
  public String toString() {
    return rank + " of " + suit + (hidden ? " (Hidden)" : "");
  }
}
