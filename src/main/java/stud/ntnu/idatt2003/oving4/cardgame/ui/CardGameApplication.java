package stud.ntnu.idatt2003.oving4.cardgame.ui;

import java.util.ArrayList;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import stud.ntnu.idatt2003.oving4.cardgame.input.VerifyInput;
import stud.ntnu.idatt2003.oving4.cardgame.model.ButtonManager;
import stud.ntnu.idatt2003.oving4.cardgame.model.CheckHand;
import stud.ntnu.idatt2003.oving4.cardgame.model.DeckOfCards;
import stud.ntnu.idatt2003.oving4.cardgame.model.PlayingCard;


// todo: https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG yt-serie om javafx
// todo: https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm link til layouts
public class CardGameApplication extends Application {
  Button checkHand;
  Button newHand;
  Button exitGame;
  BorderPane layout;
  Stage window;
  Scene scene1;
  HBox center;
  public static boolean flush;
  public static boolean royalFlush;
  public static boolean spadeWoman;
  public static boolean fourOfAKind;
  public static int sumOfFaces;
  public static String cardsOfHearts;
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
    this.center = new HBox();
    center.getStyleClass().add("hBox");

    layout.setLeft(left);
    layout.setBottom(bottom);
    layout.setCenter(center);

    scene1 = new Scene(layout, 1000, 800);
    scene1.getStylesheets().add("styles.css");

    window.setScene(scene1);
    window.show();


    // button events
    newHand.setOnAction(e -> {
      ArrayList<PlayingCard> hand = ButtonManager.newDeckButton();
      center.getChildren().removeAll(); // removes the prior images if method was used prior

      for (PlayingCard c : hand) {
        String path = DeckOfCards.generateImagePath(c.getSuit(), c.getFace());
        System.out.println(path);
        Image image = new Image(path);
        ImageView view = new ImageView(image);
        view.setFitWidth(150);
        view.setPreserveRatio(true);
        center.getChildren().add(view);
        view.toFront();
      }
    });

    checkHand.setOnAction(e -> ButtonManager.checkHandButton());

    exitGame.setOnAction(e -> stop());
  }


  // bottom of the borderpane
  private HBox addBottomHBox() {
    HBox bottom = new HBox();
    bottom.getStyleClass().add("hBox");

    newHand = new Button("New hand");
    newHand.getStyleClass().add("button");

    checkHand = new Button("Check hand");
    checkHand.getStyleClass().add("button");

    exitGame = new Button("Exit game");
    exitGame.getStyleClass().add("button");

    bottom.getChildren().addAll(newHand, checkHand, exitGame);

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
    Text answer = new Text(String.valueOf(flush));
    flushText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    info.getChildren().addAll(flushText, answer);

    return info;
  }
  private HBox royalFlushbox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text royalFlushText = new Text("Royal Flushes");
    Text answer = new Text(String.valueOf(royalFlush));
    royalFlushText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    info.getChildren().addAll(royalFlushText, answer);

    return info;
  }
  private HBox fourOfAKindBox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text fourOfaKindText = new Text("4 of a kind");
    Text answer = new Text(String.valueOf(fourOfAKind));
    fourOfaKindText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    info.getChildren().addAll(fourOfaKindText, answer);

    return info;
  }
  private HBox sumOfFacesBox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text sum = new Text("Sum of faces: ");
    Text answer = new Text(String.valueOf(sumOfFaces));
    sum.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    info.getChildren().addAll(sum, answer);

    return info;
  }
  private HBox cardsOfHeartsBox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text cardsOfHeartsText = new Text("Cards of <3:");
    Text answer = new Text(cardsOfHearts);
    cardsOfHeartsText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    info.getChildren().addAll(cardsOfHeartsText, answer);

    return info;
  }
  private HBox spadesWomanBox() {
    HBox info = new HBox();
    info.getStyleClass().add("hBox");

    Text spadeWomanText = new Text("Spade woman?");
    Text answer = new Text(String.valueOf(spadeWoman));
    spadeWomanText.getStyleClass().add("text");
    answer.getStyleClass().add("text");

    info.getChildren().addAll(spadeWomanText, answer);

    return info;
  }
  @Override
  public void stop() {
    System.exit(0);
  }
}
