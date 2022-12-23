package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class ShowVertexSceneController {
    @FXML
    Label vertexLabel;

    public void calculateVertex(double a, double b, double c, int precision){
        double vertexX = MyMath.round((-b / (2*a)), precision);
        double vertexY = MyMath.round((c - (Math.pow(b,2) / (4*a)  )), precision);
        String stringVertexX = String.format("%." + precision + "f", vertexX);
        String stringVertexY = String.format("%." + precision + "f", vertexY);
        vertexLabel.setText("(" + stringVertexX + ", " + stringVertexY + ")");
    }
    public void done(ActionEvent event) throws IOException {
        Global globalObject = new Global();
        globalObject.goToMenu(event);
    }
}