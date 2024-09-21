package project.dao.impl;

import project.config.DBConnectSQLServer;
import project.dao.IUserDao;
import project.models.UserModel;
import project.services.IUserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService{
    IUserDao userDao = new UserDaoImpl();
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public UserModel findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.findByUserName(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public UserModel findByEmail(String email) { return userDao.findByEmail(email); }

    @Override
    public boolean register(String username, String password, String email) {
        UserModel user1 = this.findByUserName(username);
        UserModel user2 = this.findByEmail(email);
        if (user1 == null && user2 == null) {
            String sql = "INSERT INTO users (username, password, email)\n" +
                    "VALUES (?, ?, ?);\n";
            try {
                Connection conn = new DBConnectSQLServer().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);
                ResultSet rs = ps.executeQuery();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void Insert(UserModel user) throws Exception {
        String insertQuery = "INSERT INTO users(username, password, email) VALUES ( ?, ?, ?)";

        Connection conn = new DBConnectSQLServer().getConnection();

        try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
        }
    }

    @Override
    public List<UserModel> FindAll() throws ClassNotFoundException {
        String sql = "SELECT * FROM users ";
        try {
            List<UserModel> list = new ArrayList<>();
            Connection conn = new DBConnectSQLServer().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")));
            }
            return list;
        } catch (Exception e) {e.printStackTrace(); }
        return null;
    }

    public static void main(String[] args) throws Exception {
        List<UserModel> list = new UserServiceImpl().FindAll();
        for(UserModel x : list){
            System.out.println(x);
        }
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.findByUserName("manh"));
        System.out.println(userService.findByEmail("nhan@gmail.com"));
    }
}
