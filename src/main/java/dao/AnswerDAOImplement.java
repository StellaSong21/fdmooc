package dao;

import entity.AnswerBean;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerDAOImplement implements AnswerDAO {

    @Override
    public int append(AnswerBean answerBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`answer` (uid,hid,content,grade) VALUES (" +
                    answerBean.getUid() + "," + answerBean.getHid() + ",'" + answerBean.getContent() + "',";
            if (StringUtil.isNotEmpty(answerBean.getGrade())) {
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
            if (StringUtil.isNotEmpty(uid)) {
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

    @Override
    public int modify(AnswerBean answerBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "UPDATE `fdmooc`.`answer` ";
            String match = "";
            if (StringUtil.isNotEmpty(answerBean.getContent()))
                match += ", content='" + answerBean.getContent() + "' ";
            if (StringUtil.isNotEmpty(answerBean.getGrade()))
                match += ", grade='" + answerBean.getGrade() + "' ";

            if (!match.isEmpty())
                sql += "SET " + match.substring(1);
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

    @Override
    public List<Map<String, String>> infoList(AnswerBean answerBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`answer` ";
            String match = "";
            if (StringUtil.isNotEmpty(answerBean.getUid()))
                match += "AND uid='" + answerBean.getUid() + "' ";
            if (StringUtil.isNotEmpty(answerBean.getHid()))
                match += "AND hid='" + answerBean.getHid() + "' ";
            if (StringUtil.isNotEmpty(answerBean.getContent()))
                match += "AND content='" + answerBean.getContent() + "' ";
            if (StringUtil.isNotEmpty(answerBean.getGrade()))
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
