package dao;

import entity.Course_tableBean;

import java.util.List;
import java.util.Map;

public interface Course_tableDAO {
    int append(Course_tableBean course_tableBean);

    int delete(Course_tableBean course_tableBean);

    List<Map<String, String>> infoList(Course_tableBean course_tableBean);
}
