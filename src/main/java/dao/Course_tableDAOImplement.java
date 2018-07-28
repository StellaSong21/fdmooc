package dao;

import entity.courseTableBean;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course_tableDAOImplement implements Course_tableDAO {
    @Override
    public int append(courseTableBean courseTableBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`course_table` (cid,uid) VALUES ('" + courseTableBean.getCid() + "','" + courseTableBean.getUid() + "')";
            PreparedStatement ppst = conn.prepareStatement(sql);
            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //uid可以为空字符串
    @Override
    public int delete(courseTableBean courseTableBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "DELETE FROM `fdmooc`.`course_table` WHERE cid='" + courseTableBean.getCid() + "'";
            if (!courseTableBean.getUid().isEmpty()) {
                sql += " AND uid='" + courseTableBean.getUid() + "'";
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
    public List<Map<String, String>> infoList(courseTableBean courseTableBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`course_table` ";
            String match = "";
            if (!courseTableBean.getCid().isEmpty())
                match += "AND cid='" + courseTableBean.getCid() + "' ";
            if (!courseTableBean.getUid().isEmpty())
                match += "AND uid='" + courseTableBean.getUid() + "' ";

            if (!match.isEmpty())
                sql += "WHERE " + match.substring(3);

            PreparedStatement ppst = conn.prepareStatement(sql);
            ResultSet re = ppst.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("cid", re.getString("cid"));
                map.put("uid", re.getString("uid"));
                result.add(map);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
