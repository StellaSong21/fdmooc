package dao;

import entity.UserBean;

import java.util.List;
import java.util.Map;

public interface UserDAO {
    int append(UserBean user);

    int delete(int id);

    int modify(UserBean user);

    List<Map<String, String>> infoList(UserBean user);
}