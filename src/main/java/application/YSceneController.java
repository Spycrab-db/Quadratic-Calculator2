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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class YSceneController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    double x;
    public int precision;

    @FXML
    TextField xTextField;
    @FXML
    Label decimalPlacesLabel;
    @FXML
    Slider accuracySlider;
    @FXML
    Label errorLabel;


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

    public void enter(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ShowYScene.fxml"));
            root = loader.load();
            x = Double.parseDouble(xTextField.getText());
            ShowYSceneController showYSceneControllerObject = loader.getController();
            showYSceneControllerObject.calculateY(Global.getAValue(), Global.getBValue(), Global.getCValue(), x, precision);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("css/YScene.css").toExternalForm());
            scene.setFill(Color.TRANSPARENT);

            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        }
        catch(NumberFormatException | IOException e){
            errorLabel.setText("Invalid input for x");
        }
        catch(Exception e ){
            System.out.println(e);
        }
    }

    public void close(MouseEvent event){
        Global.close(event);
    }
}
