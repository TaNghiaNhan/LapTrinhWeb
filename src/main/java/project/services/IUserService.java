package project.services;

import project.models.UserModel;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    UserModel findByUserName(String username);
    UserModel login(String username, String password);
    UserModel findByEmail(String email);
    boolean register(String username, String password, String email);
    void Insert(UserModel user) throws Exception;
    List<UserModel> FindAll() throws ClassNotFoundException;
}
