package stud.ntnu.idatt2003.oving4.cardgame.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
    checkHand.setOnAction(e -> {});
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
  private VBox addVbox() {
    VBox leftView = new VBox();
    leftView.setStyle("-fx-background-color: #778899;");
    leftView.setPadding(new Insets(10));

    Text title = new Text("Your stats: ");
    title.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
    leftView.getChildren().add(title);

    return leftView;
  }

  @Override
  public void stop() {
    System.exit(0);
  }

  @Override
  public void handle(ActionEvent actionEvent) {

  }
}
