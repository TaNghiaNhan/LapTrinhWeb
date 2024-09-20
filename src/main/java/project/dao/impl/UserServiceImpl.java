package project.dao.impl;

import project.dao.IUserDao;
import project.models.UserModel;
import project.services.IUserService;

public class UserServiceImpl implements IUserService{
    IUserDao userDao = new UserDaoImpl();

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

    public static void main(String[] args) {
        IUserService service = new UserServiceImpl();
        UserModel user = service.login("nhan", "123");
        System.out.println(user);
    }
}
