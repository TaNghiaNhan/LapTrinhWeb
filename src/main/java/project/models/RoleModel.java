package project.models;

import java.io.Serializable;

public class RoleModel {
    private static final long serialVersionUID = 1L;
    private int roled;
    private String Rolename;

    public RoleModel() {
        super();
    }

    public int getRoled() {
        return roled;
    }

    public void setRoled(int roled) {
        this.roled = roled;
    }

    public String getRolename() {
        return Rolename;
    }

    public void setRolename(String rolename) {
        Rolename = rolename;
    }

    @Override
    public String toString() {
        return "RoleModel [roled=" + roled + ", Rolename=" + Rolename + "]";
    }
}
