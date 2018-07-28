package dao;

import entity.Course_pageBean;
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
    public int append(Course_pageBean course_pageBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`course_page` (cid,`number`,title,content,url) VALUES ('" +
                    course_pageBean.getCid() + "','" + course_pageBean.getNumber() + "','" + course_pageBean.getTitle() + "','" +
                    course_pageBean.getContent() + "', ";
            if (course_pageBean.getUrl().isEmpty()) {
                sql += null + ")";
            } else {
                sql += "'" + course_pageBean.getUrl() + "')";
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
    public int modify(Course_pageBean course_pageBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "UPDATE `fdmooc`.`course_page` SET ";
            String match = "";
            if (!course_pageBean.getCid().isEmpty())
                match += ", cid='" + course_pageBean.getCid() + "' ";
            if (!course_pageBean.getNumber().isEmpty())
                match += ", number='" + course_pageBean.getNumber() + "' ";
            if (!course_pageBean.getTitle().isEmpty())
                match += ", title='" + course_pageBean.getTitle() + "' ";
            if (!course_pageBean.getContent().isEmpty())
                match += ", content='" + course_pageBean.getContent() + "' ";
            if (!course_pageBean.getUrl().isEmpty())
                match += ", url='" + course_pageBean.getUrl() + "' ";

            if (!match.isEmpty()) {
                sql += match.substring(1);
            }

            sql += "WHERE pid='" + course_pageBean.getPid() + "'";

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
    public List<Map<String, String>> infoList(Course_pageBean course_pageBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`course_page` ";
            String match = "";
            if (!course_pageBean.getPid().isEmpty())
                match += "AND pid='" + course_pageBean.getPid() + "' ";
            if (!course_pageBean.getCid().isEmpty())
                match += "AND cid='" + course_pageBean.getCid() + "' ";
            if (!course_pageBean.getNumber().isEmpty())
                match += "AND number='" + course_pageBean.getNumber() + "' ";
            if (!course_pageBean.getTitle().isEmpty())
                match += "AND title='" + course_pageBean.getTitle() + "' ";
            if (!course_pageBean.getContent().isEmpty())
                match += "AND content='" + course_pageBean.getContent() + "' ";
            if (!course_pageBean.getUrl().isEmpty())
                match += "AND url='" + course_pageBean.getUrl() + "' ";

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
