package Controller;

import Depo.GuestDepo;
import Depo.RoomDepo;
import Depo.UserAdminDepo;
import Model.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DBConnection conn = new DBConnection();
        Connection connection = conn.dbConnection();

        UserAdminDepo Useradmin = new UserAdminDepo(connection);
        Useradmin.Read();

        RoomDepo Room = new RoomDepo(connection);
        Room.Read();

        GuestDepo Guest = new GuestDepo(connection);
        Guest.Read();

        Service S = new Service(Useradmin, Room, Guest);

        FXMLLoader root = new FXMLLoader(getClass().getResource("../View/Login.fxml"));
        primaryStage.setTitle("Hotel Management");
        AnchorPane layout = root.load();
        Controller controller = root.getController();
        controller.setService(S);
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();

        //System.out.println(System.getProperty("java.version")); System.out.println(System.getProperty("javafx.version"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
