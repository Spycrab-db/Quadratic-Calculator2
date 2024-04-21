package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GraphingSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label horizontalTranslationLabel;
    @FXML
    Label verticalTranslationLabel;
    @FXML
    Label reflectionLabel;
    @FXML
    Label stretchFactorLabel;

    public void goBack(ActionEvent event) throws IOException {
        Global globalObject = new Global();
        globalObject.goToMenu(event);
    }
    public void displayTransformations(double a, double b, double c){
        double verticalStretchFactor = MyMath.round(Math.abs(a), 2);
        boolean verticalReflection = a < 0;
        double horizontalTranslation = MyMath.round(-(b / (2 * a)),2);
        double verticalTranslation = MyMath.round(c - (Math.pow(b, 2) / (4 * a)),2);

        String verticalStretchFactorStatement = ("Vertical stretch factor of " + verticalStretchFactor);
        String verticalReflectionStatement = (verticalReflection)? "Reflection in the x-axis" : "No reflection";
        String horizontalTranslationStatement = ("No horizontal translation");
        String verticalTranslationStatement = ("No vertical translation");

        if (horizontalTranslation > 0){
            horizontalTranslationStatement = ("Translate right by " + Math.abs(horizontalTranslation));
        }
        else if (horizontalTranslation < 0){
            horizontalTranslationStatement = ("Translate left by " + Math.abs(horizontalTranslation));
        }


        if (verticalTranslation > 0){
            verticalTranslationStatement = ("Translate up by " + Math.abs(verticalTranslation));
        }
        else if (verticalTranslation < 0){
            verticalTranslationStatement = ("Translate down by " + Math.abs(verticalTranslation));
        }

        stretchFactorLabel.setText(verticalStretchFactorStatement);
        reflectionLabel.setText(verticalReflectionStatement);
        horizontalTranslationLabel.setText(horizontalTranslationStatement);
        verticalTranslationLabel.setText(verticalTranslationStatement);
    }
}
