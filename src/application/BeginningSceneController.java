package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class BeginningSceneController {
    @FXML
    public TextField AValueTextField;
    @FXML
    public TextField BValueTextField;
    @FXML
    public TextField CValueTextField;
    @FXML
    private Label typeErrorLabel;
    @FXML
    AnchorPane scenePane;

    public void enter(ActionEvent event) throws IOException {
        try {
            Global.setAValue(Double.parseDouble(AValueTextField.getText()));
            Global.setBValue(Double.parseDouble(BValueTextField.getText()));
            Global.setCValue(Double.parseDouble(CValueTextField.getText()));
            if (Global.getAValue() == 0){
                typeErrorLabel.setText("Function entered is not quadratic");
                typeErrorLabel.setTextFill(Color.RED);
                return;
            }
            Global.randomColorInt = (int) (Math.random() * 4 + 1);
            Global globalObject = new Global();
            globalObject.goToMenu(event);
        }
        catch (NumberFormatException e) {
            typeErrorLabel.setText("Please enter numbers");
            typeErrorLabel.setTextFill(Color.RED);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void close(MouseEvent event){
        Global.close(event);
    }
}
