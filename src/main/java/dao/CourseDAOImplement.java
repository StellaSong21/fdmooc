package dao;

import entity.CourseBean;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDAOImplement implements CourseDAO {

    @Override
    public int append(CourseBean courseBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "INSERT  INTO `fdmooc`.`course` (title, teacher_id, pic_url, content) VALUES (?, ?, ?, ?)";
            PreparedStatement ppst = conn.prepareStatement(sql);
            ppst.setString(1, courseBean.getTitle());
            ppst.setString(2, courseBean.getTeacher_uid());
            ppst.setString(3, courseBean.getPic_url());
            ppst.setString(4, courseBean.getContent());

            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            DbUtil.closeConnection();
            return -1;
        }
    }

    @Override
    public int delete(String cid) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "DELETE FROM `fdmooc`.`course` WHERE cid='" + cid + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            int re = ps.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            DbUtil.closeConnection();
            return -1;
        }
    }

    @Override
    public int modify(CourseBean courseBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "UPDATE `fdmooc`.`course` SET ";
            String match = "";
            if (StringUtil.isNotEmpty(courseBean.getTitle()))
                match += ", title='" + courseBean.getTitle() + "' ";
            if (StringUtil.isNotEmpty(courseBean.getTeacher_uid()))
                match += ", teacher_uid='" + courseBean.getTeacher_uid() + "' ";
            if (StringUtil.isNotEmpty(courseBean.getPic_url()))
                match += ", pic_url='" + courseBean.getPic_url() + "' ";
            if (StringUtil.isNotEmpty(courseBean.getContent()))
                match += ", content='" + courseBean.getContent() + "' ";

            if (!match.isEmpty())
                sql += match.substring(1);
            sql += "WHERE cid='" + courseBean.getCid() + "'";

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

    @Override
    public List<Map<String, String>> infoList(CourseBean courseBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM `fdmooc`.`course` ";
            String match = "";
            if (StringUtil.isNotEmpty(courseBean.getCid()))
                match += "AND cid='" + courseBean.getCid() + "' ";
            if (StringUtil.isNotEmpty(courseBean.getTitle()))
                match += "AND title='" + courseBean.getTitle() + "' ";
            if (StringUtil.isNotEmpty(courseBean.getTeacher_uid()))
                match += "AND teacher_id='" + courseBean.getTeacher_uid() + "' ";
            if (StringUtil.isNotEmpty(courseBean.getPic_url()))
                match += "AND pic_url='" + courseBean.getPic_url() + "' ";
            if (StringUtil.isNotEmpty(courseBean.getContent()))
                match += "AND content='" + courseBean.getContent() + "' ";

            if (!match.isEmpty())
                sql += "WHERE " + match.substring(3);

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("cid", re.getString("cid"));
                map.put("title", re.getString("title"));
                map.put("teacher_id", re.getString("teacher_id"));
                map.put("pic_url", re.getString("pic_url"));
                map.put("content", re.getString("content"));
                result.add(map);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            DbUtil.closeConnection();
            return null;
        }
    }

    public List<Map<String, String>> infoList(String title, String content, String name, String c) {
        Connection conn = DbUtil.getConnection();
        try {
            ResultSet re = null;
            if (StringUtil.isNotEmpty(name)) {
                String sql = "select cid, title, pic_url, content, user.nickname from user,course where (user.uid = course.teacher_id) and (user.nickname like \"%" + name + "%\" or user.username like \"%" + name + "%\"";

                if (StringUtil.isNotEmpty(title))
                    sql += "or course.title like \"%" + title + "%\" ";
                if (StringUtil.isNotEmpty(content))
                    sql += "or content like \"%" + content + "%\" ";

                sql += ") group by cid order by cid " + c + ";";
                System.out.println(sql);
                re = conn.prepareStatement(sql).executeQuery();
            } else {
                String sql = "select cid, title, pic_url, content, user.nickname from user,course ";
                String match = "";
                if (StringUtil.isNotEmpty(title))
                    match += "or course.title like \"%" + title + "%\" ";
                if (StringUtil.isNotEmpty(content))
                    match += "or content like \"%" + content + "%\" ";
                if (match.equals(""))
                    sql += " group by cid " + c + ";";
                else
                    sql += " where " + match.substring(2) + " group by cid order by cid " + c + ";";
                System.out.println(sql);
                re = conn.prepareStatement(sql).executeQuery();
            }
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("cid", re.getString("cid"));
                map.put("title", re.getString("title"));
                map.put("nickname", re.getString("nickname"));
                map.put("pic_url", re.getString("pic_url"));
                map.put("content", re.getString("content"));
                result.add(map);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            DbUtil.closeConnection();
            return null;
        }
    }

    public List<Map<String, String>> infoList(String uid) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "select course.title, course.cid from course, course_table where course.cid=course_table.cid and course_table.uid=" + uid + " group by course.cid;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("cid", re.getString("cid"));
                map.put("title", re.getString("title"));
                result.add(map);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            DbUtil.closeConnection();
            return null;
        }
    }

    @Override
    public List<Map<String, String>> infoListHot(String title, String content, String name, String c) {
        Connection conn = DbUtil.getConnection();
        try {
            ResultSet re = null;
            if (StringUtil.isNotEmpty(name)) {
                String sql = "select course.cid, title, pic_url, content, user.nickname from user, (course left join course_table on course.cid=course_table.cid)" +
                        " where (user.uid = course.teacher_id) and (user.nickname like \"%%\" or user.username like \"%%\"";

                if (StringUtil.isNotEmpty(title))
                    sql += "or course.title like \"%" + title + "%\" ";
                if (StringUtil.isNotEmpty(content))
                    sql += "or content like \"%" + content + "%\" ";
                sql += ") group by course.cid order by count(course_table.uid) " + c + ";";
                System.out.println(sql);
                re = conn.prepareStatement(sql).executeQuery();
            } else {
                String sql = "select course.cid, title, pic_url, content, user.nickname from user, (course left join course_table on course.cid=course_table.cid) ";
                String match = "";
                if (StringUtil.isNotEmpty(title))
                    match += "or course.title like \"%" + title + "%\" ";
                if (StringUtil.isNotEmpty(content))
                    match += "or content like \"%" + content + "%\" ";
                if (match.equals(""))
                    sql += " group by course.cid order by count(course_table.uid) " + c + ";";
                else
                    sql += " where " + match.substring(2) + " group by course.cid order by count(course_table.uid) " + c + ";";
                re = conn.prepareStatement(sql).executeQuery();
            }
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("cid", re.getString("cid"));
                map.put("title", re.getString("title"));
                map.put("nickname", re.getString("nickname"));
                map.put("pic_url", re.getString("pic_url"));
                map.put("content", re.getString("content"));
                result.add(map);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            DbUtil.closeConnection();
            return null;
        }

    }
}
