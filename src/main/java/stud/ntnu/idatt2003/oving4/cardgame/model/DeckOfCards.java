package stud.ntnu.idatt2003.oving4.cardgame.model;


import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
  private static ArrayList<PlayingCard> deck;
  private final char[] suits = {'H', 'D', 'C', 'S'};
  public DeckOfCards() {
    deck = new ArrayList<>(52);
    for (int i = 1 ; i <= 13 ; i++) {
      deck.add(new PlayingCard('H', i));
    }
    for (int i = 1 ; i <= 13 ; i++) {
      deck.add(new PlayingCard('D', i));
    }
    for (int i = 1 ; i <= 13 ; i++) {
      deck.add(new PlayingCard('C', i));
    }
    for (int i = 1 ; i <= 13 ; i++) {
      deck.add(new PlayingCard('S', i));
    }
  }

  /**
   * Accesses an n amount of cards from the deck using a random number between 0 and 53(excluded).
   * @param n amount of wanted cards
   * @return ArrayList with n indexes and n PlayingCard objects.
   */
  public ArrayList<PlayingCard> dealHand (int n) { // n-amount cards from the deck
    ArrayList<PlayingCard> hand = new ArrayList<>();
    Random r = new Random();
    for (int i = 0 ; i < n ; i++) {
      int index = r.nextInt(deck.size()); // random number from 0 to 52 (index of deck list)
      PlayingCard card = deck.get(index);
      hand.add(card);
    }
    return hand;
  }

  public static String generateImagePath(char suit, int face) {
    return "/images/" + suit + face + ".png";
  }

}
