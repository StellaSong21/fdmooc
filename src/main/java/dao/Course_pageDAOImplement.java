package dao;

import entity.Course_pageBean;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Course_pageDAOImplement implements Course_pageDAO {
    //增加，url可以为空
    @Override
    public int append(Course_pageBean course_pageBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "INSERT INTO `fdmooc`.`course_page` (cid,`number`,title,content,url) VALUES ('" +
                    course_pageBean.getCid() + "','" + course_pageBean.getNumber() + "','" + course_pageBean.getTitle() + "','" +
                    course_pageBean.getContent() + "', ";
            if (StringUtil.isNotEmpty(course_pageBean.getUrl())) {
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
            DbUtil.closeConnection();
            return -1;
        }
    }

    //删除，传pid
    @Override
    public int delete(String pid) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "DELETE FROM `fdmooc`.`course_page` WHERE pid='" + pid + "'";
            PreparedStatement ppst = conn.prepareStatement(sql);
            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            DbUtil.closeConnection();
            return -1;
        }
    }

    //修改，传bean对象，pid作为条件
    @Override
    public int modify(Course_pageBean course_pageBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "UPDATE `fdmooc`.`course_page` SET ";
            String match = "";
            if (StringUtil.isNotEmpty(course_pageBean.getNumber()))
                match += ", number='" + course_pageBean.getNumber() + "' ";
            if (StringUtil.isNotEmpty(course_pageBean.getTitle()))
                match += ", title='" + course_pageBean.getTitle() + "' ";
            if (StringUtil.isNotEmpty(course_pageBean.getContent()))
                match += ", content='" + course_pageBean.getContent() + "' ";
            if (StringUtil.isNotEmpty(course_pageBean.getUrl()))
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
            DbUtil.closeConnection();
            return -1;
        }
    }

    //查找
    @Override
    public List<Course_pageBean> infoList(Course_pageBean course_pageBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM `fdmooc`.`course_page` ";
            String match = "";
            if (StringUtil.isNotEmpty(course_pageBean.getPid()))
                match += "AND pid='" + course_pageBean.getPid() + "' ";
            if (StringUtil.isNotEmpty(course_pageBean.getCid()))
                match += "AND cid='" + course_pageBean.getCid() + "' ";
            if (StringUtil.isNotEmpty(course_pageBean.getNumber()))
                match += "AND number='" + course_pageBean.getNumber() + "' ";
            if (StringUtil.isNotEmpty(course_pageBean.getTitle()))
                match += "AND title='" + course_pageBean.getTitle() + "' ";
            if (StringUtil.isNotEmpty(course_pageBean.getContent()))
                match += "AND content='" + course_pageBean.getContent() + "' ";
            if (StringUtil.isNotEmpty(course_pageBean.getUrl()))
                match += "AND url='" + course_pageBean.getUrl() + "' ";

            if (!match.isEmpty())
                sql += "WHERE " + match.substring(3);

            PreparedStatement ppst = conn.prepareStatement(sql);
            ResultSet re = ppst.executeQuery();
            DbUtil.closeConnection();
            List<Course_pageBean> result = new ArrayList<>();
            while (re.next()) {
                Course_pageBean c = new Course_pageBean();
                c.setPid(re.getString("pid"));
                c.setCid(re.getString("cid"));
                c.setNumber(re.getString("number"));
                c.setTitle(re.getString("title"));
                c.setContent(re.getString("content"));
                c.setUrl(re.getString("url"));
                result.add(c);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            DbUtil.closeConnection();
            return null;
        }

    }
}
