package dao;

import entity.Discussion_boardBean;

import java.util.List;
import java.util.Map;

public interface Discussion_boardDAO {
    int append(Discussion_boardBean Discussion_boardBean);

    int delete(String did);

    int modify(Discussion_boardBean Discussion_boardBean);

    List<Map<String, String>> infoList(Discussion_boardBean Discussion_boardBean);
}
