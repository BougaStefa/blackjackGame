package com.stefanos.app;

import java.util.Scanner;

public class Game {
  private Deck deck;
  private Hand playerHand;
  private Hand dealerHand;
  private boolean gameOver;

  public Game() {
    this.Deck = new Deck();
    this.deck.shuffle();

    this.playerHand = new Hand();
    this.dealerHand = new Hand();
    this.gameOver = false;

    // Initialize both hands
    playerHand.addCard(deck.draw());
    playerHand.addCard(deck.draw());

    dealerHand.addCard(deck.draw());
    dealerHand.addCard(deck.draw());
  }

  // Hit
  public void playerHit() {
    playerHand.addCard(deck.draw());
    System.out.println("Player's Hand:");
    System.out.println(playerHand);
    System.out.println("Total Value: " + playerHand.calculateTotal());

    if (playerHand.isBusted()) {
      System.out.println("Player busted! House wins.");
      gameOver = true;
    }
  }

  // Stand
  public void playerStand() {
    System.out.println("Player Stands.");
    dealerTrun();
  }

  // Dealer's turn
  public void dealerTurn() {
    System.out.println("\nDealer's Turn");
    System.out.println("Dealer's Hand:");
    System.out.println(dealerHand);

    while (dealerHand.calculateTotal() < 17) {
      dealerHand.addCard(deck.draw());
      System.out.println("Dealer hits.");
      System.out.println(dealerHand);
    }

    if (dealerHand.isBusted()) {
      System.out.println("Dealer busted! Player wins.");
      gameOver = true;
    } else {
      determineWinner();
    }
  }

  // Decide winner
  public void determineWinner() {
    int playerTotal = playerHand.calculateTotal();
    int dealerTotal = dealerHand.calculateTotal();
    System.out.println("\nFinal Results:");
    System.out.println("Player's Hand: " + playerHand);
    System.out.println("Dealer's Hand: " + dealerHand);

    if (playerTotal > dealerTotal) {
      System.out.println("Player wins!");
    } else if (dealerTotal > playerTotal) {
      System.out.println("House wins.");
    } else {
      System.out.println("It's a tie.");
    }
    gameOver = true;
  }

  // Run game
  public void play() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Starting game...");
    System.out.println("Player's Hand:");
    System.out.println(playerHand);
    System.out.println("Total Value: " + playerHand.calculateTotal());

    while (!gameOver) {
      System.out.println("Choose action: 1.Hit 2.Stand");
      int choice = scanner.nextInt();

      if (choice == 1) {
        playerHit();
      } else if (choice == 2) {
        playerStand();
        break;
      } else {
        System.out.println("Select a valid option.");
      }
    }
    scanner.close();
  }
}
