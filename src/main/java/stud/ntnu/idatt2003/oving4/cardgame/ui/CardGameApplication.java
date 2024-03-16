package stud.ntnu.idatt2003.oving4.cardgame.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import stud.ntnu.idatt2003.oving4.cardgame.model.DeckOfCards;

// todo: https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG
public class CardGameApplication extends Application implements EventHandler<ActionEvent> {
  Button checkHand;
  Button newHand;
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
    BorderPane layout = new BorderPane();

    newHand = new Button("New hand");
    newHand.setPrefSize(80, 25);
    checkHand = new Button("Check hand");
    checkHand.setPrefSize(80, 25);

    HBox bottom = new HBox();
    layout.setBottom(bottom);
    bottom.setSpacing(10);
    bottom.setPadding(new Insets(15, 12, 15, 12));
    bottom.getChildren().addAll(newHand, checkHand);
    scene1 = new Scene(layout, 500, 350);

    // lambda expression to handle button events todo: fix event handling later
    newHand.setOnAction(e -> DeckOfCards.dealHand(5));
    checkHand.setOnAction(e -> {
    });


    window.setScene(scene1);
    window.show();
  }

  @Override
  public void stop() {
    System.exit(0);
  }


  @Override
  public void handle(ActionEvent actionEvent) {

  }
}
