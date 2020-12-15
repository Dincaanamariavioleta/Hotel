package Controller;
import Model.Guest;
import Model.Room;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class CheckIn {

    @FXML
    private TextField EmailId;

    @FXML
    private TextField NameId;

    @FXML
    private TextField CardNumberId;

    @FXML
    private TextField RoomId;

    @FXML
    private CheckBox Normal;

    @FXML
    private CheckBox Double;

    @FXML
    private TextField CVCCode;

    @FXML
    private CheckBox Simple;

    @FXML
    private CheckBox Triple;

    @FXML
    private TextField PhoneID;

    @FXML
    private CheckBox Economy;

    @FXML
    private DatePicker CheckOut;

    @FXML
    private TextField CityId;

    @FXML
    private TextField PassportNo;

    @FXML
    private TextField AdressId;

    @FXML
    private TextField NationalityId;

    @FXML
    private DatePicker CheckIn;

    @FXML
    private CheckBox Vip;

    private String Roomtype = null;
    private String Roomcapacity = null;

    private Service service;
    public void setService(Service S)
    {
        service = S;
    }

    @FXML
    void Clear() {
        NameId.clear();
        PhoneID.clear();
        EmailId.clear();
        AdressId.clear();
        CityId.clear();
        NationalityId.clear();
        PassportNo.clear();

        CardNumberId.clear();
        CVCCode.clear();

        //checkBoxList.clear();
        CheckIn.setValue(null);
        CheckOut.setValue(null);
        RoomId.clear();

    }

    @FXML
    void Search() {
        ArrayList<Room> rooms = new ArrayList<>();
        if (Economy.isSelected()) Roomtype = "Economy";
        else if(Normal.isSelected()) Roomtype = "Normal";
        else if(Vip.isSelected()) Roomtype = "VIP";

        if (Simple.isSelected()) Roomcapacity= "Single";
        else if(Double.isSelected()) Roomcapacity = "Double";
        else if(Triple.isSelected()) Roomcapacity = "Triple";

        try {
            LocalDate checkindate = CheckIn.getValue();
            LocalDate checkout = CheckOut.getValue();
            Date d = Date.from(checkindate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            for (Room r : service.GetRooms())

                if (r.getIsEmpty() == true && r.getRoomCapacity().equals(Roomcapacity) && r.getRoomType().equals(Roomtype) && r.getCheckOutDate().compareTo(d) < 0)
                    rooms.add(r);

            if (rooms.isEmpty() == true) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Try again!");

            } else {
                Random rand = new Random();
                Room randomElement = rooms.get(rand.nextInt(rooms.size()));
                RoomId.setText(String.valueOf(randomElement.getRoomId()));
                randomElement.setCheckInDate(d);
                randomElement.setCheckOutDate(Date.from(checkout.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
        }
        catch(Exception e)
        {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Try again!");
        }
    }

    @FXML
    void Submit() {
        try{
            String Name = NameId.getText();
            String Phone =  PhoneID.getText();
            String Email = EmailId.getText();
            String Adress = AdressId.getText();
            String City = CityId.getText();
            String Nationality = NationalityId.getText();
            String PassNo = PassportNo.getText();
            String CardNumber = CardNumberId.getText();
            String Code = CVCCode.getText();

            int id = Integer.parseInt(RoomId.getText());
            Room r = service.GetRoomByID(id);
            service.changeStatus(id);

            int Days = (int) Math.abs(r.getCheckOutDate().getTime() - r.getCheckInDate().getTime());

            Guest g = new Guest(id, Name, Email, Adress, City, Nationality, PassNo, Phone, CardNumber, Code,Days, 0);
            service.addGuest(g);

            Alert e = new Alert(Alert.AlertType.CONFIRMATION);
            e.setContentText("Guest added!");
            e.show();

        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Try again");
            a.show();
        }
}}
