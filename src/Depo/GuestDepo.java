package Depo;

import Model.Guest;

import java.sql.*;

public class GuestDepo extends AbstractDepo {

    public GuestDepo(Connection c) {
        super(c);
    }

    @Override
    public void Read() throws SQLException {
        Statement st = c.createStatement();
        ResultSet res =  st.executeQuery("Select * from Guest");
        while(res.next())
        {
            Guest guest = new Guest(res.getInt("roomId"), res.getString("Name"), res.getString("Email"), res.getString("Address"), res.getString("City"), res.getString("Nationality"), res.getString("passportNumber"), res.getString("phoneNo"), res.getString("cardNumber"), res.getString("cardPass"), res.getInt("numberOfDays"), res.getDouble("Fees"));
            Add(guest);
        }
    }
    public void AddGuest(Guest d) throws SQLException {
        String s = "Insert into Guest values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = c.prepareStatement(s);
            st.setInt(1, d.getRoomId());
            st.setString(2, d.getName());
            st.setString(3, d.getEmail());
            st.setString(4, d.getAddress());
            st.setString(5, d.getCity());
            st.setString(6, d.getNationality());
            st.setString(7, d.getPassportNumber());
            st.setString(8, d.getPhoneNo());
            st.setString(9, d.getCardNumber());
            st.setString(10, d.getCardPass());
            st.setInt(11, d.getNumberOfDays());
            st.setDouble(12, d.getFees());
            int i = st.executeUpdate();
            st.close();
            Add(d);
    }
    public void Delete(Guest g) throws SQLException {
        int m = g.getRoomId();
        Statement st = c.createStatement();
        st.executeUpdate("Delete from Guest where roomId = " + m);
        st.close();
    }

}
