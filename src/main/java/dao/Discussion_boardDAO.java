package dao;

import entity.discussionBoardBean;

import java.util.List;
import java.util.Map;

public interface Discussion_boardDAO {
    int append(discussionBoardBean discussionBoardBean);

    int delete(String did);

    int modify(discussionBoardBean discussionBoardBean);

    List<Map<String, String>> infoList(discussionBoardBean discussionBoardBean);
}
