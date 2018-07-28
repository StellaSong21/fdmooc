package dao;

import entity.Course_pageBean;

import java.util.List;
import java.util.Map;

public interface Course_pageDAO {
    int append(Course_pageBean course_pageBean);

    int delete(String pid);

    int modify(Course_pageBean course_pageBean);

    List<Map<String, String>> infoList(Course_pageBean course_pageBean);
}
