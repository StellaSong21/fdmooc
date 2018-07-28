package dao;

import entity.coursePageBean;

import java.util.List;
import java.util.Map;

public interface Course_pageDAO {
    int append(coursePageBean coursePageBean);

    int delete(String pid);

    int modify(coursePageBean coursePageBean);

    List<Map<String, String>> infoList(coursePageBean coursePageBean);
}
