package dao;

import entity.HomeworkBean;

import java.util.List;
import java.util.Map;

public interface HomeworkDAO {
    int append(HomeworkBean homeworkBean);

    int delete(String hid);

    int modify(HomeworkBean homeworkBean);

    List<Map<String, String>> infoList(HomeworkBean homeworkBean);
}
