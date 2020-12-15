package Controller;

import Depo.GuestDepo;
import Depo.RoomDepo;
import Depo.UserAdminDepo;
import Model.Guest;
import Model.Room;
import Model.UserAdmin;

import java.sql.SQLException;
import java.util.ArrayList;

public class Service {
    private final UserAdminDepo User;
    private final RoomDepo room;
    private final GuestDepo guest;

    public Service(UserAdminDepo user, RoomDepo room, GuestDepo guest) {
        User = user;
        this.room = room;
        this.guest = guest;
    }
    public ArrayList<UserAdmin> GetUsers()
    {
        return User.getList();
    }
    public void DeleteGuest(Guest g) throws SQLException {
        guest.Delete(g);
    }
    public ArrayList<Room> GetRooms() { return room.getList(); }
    public ArrayList<Guest> GetGuests() {return guest.getList();}

    public void addUser(UserAdmin d) throws SQLException {
        User.AddUser(d);
    }
    public Room GetRoomByID(int id)
    {
       return room.findById(id);
    }
    public void addGuest(Guest d) throws SQLException {
        guest.AddGuest(d);
    }
    public void DeleteUser(UserAdmin a) throws SQLException {
        User.Delete(a);
    }
    public void changeStatus(int a) throws SQLException {
        room.changeStatus(a);
    }
    public void roomCheckOut(int n) throws SQLException {
        room.roomCheckOut(n);
        Room r = room.findById(n);
        r.setEmpty(false);
    }
}
