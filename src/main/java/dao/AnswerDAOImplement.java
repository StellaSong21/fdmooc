package dao;

import entity.AnswerBean;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerDAOImplement implements AnswerDAO {
    //添加，传入AnswerBean对象，grade可以为空
    @Override
    public int append(AnswerBean answerBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`answer` (uid,hid,content,grade) VALUES (" +
                    answerBean.getUid() + "," + answerBean.getHid() + ",'" + answerBean.getContent() + "',";
            if (!answerBean.getGrade().isEmpty()) {
                sql += "" + answerBean.getGrade() + ")";
            } else {
                sql += null + ")";
            }
            PreparedStatement ppst = conn.prepareStatement(sql);
            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(String uid, String hid) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "DELETE FROM `fdmooc`.`answer` WHERE hid='" + hid + "'";
            if (!"".equals(uid)) {
                sql += " AND uid='" + uid + "'";
            }
            PreparedStatement ppst = conn.prepareStatement(sql);
            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //修改，传入一个bean对象，搜索条件是 uid 和 hid，更新 content 和 grade，content 和 grade 至少有一项不为空
    @Override
    public int modify(AnswerBean answerBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "UPDATE `fdmooc`.`answer` SET ";
            String match = "";
            if (!answerBean.getContent().isEmpty())
                match += ", content='" + answerBean.getContent() + "' ";
            if (!answerBean.getGrade().isEmpty())
                match += ", grade='" + answerBean.getGrade() + "' ";

            if (!match.isEmpty())
                sql += match.substring(1);
            sql += "WHERE uid='" + answerBean.getUid() + "' AND hid='" + answerBean.getHid() + "'";

            PreparedStatement ppst = conn.prepareStatement(sql);

            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //查找，传入Bean对象，所有项都可以为空
    @Override
    public List<Map<String, String>> infoList(AnswerBean answerBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`answer` ";
            String match = "";
            if (!answerBean.getUid().isEmpty())
                match += "AND uid='" + answerBean.getUid() + "' ";
            if (!answerBean.getHid().isEmpty())
                match += "AND hid='" + answerBean.getHid() + "' ";
            if (!answerBean.getContent().isEmpty())
                match += "AND content='" + answerBean.getContent() + "' ";
            if (!answerBean.getGrade().isEmpty())
                match += "AND grade='" + answerBean.getGrade() + "' ";

            if (!match.isEmpty())
                sql += "WHERE " + match.substring(3);

            PreparedStatement ppst = conn.prepareStatement(sql);
            ResultSet re = ppst.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("uid", re.getString("uid"));
                map.put("hid", re.getString("hid"));
                map.put("content", re.getString("content"));
                map.put("grade", re.getString("grade"));
                result.add(map);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
