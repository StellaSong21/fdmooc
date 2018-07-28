package dao;

import entity.Discussion_boardBean;

import java.util.List;
import java.util.Map;

public interface Discussion_boardDAO {
    int append(Discussion_boardBean discussion_boardBean);

    int delete(String did);

    int modify(Discussion_boardBean discussion_boardBean);

    List<Map<String, String>> infoList(Discussion_boardBean discussion_boardBean);
}
