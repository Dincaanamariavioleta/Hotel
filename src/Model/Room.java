package Model;

import java.util.Date;

public class Room {
    private int roomId;
    private String roomType;
    private String roomCapacity;
    private Date checkInDate;
    private Date checkOutDate;
    private boolean isEmpty;

    public Room(String roomType, String roomCapacity, Date checkInDate, Date checkOutDate, boolean isEmpty)
    {
        this.roomType = roomType;
        this.roomCapacity = roomCapacity;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isEmpty = isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Room(int roomId, String roomType, String roomCapacity, Date checkInDate, Date checkOutDate, boolean isEmpty) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomCapacity = roomCapacity;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isEmpty = isEmpty;
    }

    public int getRoomId() { return roomId; }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomCapacity(String roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getRoomType() { return roomType; }
    public String getRoomCapacity() { return roomCapacity; }
    public Date getCheckInDate() { return  checkInDate; }
    public Date getCheckOutDate() { return checkOutDate; }
    public boolean getIsEmpty() { return isEmpty; }

}
