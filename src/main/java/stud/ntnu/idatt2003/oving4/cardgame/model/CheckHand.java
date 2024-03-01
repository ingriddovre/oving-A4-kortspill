package stud.ntnu.idatt2003.oving4.cardgame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    /**
     * After testing a hand with the isFlush() method, this method can be used to check if the hand is actually a
     * royal flush. Which means it will not only contain all 5 cards of the same suit, but also needs to have
     * faces 1, 10, 11, 12, 13.
     * @param hand ArrayList of PlayingCards Objects. Has to be a size of 5 indexes.
     * @return Boolean value true if the hand has all necessary face values.
     */
  public static boolean isRoyalFlush(ArrayList<PlayingCard> hand) {
    List<Integer> handFaces = hand.stream().map(PlayingCard::getFace).toList();
      return handFaces.contains(1) && handFaces.contains(10) && handFaces.contains(11) && handFaces.contains(12) &&
          handFaces.contains(13);
  }

  /**
   * Checks if a hand contains 4 equal faces. Method creates a list of the distinct face values if it is only 2.
   * It then counts if the first or last distinct value appears 4 times in the hand. If one of them does, it returns
   * true. Otherwise, it returns false.
   * @param hand ArrayList of 5 PlayingCard objects.
   * @return Boolean value true if there are 4 equal face values in the hand. False if not.
   */
  public static boolean isFourOfAKind(ArrayList<PlayingCard> hand) {
    List<Integer> handFaces = hand.stream().map(PlayingCard::getFace).toList();
    int countFirst = 0;
    int countLast = 0;

    if (handFaces.stream().distinct().count() == 2) {
      List<Integer> distFaces = handFaces.stream().distinct().toList();
      for (Integer f : handFaces) {
        if (Objects.equals(f, distFaces.getFirst())) {
          countFirst += 1;
        }
        if (Objects.equals(f, distFaces.getLast())) {
          countLast += 1;
        }
      }
    }
    return countLast == 4 || countFirst == 4;
  }

}