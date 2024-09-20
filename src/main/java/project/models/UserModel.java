package project.models;

public class UserModel {

    private int id;
    private int roled;
    private String username;
    private String password;
    private String email;

    public UserModel() {}

    public int getId() { return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() { return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoled() { return roled;}

    public void setRoled(int roled) {
        this.roled = roled;
    }

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return email;}

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", roled=" + roled + ", username=" + username + ", password=" + password + ", email=" + email + "]";
    }
}
