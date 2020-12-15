package Depo;

import Model.UserAdmin;

import java.sql.*;

public class UserAdminDepo extends AbstractDepo {

    public UserAdminDepo(Connection c) {
        super(c);
    }

    @Override
    public void Read() throws SQLException {
        Statement st = c.createStatement();
        ResultSet res = st.executeQuery("Select * from UserAdmin");
        while(res.next())
        {
            UserAdmin userAdmin = new UserAdmin(res.getInt("userId"), res.getString("userName"), res.getString("userPass"), res.getBoolean("isAdmin"));
            Add(userAdmin);
        }
    }
    public void AddUser(UserAdmin d) throws SQLException {
        PreparedStatement st = c.prepareStatement("Insert into UserAdmin values(default, ?, ?, ?)");
        st.setString(1, d.getUserName());
        st.setString(2, d.getUserPass());
        st.setBoolean(3, d.getIsAdmin());
        st.executeUpdate();
        st.close();
        Add(d);
    }
    public void Delete(UserAdmin a) throws SQLException {
        String name = a.getUserName();
        Statement st = c.createStatement();
        String sql = "DELETE FROM UserAdmin WHERE userName = '" + name + "'";
        st.executeUpdate(sql);
        st.close();
        Deletee(a);
    }
}
