package project.dao;

import project.models.UserModel;

import java.sql.SQLException;

public interface IUserDao {
    UserModel findByUserName(String username);
    UserModel findByEmail(String email);
}
