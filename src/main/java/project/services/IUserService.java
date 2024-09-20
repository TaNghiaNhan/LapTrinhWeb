package project.services;

import project.models.UserModel;

public interface IUserService {
    UserModel findByUserName(String username);
    UserModel login(String username, String password);
}
