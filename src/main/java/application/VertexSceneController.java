package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VertexSceneController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Slider accuracySlider;
    @FXML
    private Label decimalPlacesLabel;

    public int precision;


    public void goBack(MouseEvent event) throws IOException {
        Global globalObject = new Global();
        globalObject.goToMenu(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accuracySlider.valueProperty().addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                precision = (int) accuracySlider.getValue();
                decimalPlacesLabel.setText(Integer.toString(precision) + " Decimal Places");
            }
        });
    }

    public void enter(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ShowVertexScene.fxml"));
            root = loader.load();
            ShowVertexSceneController showVertexSceneController = loader.getController();
            showVertexSceneController.calculateVertex(Global.getAValue(),Global.getBValue(),Global.getCValue(), precision);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("css/XIntAndVertex.css").toExternalForm());
            scene.setFill(Color.TRANSPARENT);

            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void close(MouseEvent event){
        Global.close(event);
    }
}