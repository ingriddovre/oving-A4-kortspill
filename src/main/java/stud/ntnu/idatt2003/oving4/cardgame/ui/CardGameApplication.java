package stud.ntnu.idatt2003.oving4.cardgame.ui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
  boolean check = false;

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
    HBox bottom = addHbox();
    VBox left = addVbox();
    layout.setLeft(left);
    layout.setBottom(bottom);


    // lambda expression to handle button events todo: fix event handling later
    newHand.setOnAction(e -> DeckOfCards.dealHand(5));
    checkHand.setOnAction(e -> {check = true;});
    exitGame.setOnAction(e -> stop());

    scene1 = new Scene(layout, 800, 500);
    window.setScene(scene1);
    window.show();
  }

  // bottom of the borderpane
  private HBox addHbox() {
    HBox bottom = new HBox();
    bottom.setStyle("-fx-background-color: #778899;");
    bottom.setSpacing(10);
    bottom.setPadding(new Insets(15, 12, 15, 12));

    // init buttons
    newHand = new Button("New hand");
    newHand.setPrefSize(80, 25);

    checkHand = new Button("Check hand");
    checkHand.setPrefSize(80, 25);

    exitGame = new Button("Exit game");
    exitGame.setPrefSize(80, 20);

    bottom.getChildren().addAll(newHand, checkHand, exitGame);
    bottom.setAlignment(Pos.CENTER_LEFT);

    return bottom;
  }

  // left of the borderpane
  private VBox addVbox() { // might want to make this one a stack panel
    VBox leftView = new VBox();
    leftView.setStyle("-fx-background-color: #778899;");
    leftView.setPadding(new Insets(10));

    // text
    Text title = new Text("Your stats:");
    title.setFont(Font.font("Verdana", FontWeight.BOLD, 16));

    leftView.getChildren().addAll(title);

    return leftView;
  }

// todo: add all hboxes under eachother to all then add in the left panel
  private HBox flushbox() {
    HBox info = new HBox();
    info.setPadding(new Insets(10, 8, 10, 8));

    info.setStyle("-fx-background-color: #66778899");
    Text flush = new Text("Flush");
    flush.setFont(Font.font("Verdana", FontPosture.REGULAR, 15));

    int flushes = 0;
    Text count = new Text(String.valueOf(flushes));
    count.setFont(Font.font("Verdana", FontPosture.REGULAR, 15));

    info.getChildren().addAll(flush, count);

    return info;
  }
  private HBox royalFlushbox() {
    HBox info = new HBox();
    info.setPadding(new Insets(10, 8, 10, 8));
    info.setStyle("-fx-background-color: #696969");

    Text royalFlush = new Text("Royal Flushes");
    royalFlush.setFont(Font.font("Verdana", FontPosture.REGULAR, 15));

    int rFCount = 0;
    Text count = new Text(String.valueOf(rFCount));
    count.setFont(Font.font("Verdana", FontPosture.REGULAR, 15));

    info.getChildren().addAll(royalFlush, count);

    return info;

  }
  private HBox fourOfAKindBox() {
    HBox info = new HBox();
    int fourOfaKind = 0;
  }
  private HBox sumOfFacesBox() {
    HBox info = new HBox();
    int sumOfFaces = CheckHand.sumOfFaces();
  }
  private HBox cardsOfHeartsbox() {
    HBox info = new HBox();
    String CardsOfHearts = CheckHand.cardsOfHearts();
  }
  private HBox spadesWomanbox() {
    HBox info = new HBox();
    int countSpadeWoman = 0;
  }

  @Override
  public void stop() {
    System.exit(0);
  }

  @Override
  public void handle(ActionEvent actionEvent) {

  }
}
