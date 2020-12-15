package Controller;
import Model.UserAdmin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

        @FXML
        private TextField UserId;

        @FXML
        private PasswordField PassId;

        private Service service;

        public void setService(Service S)
        {
        service = S;
        }

        @FXML
        public void Login() throws Exception {
            String userId = UserId.getText();
            String passId = PassId.getText();
            UserAdmin u = null;

                for(UserAdmin a: service.GetUsers())
                    if (a.getUserName().equals(userId) && a.getUserPass().equals(passId)) {
                        u = a;
                        break;
                    }
                    if(u != null)
                        {
                            FXMLLoader root = new FXMLLoader(getClass().getResource("../View/HomePage.fxml"));
                            Stage stage = new Stage();
                            stage.setTitle("Home Window");
                            AnchorPane layout = (AnchorPane) root.load();
                            Controller_2 controller_2 = root.getController();
                            controller_2.setService(service, u.getUserName());
                            stage.setScene(new Scene(layout));
                            stage.show();

                        /*FXMLLoader root_2 = new FXMLLoader(getClass().getResource("/View/Settings.fxml"));
                        Settings settings = root_2.getController();
                        settings.setUser(u);

                         */
                        }
                    else {
                        Alert A = new Alert(Alert.AlertType.ERROR);
                        A.setContentText("Try again!!!!");
                        A.show();
                    }
        }
}
