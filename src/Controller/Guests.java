package Controller;

import Model.Guest;
import Model.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Guests {

    @FXML
    private TableColumn<?, ?> Passport;

    @FXML
    private TableColumn<?, ?> Email;

    @FXML
    private TableColumn<?, ?> Address;

    @FXML
    private TableColumn<?, ?> Phone;

    @FXML
    private TableColumn<?, ?> Days;

    @FXML
    private TableColumn<?, ?> RoomId;

    @FXML
    private TableColumn<?, ?> City;

    @FXML
    private TableColumn<Guest, Double> Fees;

    @FXML
    private TableColumn<?, ?> Nationality;

    @FXML
    private TableColumn<?, ?> Name;

    private Service service;

    public void setService(Service S)
    {
        service = S;
        Initialize();
    }

    @FXML
    ObservableList<Guest> G = FXCollections.observableArrayList();

    @FXML
    private TableView<Guest> TableGuests;

    void Initialize()
    {
        RoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        City.setCellValueFactory(new PropertyValueFactory<>("City"));
        Nationality.setCellValueFactory(new PropertyValueFactory<>("Nationality"));
        Passport.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));
        Phone.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        Days.setCellValueFactory(new PropertyValueFactory<>("numberOfDays"));
        Fees.setCellValueFactory(new PropertyValueFactory<Guest, Double>("Fees"));
        initTable();
    }
    void initTable()
    {
        TableGuests.getItems().clear();
        G.clear();
        G.addAll(service.GetGuests());
        //System.out.println(service.GetGuests());
        TableGuests.setItems(G);
    }
}
