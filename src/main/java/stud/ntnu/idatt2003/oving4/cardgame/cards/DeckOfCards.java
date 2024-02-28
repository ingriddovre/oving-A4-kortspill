package stud.ntnu.idatt2003.oving4.cardgame.cards;


import java.util.ArrayList;

public class DeckOfCards {
  private ArrayList<PlayingCard> deck;
  public DeckOfCards() {
    deck = new ArrayList<>(52);
    for (int i = 1 ; i <= 13 ; i++) {
      deck.add(new PlayingCard('H', i));
    }
    for (int i = 1 ; i <= 13 ; i++) {
      deck.add(new PlayingCard('D', i + 13));
    }
    for (int i = 1 ; i <= 13 ; i++) {
      deck.add(new PlayingCard('C', i + 26));
    }
    for (int i = 1 ; i <= 13 ; i++) {
      deck.add(new PlayingCard('S', i + 39));
    }
  }


}
