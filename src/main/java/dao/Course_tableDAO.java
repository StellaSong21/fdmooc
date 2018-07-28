package dao;

import entity.courseTableBean;

import java.util.List;
import java.util.Map;

public interface Course_tableDAO {
    int append(courseTableBean courseTableBean);

    int delete(courseTableBean courseTableBean);

    List<Map<String, String>> infoList(courseTableBean courseTableBean);
}
