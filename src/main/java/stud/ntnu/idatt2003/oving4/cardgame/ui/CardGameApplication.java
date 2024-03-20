package stud.ntnu.idatt2003.oving4.cardgame.ui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import stud.ntnu.idatt2003.oving4.cardgame.model.DeckOfCards;
import stud.ntnu.idatt2003.oving4.cardgame.model.PlayingCard;

public class CardGameApplication extends Application {
  Button checkHand;
  Button newHand;
  Button exitGame;
  BorderPane layout;
  Stage window;
  Scene scene1;
  HBox center;
  public static Text flushAnswer;
  public static Text royalFlushAnswer;
  public static Text fourOfAKindAnswer;
  public static Text sumOfFacesAnswer;
  public static Text cardsOfHeartsAnswer;
  public static Text spadeWomanAnswer;
  /**
   * Sets up the program as a javafx application, then calls the start method.
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    try {
      window = primaryStage;
      window.setTitle("Mini Card Game <3");
      // buttons
      this.newHand = new Button("New hand");
      newHand.getStyleClass().add("button");

      this.checkHand = new Button("Check hand");
      checkHand.getStyleClass().add("button");

      this.exitGame = new Button("Exit game");
      exitGame.getStyleClass().add("button");

      layout = new BorderPane();

      HBox bottom = addBottomHBox();
      VBox left = addLeftVbox();
      this.center = new HBox();
      center.getStyleClass().add("centerBox");

      layout.setLeft(left);
      layout.setBottom(bottom);
      layout.setCenter(center);

      scene1 = new Scene(layout, 1300, 750);
      scene1.getStylesheets().add("styles.css");

      // button events
      newHand.setOnAction(e -> {
        flushAnswer.setText("");
        royalFlushAnswer.setText("");
        fourOfAKindAnswer.setText("");
        sumOfFacesAnswer.setText("");
        cardsOfHeartsAnswer.setText("");
        spadeWomanAnswer.setText("");
        ArrayList<PlayingCard> hand = ButtonManager.newDeckButton();
        center.getChildren().clear();

        for (PlayingCard c : hand) {
          String path = DeckOfCards.generateImagePath(c.getSuit(), c.getFace());
          System.out.println(path);
          Image image = new Image(path);
          ImageView view = new ImageView(image);
          view.setFitWidth(180);
          view.setPreserveRatio(true);

          center.getChildren().add(view);
          view.toFront();
        }
      });

      checkHand.setOnAction(e -> {
        ButtonManager.checkHandButton();
      });

      exitGame.setOnAction(e -> stop());

      window.setScene(scene1);
      window.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  // bottom of the borderpane
  private HBox addBottomHBox() {
    HBox bottom = new HBox();
    bottom.getStyleClass().add("hBox");

    bottom.getChildren().addAll(this.newHand, this.checkHand, this.exitGame);

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
    info.getStyleClass().add("leftHBox");

    Text flushText = new Text("Flush?");
    flushAnswer = new Text();
    flushText.getStyleClass().add("text");
    flushAnswer.getStyleClass().add("text");

    info.getChildren().addAll(flushText, flushAnswer);

    return info;
  }
  private HBox royalFlushbox() {
    HBox info = new HBox();
    info.getStyleClass().add("leftHBox");

    Text royalFlush = new Text("Royal Flushes?");
    royalFlushAnswer = new Text();
    royalFlush.getStyleClass().add("text");
    royalFlushAnswer.getStyleClass().add("text");

    info.getChildren().addAll(royalFlush, royalFlushAnswer);

    return info;
  }
  private HBox fourOfAKindBox() {
    HBox info = new HBox();
    info.getStyleClass().add("leftHBox");

    Text fourOfaKindText = new Text("4 of a kind?");
    fourOfAKindAnswer = new Text();
    fourOfaKindText.getStyleClass().add("text");
    fourOfAKindAnswer.getStyleClass().add("text");

    info.getChildren().addAll(fourOfaKindText, fourOfAKindAnswer);

    return info;
  }
  private HBox sumOfFacesBox() {
    HBox info = new HBox();
    info.getStyleClass().add("leftHBox");

    Text sum = new Text("Sum of faces:");
    sumOfFacesAnswer = new Text();
    sum.getStyleClass().add("text");
    sumOfFacesAnswer.getStyleClass().add("text");

    info.getChildren().addAll(sum, sumOfFacesAnswer);

    return info;
  }
  private HBox cardsOfHeartsBox() {
    HBox info = new HBox();
    info.getStyleClass().add("leftHBox");

    Text cardsOfHeartsText = new Text("Cards of <3:");
    cardsOfHeartsAnswer = new Text();
    cardsOfHeartsText.getStyleClass().add("text");
    cardsOfHeartsAnswer.getStyleClass().add("text");

    info.getChildren().addAll(cardsOfHeartsText, cardsOfHeartsAnswer);

    return info;
  }
  private HBox spadesWomanBox() {
    HBox info = new HBox();
    info.getStyleClass().add("leftHBox");

    Text spadeWomanText = new Text("Spade woman?");
    spadeWomanAnswer = new Text();
    spadeWomanText.getStyleClass().add("text");
    spadeWomanAnswer.getStyleClass().add("text");

    info.getChildren().addAll(spadeWomanText, spadeWomanAnswer);

    return info;
  }
  @Override
  public void stop() {
    System.exit(0);
  }
}
