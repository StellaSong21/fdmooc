package service;

import com.google.gson.JsonObject;

public abstract class UserSevice {

    public abstract JsonObject userInfo();

    public abstract int login();

    public abstract int register();

    public abstract boolean hasUsername(String username);

    public abstract int sendVerifyCode();

}
