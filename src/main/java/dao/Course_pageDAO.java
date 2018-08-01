package dao;

import entity.Course_pageBean;

import java.util.List;

public interface Course_pageDAO {
    int append(Course_pageBean Course_pageBean);

    int delete(String pid);

    int modify(Course_pageBean Course_pageBean);

    List<Course_pageBean> infoList(Course_pageBean Course_pageBean);
}
