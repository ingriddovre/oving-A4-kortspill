package stud.ntnu.idatt2003.oving4.cardgame.ui;

import java.util.ArrayList;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import stud.ntnu.idatt2003.oving4.cardgame.input.VerifyInput;
import stud.ntnu.idatt2003.oving4.cardgame.model.CheckHand;
import stud.ntnu.idatt2003.oving4.cardgame.model.DeckOfCards;
import stud.ntnu.idatt2003.oving4.cardgame.model.PlayingCard;


// todo: https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG yt-serie om javafx
// todo: https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm link til layouts
public class CardGameApplication extends Application implements EventHandler<ActionEvent> {
  Button checkHand;
  Button newHand;
  Button exitGame;
  BorderPane layout;
  Stage window;
  Scene scene1;
  TextField input;
  boolean flush;
  boolean royalFlush;
  boolean spadeWoman;
  boolean fourOfAKind;
  int sumOfFaces;
  String cardsOfHearts;
  static boolean check = false;

  /**
   * Sets up the program as a javafx application, then calls the start method.
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("Mini Card Game <3");

    layout = new BorderPane();

    HBox bottom = addBottomHBox();
    VBox left = addLeftVbox();
    layout.setLeft(left);
    layout.setBottom(bottom);

    scene1 = new Scene(layout, 1000, 800);
    scene1.getStylesheets().add("styles.css");

    window.setScene(scene1);
    window.show();
  }

  // bottom of the borderpane
  private HBox addBottomHBox() {
    HBox bottom = new HBox();
    bottom.getStyleClass().add("hBox");

    input = new TextField("Type amount of cards");
    input.setPrefSize(200, 30);
    input.getStyleClass().add("text");

    input.setOnAction(e -> {
      // todo: i window med kort i, clear før du legger inn nye kort - trenger ikke new hand button egt
      ArrayList<PlayingCard> hand = DeckOfCards.dealHand(VerifyInput.isInt(input, input.getText()));

      for (PlayingCard c : hand) {
        // generate new image with a generateImage() method that takes in the suit and face of the card
        // new ImageView object of the image you generated
        // set size and preserveRation true
        // add the image to the "bottom" hbox,
        // can be smart to Bring to front

      }
    }

    // buttons
    newHand = new Button("New hand");
    newHand.getStyleClass().add("button");
    newHand.setOnAction(e -> {
      ArrayList<PlayingCard> hand = DeckOfCards.dealHand(VerifyInput.isInt(input, input.getText()));

    });

    checkHand = new Button("Check hand");
    checkHand.getStyleClass().add("button");
    checkHand.setOnAction(e -> {
      check = true;
      flush = CheckHand.isFlush(DeckOfCards.dealHand(
          VerifyInput.isInt(input, input.getText())));

      royalFlush = CheckHand.isRoyalFlush(DeckOfCards.dealHand(
          VerifyInput.isInt(input, input.getText())));

      spadeWoman = CheckHand.spadesWoman(DeckOfCards.dealHand(
          VerifyInput.isInt(input, input.getText())));

      fourOfAKind = CheckHand.isFourOfAKind(DeckOfCards.dealHand(
          VerifyInput.isInt(input, input.getText())));

      sumOfFaces = CheckHand.sumOfFaces(DeckOfCards.dealHand(
          VerifyInput.isInt(input, input.getText())));

      cardsOfHearts = CheckHand.cardsOfHearts(DeckOfCards.dealHand(
          VerifyInput.isInt(input, input.getText())));
    });

    exitGame = new Button("Exit game");
    exitGame.getStyleClass().add("button");
    exitGame.setOnAction(e -> stop());

    bottom.getChildren().addAll(input, newHand, checkHand, exitGame);

    return bottom;
  }

  // left of the borderpane
  private VBox addLeftVbox() {
    VBox leftView = new VBox();
    leftView.getStyleClass().add("vBox");

    Text title = new Text("Your stats:");
    title.getStyleClass().add("TitleText");

    leftView.getChildren().addAll(title, flushbox(), royalFlushbox(), fourOfAKindBox(),
        sumOfFacesBox(), cardsOfHeartsBox(), spadesWomanBox());

    return leftView;
  }

  private HBox flushbox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text flushText = new Text("Flush");
    TextArea answer = new TextArea(String.valueOf(flush));
    flushText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    if (check) {
      info.getChildren().addAll(flushText, answer);
    } else {
      info.getChildren().add(flushText);
    }
    return info;
  }
  private HBox royalFlushbox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text royalFlushText = new Text("Royal Flushes");
    Text answer = new Text(String.valueOf(royalFlush));
    royalFlushText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    if (check) {
      info.getChildren().addAll(royalFlushText, answer);
    } else {
      info.getChildren().add(royalFlushText);
    }
    return info;
  }
  private HBox fourOfAKindBox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text fourOfaKindText = new Text("4 of a kind");
    Text answer = new Text(String.valueOf(fourOfAKind));
    fourOfaKindText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    if (check) {
      info.getChildren().addAll(fourOfaKindText, answer);
    } else {
      info.getChildren().add(fourOfaKindText);
    }
    return info;
  }
  private HBox sumOfFacesBox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text sum = new Text("Sum of faces: ");
    Text answer = new Text(String.valueOf(sumOfFaces));
    sum.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    if (check) {
      info.getChildren().addAll(sum, answer);
    } else {
      info.getChildren().add(sum);
    }
    return info;
  }
  private HBox cardsOfHeartsBox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text cardsOfHeartsText = new Text("Cards of <3:");
    Text answer = new Text(cardsOfHearts);
    cardsOfHeartsText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    if (check) {
      info.getChildren().addAll(cardsOfHeartsText, answer);
    } else {
      info.getChildren().add(cardsOfHeartsText);
    }
    return info;
  }
  private HBox spadesWomanBox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text spadeWomanText = new Text("Spade woman?");
    Text answer = new Text(String.valueOf(spadeWoman));
    spadeWomanText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    if (check) {
      info.getChildren().addAll(spadeWomanText, answer);
    } else {
      info.getChildren().add(spadeWomanText);
    }
    return info;
  }


  @Override
  public void stop() {
    System.exit(0);
  }

  @Override
  public void handle(ActionEvent actionEvent) {

  }
}
