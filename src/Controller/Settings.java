package Controller;

import Model.UserAdmin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Iterator;

public class Settings {

    @FXML
    private TextField PassForAdd;

    @FXML
    private TextField IsAdmin;


    @FXML
    private TableColumn<?, ?> NameUser;

    @FXML
    private TextField NameForDelete;

    @FXML
    private TextField NameForAdd;

    @FXML
    private TableColumn<?, ?> Admin;

    @FXML
    private TableColumn<UserAdmin, Integer> IdUser;

    private Service service;

    public void setService(Service S)
    {

        service = S;
        Initialize();
    }

    @FXML
    ObservableList<UserAdmin> Users = FXCollections.observableArrayList();

    @FXML
    private TableView<UserAdmin> TableUser;

    void Initialize()
    {
        IdUser.setCellValueFactory(new PropertyValueFactory<>("userId"));
        NameUser.setCellValueFactory(new PropertyValueFactory<>("userName"));
        Admin.setCellValueFactory(new PropertyValueFactory<>("isAdmin"));

        initTable();
    }
    public void initTable()
    {
        TableUser.getItems().clear();
        Users.clear();
        Users.addAll(service.GetUsers());
        TableUser.setItems(Users);
    }

    @FXML
    void AddUser() {
        try {
            String a = NameForAdd.getText();
            String b = PassForAdd.getText();
            boolean c = Boolean.valueOf(IsAdmin.getText());
            UserAdmin d = new UserAdmin(a, b, c);
            service.addUser(d);

            Alert e = new Alert(Alert.AlertType.CONFIRMATION);
            e.setContentText("User added!");
            e.show();
            initTable();
        }
        catch(Exception e)
        {
            Alert f = new Alert(Alert.AlertType.ERROR);
            f.setContentText("Try again!");
            f.show();
        }
    }

    @FXML
    void DeleteUser() {
       try {
           String name = NameForDelete.getText();

           Iterator<UserAdmin> iter = service.GetUsers().iterator();
           while(iter.hasNext()) {
               UserAdmin a = iter.next();
               if(a.getUserName().equals(name))
               {
                   service.DeleteUser(a);
                   break;
               }
           }

            Alert c = new Alert(Alert.AlertType.CONFIRMATION);
            c.setContentText("User deleted!");
            c.show();
            initTable();
        }
            catch (Exception e)
            {
                e.printStackTrace();
                Alert c = new Alert(Alert.AlertType.ERROR);
                c.setContentText("Try again!");
                c.show();
            }
    }

}
