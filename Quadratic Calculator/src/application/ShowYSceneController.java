package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowYSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label YLabel;

    public void calculateY(double a, double b, double c, double x, int precision){
        double answer = MyMath.round(((a * Math.pow(x,2)) + (b * x) + c), precision);
        String stringAnswer = String.format("%." + precision + "f", answer);
        YLabel.setText("f(" + x + ") = " + stringAnswer);
    }

    public void done(ActionEvent event) throws IOException {
        Global globalObject = new Global();
        globalObject.goToMenu(event);
    }
}
