package project.dao;

import project.models.UserModel;

public interface IUserDao {
    UserModel findByUserName(String username);
}
