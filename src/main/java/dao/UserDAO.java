package dao;

import entity.UserBean;

import java.util.List;
import java.util.Map;

public interface UserDAO {
    int append(UserBean userBean);

    int delete(String uid);

    int modify(UserBean userBean);

    List<Map<String, String>> infoList(UserBean userBean);
}