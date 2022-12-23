package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public final class Global {
    private static double AValue;
    private static double BValue;
    private static double CValue;



    public static double getAValue(){
        return AValue;
    }
    public static double getBValue(){
        return BValue;
    }
    public static double getCValue(){
        return CValue;
    }


    public static void setAValue(double AValue){
        Global.AValue = AValue;
    }
    public static void setBValue(double BValue){
        Global.BValue = BValue;
    }
    public static void setCValue(double CValue){
        Global.CValue = CValue;
    }

    public static int randomColorInt;

    public void goToMenu(ActionEvent event) throws IOException { //Method for goToMenu because it is used a lot
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/view/MenuScene.fxml"));
        Parent root = loader.load(); //Set "root" as a variable containing the root node of MenuScene
        MenuSceneController menuSceneController = loader.getController(); //Create an instance of MenuSceneController
        menuSceneController.displayABC(Global.getAValue(),Global.getBValue(),Global.getCValue()); //Call the displayABC method with inputs as arguments

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root); //Apply the root node of MenuScene to the new stage's scene
        this.getClass().getResource("../resources/css/MenuSceneAmyCrisp.css").toExternalForm();

        String css = switch (randomColorInt) { //Generate random color scheme depending on the random integer
            case 1 -> this.getClass().getResource("../resources/css/MenuSceneBluePurple.css").toExternalForm();
            case 2 -> this.getClass().getResource("../resources/css/MenuSceneBlueOrange.css").toExternalForm();
            case 3 -> this.getClass().getResource("../resources/css/MenuSceneBlueGreen.css").toExternalForm();
            default -> this.getClass().getResource("../resources/css/MenuSceneAmyCrisp.css").toExternalForm(); //number 4
            //Defining css as the styling sheet
        };
        scene.getStylesheets().add(css); //Import the styling sheet
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene); //Set the scene as MenuScene.fxml (Changing the scene of the stage to MenuScene)
        stage.centerOnScreen();
        stage.show(); //Show the stage
    }

    public void goToMenu(MouseEvent event) throws IOException { //Method overloading to accommodate for MouseEvent arguments (When input is a picture, not a button)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/view/MenuScene.fxml"));
        Parent root = loader.load(); //Set "root" as a variable containing the root node of MenuScene
        MenuSceneController menuSceneController = loader.getController(); //Create an instance of MenuSceneController
        menuSceneController.displayABC(Global.getAValue(),Global.getBValue(),Global.getCValue()); //Call the displayABC method with inputs as arguments

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root); //Apply the root node of MenuScene to the new stage's scene
        this.getClass().getResource("../resources/css/MenuSceneAmyCrisp.css").toExternalForm();

        String css = switch (randomColorInt) {
            case 1 -> this.getClass().getResource("../resources/css/MenuSceneBluePurple.css").toExternalForm();
            case 2 -> this.getClass().getResource("../resources/css/MenuSceneBlueOrange.css").toExternalForm();
            case 3 -> this.getClass().getResource("../resources/css/MenuSceneBlueGreen.css").toExternalForm();
            default -> this.getClass().getResource("../resources/css/MenuSceneAmyCrisp.css").toExternalForm(); //default
            //Create the styling sheet
        };
        scene.getStylesheets().add(css); //Import the styling sheet
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene); //Set the scene as MenuScene.fxml (Changing the scene of the stage to MenuScene)
        stage.centerOnScreen();
        stage.show(); //Show the stage
    }
    public static void close(MouseEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("You are about to quit!");
        alert.setContentText("Are you sure you want to quit?");
        if (alert.showAndWait().get() == ButtonType.OK) { //If user clicks OK button
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }
}
