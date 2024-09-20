package project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import project.config.DBConnectSQLServer;
import project.dao.IUserDao;
import project.models.UserModel;

public class UserDaoImpl implements IUserDao{
    @Override
    public UserModel findByUserName(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            Connection conn = new DBConnectSQLServer().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            UserModel user = new UserModel();
            while(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setRoled(rs.getInt("roled"));
                user.setUsername(rs.getString("username").trim());
                user.setPassword(rs.getString("password").trim());
                user.setEmail(rs.getString("email").trim());
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            IUserDao userDao = new UserDaoImpl();
            System.out.println(userDao.findByUserName("nhan"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
