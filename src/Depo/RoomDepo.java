package Depo;

import Model.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomDepo extends AbstractDepo{

    public RoomDepo(Connection c) {
        super(c);
    }

    @Override
    public void Read() throws SQLException {
        Statement st = c.createStatement();
        ResultSet res = st.executeQuery("Select * from Room order by roomId");
        while(res.next())
        {
            Room room = new Room(res.getInt("roomId"), res.getString("roomType"), res.getString("roomCapacity"), res.getDate("checkInDate"), res.getDate("checkOutDate"), res.getBoolean("isEmpty"));
            Add(room);
        }
    }
    public void roomCheckOut(int n) throws SQLException {
        Statement st = c.createStatement();
        st.executeUpdate("update Room set isEmpty = true where roomId = " + n);
        st.close();
    }
    public void changeStatus(int n) throws SQLException {
        Statement st = c.createStatement();
        st.executeUpdate("update Room set isEmpty = false where roomId = " + n);
        st.close();
    }
}
