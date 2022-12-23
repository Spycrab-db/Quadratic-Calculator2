package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class ShowXIntController {
    @FXML
    Label XIntLabel;
    @FXML
    Label theXIntLabel;

    public void done(ActionEvent event) throws IOException {
        Global globalObject = new Global();
        globalObject.goToMenu(event);
    }

    public void calculateXInt(double a, double b, double c, int precision){
        double answer1 = ((-b + Math.sqrt(Math.pow(b,2) - 4 * a * c)) / (2 * a)); //Quadratic Formula with +
        double roundedAnswer1 = MyMath.round(answer1, precision);
        String stringAnswer1 = String.format("%." + precision + "f", roundedAnswer1);

        double answer2 = ((-b - Math.sqrt(Math.pow(b,2) - 4 * a * c)) / (2 * a)); //Quadratic Formula with -
        double roundedAnswer2 = MyMath.round(answer2, precision);
        String stringAnswer2 = String.format("%." + precision + "f", roundedAnswer2);

        XIntLabel.setText("[" + stringAnswer1 + ", " + stringAnswer2 + "]");
    }
}
