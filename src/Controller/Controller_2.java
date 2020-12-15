package Controller;

import Model.Room;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_2 {

        @FXML
        private TextField NameId;

        @FXML
        private TextField ReservedRooms;

        @FXML
        private TextField AvailableRooms;

        private Service service;

        public void setService(Service S, String name)
        {
            service = S;
            AvailableRooms.setText(setAvailableRooms());
            ReservedRooms.setText(setReservedRooms());
            NameId.setText(name);
        }

        public String setReservedRooms()
        {
            int nr0 = 0;
            for(Room r: service.GetRooms())
                if(r.getIsEmpty() != true) nr0++;
            return String.valueOf(nr0);
        }
        public String setAvailableRooms()
        {
            int nr = 0;
            for(Room r: service.GetRooms())
                if(r.getIsEmpty() == true) nr++;
               return String.valueOf(nr);
        }

        @FXML
        void Settings() throws IOException {
            FXMLLoader root = new FXMLLoader(getClass().getResource("../View/Settings.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Settings");
            AnchorPane layout = root.load();
            stage.setScene(new Scene(layout));
            stage.show();
            Settings set = root.getController();
            set.setService(service);
        }

        @FXML
        void Logout() {
          Scene s = ReservedRooms.getScene();
          Stage t = (Stage) s.getWindow();
          t.close();
        }

        @FXML
        void CheckIn() throws IOException {
            FXMLLoader root = new FXMLLoader(getClass().getResource("../View/CheckIn.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Home Window");
            AnchorPane layout = root.load();
            CheckIn Checkin = root.getController();
            Checkin.setService(service);
            stage.setScene(new Scene(layout));
            stage.show();
        }

        @FXML
        void RoomBooking() {

        }

        @FXML
        void Rooms() throws IOException {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/View/Rooms.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Rooms");
            AnchorPane layout = root.load();
            Rooms RoomCon = root.getController();
            RoomCon.setService(service);
            stage.setScene(new Scene(layout));
            stage.show();
        }

        @FXML
        void CheckOut() throws IOException {
            FXMLLoader root = new FXMLLoader(getClass().getResource("../View/CheckOut.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Check out");
            AnchorPane layout = root.load();
            CheckOut checkOut = root.getController();
            checkOut.setService(service);
            stage.setScene(new Scene(layout));
            stage.show();
        }

        @FXML
        void Guests() throws IOException {
            FXMLLoader root = new FXMLLoader(getClass().getResource("../View/Guests.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Guests");
            AnchorPane layout = root.load();
            Guests guests = root.getController();
            guests.setService(service);
            stage.setScene(new Scene(layout));
            stage.show();
        }

        @FXML
        void CancelBooking() {

        }

    }


