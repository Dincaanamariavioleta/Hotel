package Controller;

import Model.Guest;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class CheckOut {

    @FXML
    private TextField RoomNumber;

    private Service service;

    public void setService(Service S)
    {
        service = S;
    }

    @FXML
    void Clear() {
        RoomNumber.clear();
    }

    @FXML
    void CheckOut() {
        try{
            int n = Integer.parseInt(RoomNumber.getText());
                service.roomCheckOut(n);

                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Check Out is done!");
                a.show();
        } catch (SQLException throwables) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Try again!");
            a.show();
            throwables.getStackTrace();
        }
    }

}
