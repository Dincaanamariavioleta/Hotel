package Controller;

import Model.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Rooms {

    @FXML
    private TableColumn<?, ?> ROOMCAPACITY;

    @FXML
    private TableColumn<?, ?> CHECKOUTDATE;

    @FXML
    private TableColumn<?, ?> ROOMTYPE;

    @FXML
    private TableColumn<?, ?> CHECKINDATE;

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> ISAVAILABLE;

    private Service service;

    public void setService(Service S)
    {
        service = S;
        Initialize();
    }

    @FXML
    ObservableList<Room> Rommi = FXCollections.observableArrayList();

    @FXML
    private TableView<Room> TableRooms;

    void Initialize()
    {
        ID.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        ROOMTYPE.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        ROOMCAPACITY.setCellValueFactory(new PropertyValueFactory<>("roomCapacity"));
        CHECKINDATE.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        CHECKOUTDATE.setCellValueFactory(new PropertyValueFactory<>("checkOutDate"));
        ISAVAILABLE.setCellValueFactory(new PropertyValueFactory<>("isEmpty"));

        initTableRooms();
    }
    void initTableRooms()
    {
        TableRooms.getItems().clear();
        Rommi.clear();
        Rommi.addAll(service.GetRooms());
        TableRooms.setItems(Rommi);
    }

}

