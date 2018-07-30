package dao;

import entity.Course_tableBean;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course_tableDAOImplement implements Course_tableDAO {
    @Override
    public int append(Course_tableBean course_tableBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`course_table` (cid,uid) VALUES ('" + course_tableBean.getCid() + "','" + course_tableBean.getUid() + "')";
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
    public int delete(Course_tableBean course_tableBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "DELETE FROM `fdmooc`.`course_table` WHERE cid='" + course_tableBean.getCid() + "'";
            if (StringUtil.isNotEmpty(course_tableBean.getUid())) {
                sql += " AND uid='" + course_tableBean.getUid() + "'";
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
    public List<Map<String, String>> infoList(Course_tableBean course_tableBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`course_table` ";
            String match = "";
            if (StringUtil.isNotEmpty(course_tableBean.getCid()))
                match += "AND cid='" + course_tableBean.getCid() + "' ";
            if (StringUtil.isNotEmpty(course_tableBean.getUid()))
                match += "AND uid='" + course_tableBean.getUid() + "' ";

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
