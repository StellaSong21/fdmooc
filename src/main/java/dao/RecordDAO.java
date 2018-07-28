package dao;

import entity.RecordBean;

import java.util.List;
import java.util.Map;

public interface RecordDAO {
    int append(RecordBean recordBean);

    int delete(RecordBean recordBean);

    List<Map<String, String>> infoList(RecordBean recordBean);
}
