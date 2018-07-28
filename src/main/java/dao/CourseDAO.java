package dao;

import entity.CourseBean;

import java.util.List;
import java.util.Map;

public interface CourseDAO {
    int append(CourseBean courseBean);

    int delete(String cid);

    int modify(CourseBean courseBean);

    List<Map<String, String>> infoList(CourseBean courseBean);
}
