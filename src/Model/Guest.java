package Model;

public class Guest {
    private int roomId;
    private String Name;
    private String Email;
    private String Address;
    private String City;
    private String Nationality;
    private String passportNumber;
    private String phoneNo;
    private String cardNumber;
    private String cardPass;
    private int numberOfDays;
    private double Fees;

    public Guest(String Name, String Email, String Address, String City, String Nationality, String passportNumber, String phoneNo, String cardNumber, String cardPass, int numberOfDays, double Fees)
    {
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.City = City;
        this.Nationality = Nationality;
        this.passportNumber = passportNumber;
        this.phoneNo = phoneNo;
        this.cardNumber = cardNumber;
        this.cardPass = cardPass;
        this.numberOfDays = numberOfDays;
        this.Fees = Fees;
    }

    public Guest(int roomId, String name, String email, String address, String city, String nationality, String passportNumber, String phoneNo, String cardNumber, String cardPass, int numberOfDays, double fees) {
        this.roomId = roomId;
        Name = name;
        Email = email;
        Address = address;
        City = city;
        Nationality = nationality;
        this.passportNumber = passportNumber;
        this.phoneNo = phoneNo;
        this.cardNumber = cardNumber;
        this.cardPass = cardPass;
        this.numberOfDays = numberOfDays;
        Fees = fees;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardPass() {
        return cardPass;
    }

    public void setCardPass(String cardPass) {
        this.cardPass = cardPass;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getFees() {
        return Fees;
    }

    public void setFees(double fees) {
        Fees = fees;
    }
}
