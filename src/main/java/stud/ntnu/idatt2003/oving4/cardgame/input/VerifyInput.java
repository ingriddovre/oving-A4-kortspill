package stud.ntnu.idatt2003.oving4.cardgame.input;

import javafx.scene.control.TextField;

public class VerifyInput {

  public static int isInt(TextField input, String message) {
    try {
      int number = Integer.parseInt(input.getText());
      System.out.println(input.getText() + " cards");
      return number;
    } catch (NumberFormatException e) {
      System.out.println("Error: " + message + " is not a number.");
      return 0;
    }
  }

}
