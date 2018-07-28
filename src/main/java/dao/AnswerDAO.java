package dao;

import entity.AnswerBean;

import java.util.List;
import java.util.Map;

public interface AnswerDAO {
    int append(AnswerBean answerBean);

    int delete(String uid, String hid);

    int modify(AnswerBean answerBean);

    List<Map<String, String>> infoList(AnswerBean answerBean);
}
