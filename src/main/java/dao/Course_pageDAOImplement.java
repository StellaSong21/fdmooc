package dao;

import entity.coursePageBean;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course_pageDAOImplement implements Course_pageDAO {
    //增加，url可以为空
    @Override
    public int append(coursePageBean coursePageBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`course_page` (cid,`number`,title,content,url) VALUES ('" +
                    coursePageBean.getCid() + "','" + coursePageBean.getNumber() + "','" + coursePageBean.getTitle() + "','" +
                    coursePageBean.getContent() + "', ";
            if (coursePageBean.getUrl().isEmpty()) {
                sql += null + ")";
            } else {
                sql += "'" + coursePageBean.getUrl() + "')";
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

    //删除，传pid
    @Override
    public int delete(String pid) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "DELETE FROM `fdmooc`.`course_page` WHERE pid='" + pid + "'";
            PreparedStatement ppst = conn.prepareStatement(sql);
            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //修改，传bean对象，pid作为条件
    @Override
    public int modify(coursePageBean coursePageBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "UPDATE `fdmooc`.`course_page` SET ";
            String match = "";
            if (!coursePageBean.getCid().isEmpty())
                match += ", cid='" + coursePageBean.getCid() + "' ";
            if (!coursePageBean.getNumber().isEmpty())
                match += ", number='" + coursePageBean.getNumber() + "' ";
            if (!coursePageBean.getTitle().isEmpty())
                match += ", title='" + coursePageBean.getTitle() + "' ";
            if (!coursePageBean.getContent().isEmpty())
                match += ", content='" + coursePageBean.getContent() + "' ";
            if (!coursePageBean.getUrl().isEmpty())
                match += ", url='" + coursePageBean.getUrl() + "' ";

            if (!match.isEmpty()) {
                sql += match.substring(1);
            }

            sql += "WHERE pid='" + coursePageBean.getPid() + "'";

            PreparedStatement ppst = conn.prepareStatement(sql);
            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //查找
    @Override
    public List<Map<String, String>> infoList(coursePageBean coursePageBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`course_page` ";
            String match = "";
            if (!coursePageBean.getPid().isEmpty())
                match += "AND pid='" + coursePageBean.getPid() + "' ";
            if (!coursePageBean.getCid().isEmpty())
                match += "AND cid='" + coursePageBean.getCid() + "' ";
            if (!coursePageBean.getNumber().isEmpty())
                match += "AND number='" + coursePageBean.getNumber() + "' ";
            if (!coursePageBean.getTitle().isEmpty())
                match += "AND title='" + coursePageBean.getTitle() + "' ";
            if (!coursePageBean.getContent().isEmpty())
                match += "AND content='" + coursePageBean.getContent() + "' ";
            if (!coursePageBean.getUrl().isEmpty())
                match += "AND url='" + coursePageBean.getUrl() + "' ";

            if (!match.isEmpty())
                sql += "WHERE " + match.substring(3);

            PreparedStatement ppst = conn.prepareStatement(sql);
            ResultSet re = ppst.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("pid", re.getString("pid"));
                map.put("cid", re.getString("cid"));
                map.put("number", re.getString("number"));
                map.put("title", re.getString("title"));
                map.put("content", re.getString("content"));
                map.put("url", re.getString("url"));
                result.add(map);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
