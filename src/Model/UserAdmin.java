package Model;

public class UserAdmin {
    private int userId;
    private String userName;
    private String userPass;
    private boolean isAdmin;

    public UserAdmin(String userName, String userPass, boolean isAdmin)
    {
        this.userName = userName;
        this.userPass = userPass;
        this.isAdmin = isAdmin;
    }

    public UserAdmin(int userId, String userName, String userPass, boolean isAdmin) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.isAdmin = isAdmin;
    }

    public UserAdmin(String userName, String userPass)
    {
        this.userName = userName;
        this.userPass = userPass;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() { return userName; }
    public String getUserPass() { return userPass; }

    public boolean getIsAdmin() {
        return isAdmin;
    }
}
