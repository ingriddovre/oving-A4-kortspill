package stud.ntnu.idatt2003.oving4.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class CheckHand {

  /**
   * Checks if the hand has any distinct cards more than 1. If there are more distinct counted than 1, the method
   * returns false, and it is therefore not a flush.
   * @param hand ArrayList of PlayingCard Objects to check.
   * @return Boolean value, true if it is a Flush, with all 5 suits of the hand alike, or false if not.
   */
  public static boolean isFlush(ArrayList<PlayingCard> hand) {
    List<Character> handSuits = hand.stream().map(PlayingCard::getSuit).toList();
    return handSuits.stream().distinct().count() == 1;
  }

}
