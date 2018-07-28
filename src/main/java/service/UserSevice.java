package service;

import entity.UserBean;

import java.util.Map;

public abstract class UserSevice {
    public abstract int hasUsername();

    public abstract Map<String, String> userInfo(String uid);

    public abstract int login(UserBean user);

    public abstract int register(UserBean user);

}
