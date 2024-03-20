package stud.ntnu.idatt2003.oving4.cardgame.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CheckHandTest {
  static ArrayList<PlayingCard> hand;
  static ArrayList<PlayingCard> hand2;
  @BeforeAll
    static void setUp() {
    DeckOfCards deck = new DeckOfCards();
    hand = deck.dealHand(5);
    }
  @Nested
  class positiveTests {
    @Test
    void isFlush() {
      PlayingCard c1 = new PlayingCard('H', 1);
      PlayingCard c2 = new PlayingCard('H', 2);
      PlayingCard c3 = new PlayingCard('H', 3);
      PlayingCard c4 = new PlayingCard('H', 4);
      PlayingCard c5 = new PlayingCard('H', 5);
      hand2 = new ArrayList<>();
      hand2.add(c1);
      hand2.add(c2);
      hand2.add(c3);
      hand2.add(c4);
      hand2.add(c5);
      try {
        assertTrue(CheckHand.isFlush(hand2));
      } catch (Exception e) {
        fail("Exception thrown, didnt return true for flush");
      }
    }

    @Test
    void isRoyalFlush() {
      PlayingCard c1 = new PlayingCard('H', 1);
      PlayingCard c2 = new PlayingCard('H', 10);
      PlayingCard c3 = new PlayingCard('H', 11);
      PlayingCard c4 = new PlayingCard('H', 12);
      PlayingCard c5 = new PlayingCard('H', 13);
      hand2 = new ArrayList<>();
      hand2.add(c1);
      hand2.add(c2);
      hand2.add(c3);
      hand2.add(c4);
      hand2.add(c5);
    }

    @Test
    void isFourOfAKind() {
      PlayingCard c1 = new PlayingCard('H', 1);
      PlayingCard c2 = new PlayingCard('D', 1);
      PlayingCard c3 = new PlayingCard('C', 1);
      PlayingCard c4 = new PlayingCard('S', 1);
      PlayingCard c5 = new PlayingCard('H', 5);
      hand2 = new ArrayList<>();
      hand2.add(c1);
      hand2.add(c2);
      hand2.add(c3);
      hand2.add(c4);
      hand2.add(c5);
      try {
        assertTrue(CheckHand.isFourOfAKind(hand2));
      } catch (Exception e) {
        fail("Exception thrown, didnt return true for four of a kind");
      }
    }

    @Test
    void sumOfFaces() {
      try {
        assertEquals(15, CheckHand.sumOfFaces(hand));
      } catch (Exception e) {
        fail("Didnt return the correct sum of faces.");
      }
    }

    @Test
    void cardsOfHearts() {
      try {
        String cardsOfHearts = CheckHand.cardsOfHearts(hand);
        assertEquals("H1H2H3H4H5", cardsOfHearts);
      } catch (Exception e) {
        fail("Didnt return the cards of hearts.");
      }
    }

    @Test
    void spadesWoman() {
      try {
        PlayingCard c1 = new PlayingCard('H', 1);
        PlayingCard c2 = new PlayingCard('H', 2);
        PlayingCard c3 = new PlayingCard('S', 12);
        PlayingCard c4 = new PlayingCard('D', 4);
        PlayingCard c5 = new PlayingCard('C', 12);
        hand2 = new ArrayList<>();
        hand2.add(c1);
        hand2.add(c2);
        hand2.add(c3);
        hand2.add(c4);
        hand2.add(c5);
        assertTrue(CheckHand.spadesWoman(hand2));
      } catch (Exception e) {
        fail("Didnt return correct boolean value.");
      }
    }
  }

  @Nested
  class negativeTests {
    @Test
    void isFlush() {

    }

    @Test
    void isRoyalFlush() {
    }

    @Test
    void isFourOfAKind() {
    }

    @Test
    void sumOfFaces() {
    }

    @Test
    void cardsOfHearts() {
    }

    @Test
    void spadesWoman() {
    }
  }

}