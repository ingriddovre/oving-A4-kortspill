package stud.ntnu.idatt2003.oving4.cardgame.model;

import java.util.ArrayList;
import stud.ntnu.idatt2003.oving4.cardgame.ui.CardGameApplication;

public class ButtonManager {
  static DeckOfCards deck = new DeckOfCards();

  public static ArrayList<PlayingCard> newDeckButton() {
    return deck.dealHand(5);
  }
  public static void checkHandButton() {
    CardGameApplication.flush = CheckHand.isFlush(deck.dealHand(5));
    CardGameApplication.royalFlush = CheckHand.isRoyalFlush(deck.dealHand(5));
    CardGameApplication.spadeWoman = CheckHand.spadesWoman(deck.dealHand(5));
    CardGameApplication.fourOfAKind = CheckHand.isFourOfAKind(deck.dealHand(5));
    CardGameApplication.sumOfFaces = CheckHand.sumOfFaces(deck.dealHand(5));
    CardGameApplication.cardsOfHearts = CheckHand.cardsOfHearts(deck.dealHand(5));
  }
}
