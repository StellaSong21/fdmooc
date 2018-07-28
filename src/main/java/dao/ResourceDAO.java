package dao;

import entity.ResourceBean;

import java.util.List;
import java.util.Map;

public interface ResourceDAO {
    int append(ResourceBean resourceBean);

    int delete(ResourceBean resourceBean);

    int modify(ResourceBean resourceBean);

    List<Map<String, String>> infoList(ResourceBean resourceBean);
}
