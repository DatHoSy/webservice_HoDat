package atm;

public class Account {
    private String user;
    private String pass;
    public Account(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return pass;
    }

}
