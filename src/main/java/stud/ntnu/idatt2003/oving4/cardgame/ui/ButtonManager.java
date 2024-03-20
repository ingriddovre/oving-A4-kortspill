package stud.ntnu.idatt2003.oving4.cardgame.ui;

import java.util.ArrayList;
import stud.ntnu.idatt2003.oving4.cardgame.model.CheckHand;
import stud.ntnu.idatt2003.oving4.cardgame.model.DeckOfCards;
import stud.ntnu.idatt2003.oving4.cardgame.model.PlayingCard;
import stud.ntnu.idatt2003.oving4.cardgame.ui.CardGameApplication;

public class ButtonManager {
  static DeckOfCards deck = new DeckOfCards();
  static ArrayList<PlayingCard> hand;

  public static ArrayList<PlayingCard> newDeckButton() {
    hand = deck.dealHand(5);
    return hand;
  }
  public static void checkHandButton() {

    boolean flushAnswer = CheckHand.isFlush(hand);
    CardGameApplication.flushAnswer.setText(String.valueOf(flushAnswer));

    boolean rFAnswer = CheckHand.isRoyalFlush(hand);
    CardGameApplication.royalFlushAnswer.setText(String.valueOf(rFAnswer));

    boolean spadeWomanCard = CheckHand.spadesWoman(hand);
    CardGameApplication.spadeWomanAnswer.setText(String.valueOf(spadeWomanCard));

    boolean fourOfAKindCards = CheckHand.isFourOfAKind(hand);
    CardGameApplication.fourOfAKindAnswer.setText(String.valueOf(fourOfAKindCards));

    int sum = CheckHand.sumOfFaces(hand);
    CardGameApplication.sumOfFacesAnswer.setText(String.valueOf(sum));

    String heartCards = CheckHand.cardsOfHearts(hand);
    CardGameApplication.cardsOfHeartsAnswer.setText(heartCards);
  }
}
