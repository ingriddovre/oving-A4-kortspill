package stud.ntnu.idatt2003.oving4.cardgame.ui;

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


// todo: https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG yt-serie om javafx
// todo: https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm link til layouts
public class CardGameApplication extends Application implements EventHandler<ActionEvent> {
  Button checkHand;
  Button newHand;
  Button exitGame;
  BorderPane layout;
  Stage window;
  Scene scene1;
  static TextField input;
  boolean flush;
  boolean royalFlush;
  boolean spadeWoman;
  boolean fourOfAKind;
  int sumOfFaces;
  String cardsOfHearts;

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
    scene1.getStylesheets().add("src/main/resources/styles.css");

    window.setScene(scene1);
    window.show();
  }

  // bottom of the borderpane
  private HBox addBottomHBox() {
    HBox bottom = new HBox();
    bottom.getStylesheets().add("styles.css");
    bottom.getStyleClass().add("hBox");

    input = new TextField("Type amount of cards");
    input.setPrefSize(200, 30);

    // buttons
    newHand = new Button("New hand");
    newHand.getStylesheets().add("button");
    newHand.setOnAction(e -> {
      DeckOfCards.dealHand(VerifyInput.isInt(input, input.getText()));
    });

    checkHand = new Button("Check hand");
    checkHand.getStylesheets().add("button");
    checkHand.setOnAction(e -> {
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
    exitGame.getStylesheets().add("button");
    exitGame.setOnAction(e -> stop());

    bottom.getChildren().addAll(newHand, checkHand, exitGame, input);

    return bottom;
  }

  // left of the borderpane
  private VBox addLeftVbox() { // might want to make this one a stack panel
    VBox leftView = new VBox();
    leftView.getStylesheets().add("styles.css");
    leftView.getStyleClass().add("vBox");

    // text
    Text title = new Text("Your stats:");
    title.getStyleClass().add("TitleText");


    leftView.getChildren().addAll(title);

    return leftView;
  }

// todo: add all hboxes under eachother to all then add in the left panel
  private HBox flushbox() {
    HBox info = new HBox();
    info.getStylesheets().add("styles.css");

    Text flush = new Text("Flush");
    flush.getStyleClass().add("text");

    info.getChildren().addAll(flush);

    return info;
  }
  private HBox royalFlushbox() {
    HBox info = new HBox();
    info.getStyleClass().add("styles.css");

    Text royalFlush = new Text("Royal Flushes");
    royalFlush.getStyleClass().add("text");

    info.getChildren().addAll(royalFlush);

    return info;

  }
  private HBox fourOfAKindBox() {
    HBox info = new HBox();
    info.getStylesheets().add("styles.css");

    Text fourOfaKind = new Text("4 of a kind");
    fourOfaKind.getStyleClass().add("text");

    return info;
  }
  private HBox sumOfFacesBox() {
    HBox info = new HBox();
    info.getStylesheets().add("styles.css");

    Text sum = new Text("Sum of faces: ");
    sum.getStyleClass().add("text");

    return info;
  }
  private HBox cardsOfHeartsBox() {
    HBox info = new HBox();
    info.getStylesheets().add("styles.css");

    Text cardsOfHearts = new Text("Cards of <3:");
    cardsOfHearts.getStyleClass().add("text");

    return info;
  }
  private HBox spadesWomanBox() {
    HBox info = new HBox();
    info.getStylesheets().add("styles.css");

    Text spadeWoman = new Text("Spade woman?");
    spadeWoman.getStyleClass().add("text");

    return info;
  }

  // todo: lag denne til en container som inneholder bilder av kortene

  @Override
  public void stop() {
    System.exit(0);
  }

  @Override
  public void handle(ActionEvent actionEvent) {

  }
}
