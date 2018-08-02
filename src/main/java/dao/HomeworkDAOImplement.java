package dao;

import entity.HomeworkBean;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeworkDAOImplement implements HomeworkDAO {
    @Override
    public int append(HomeworkBean homeworkBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "INSERT INTO `fdmooc`.`homework` (start_time,title,content,end_time,cid) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ppst = conn.prepareStatement(sql);

            ppst.setString(1, homeworkBean.getStart_time());
            ppst.setString(2, homeworkBean.getTitle());
            ppst.setString(3, homeworkBean.getContent());
            ppst.setString(4, homeworkBean.getEnd_time());
            ppst.setString(5, homeworkBean.getCid());

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
    public int delete(String hid) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "DELETE FROM `fdmooc`.`homework` WHERE hid='" + hid + "'";
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
    public int modify(HomeworkBean homeworkBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "UPDATE `fdmooc`.`homework` SET ";
            String match = "";

            if (StringUtil.isNotEmpty(homeworkBean.getStart_time()))
                match += ", start_time='" + homeworkBean.getStart_time() + "' ";
            if (StringUtil.isNotEmpty(homeworkBean.getTitle()))
                match += ", title='" + homeworkBean.getTitle() + "' ";
            if (StringUtil.isNotEmpty(homeworkBean.getContent()))
                match += ", content='" + homeworkBean.getContent() + "' ";
            if (StringUtil.isNotEmpty(homeworkBean.getEnd_time()))
                match += ", end_time='" + homeworkBean.getEnd_time() + "' ";

            if (!match.isEmpty())
                sql += match.substring(1);

            sql += "WHERE hid='" + homeworkBean.getHid() + "'";

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
    public List<Map<String, String>> infoList(HomeworkBean homeworkBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "SELECT * FROM `fdmooc`.`homework` ";
            String match = "";
            if (StringUtil.isNotEmpty(homeworkBean.getHid()))
                match += "AND hid='" + homeworkBean.getHid() + "' ";
            if (StringUtil.isNotEmpty(homeworkBean.getStart_time()))
                match += "AND start_time='" + homeworkBean.getStart_time() + "' ";
            if (StringUtil.isNotEmpty(homeworkBean.getTitle()))
                match += "AND title='" + homeworkBean.getTitle() + "' ";
            if (StringUtil.isNotEmpty(homeworkBean.getContent()))
                match += "AND content='" + homeworkBean.getContent() + "' ";
            if (StringUtil.isNotEmpty(homeworkBean.getEnd_time()))
                match += "AND end_time='" + homeworkBean.getEnd_time() + "' ";
            if (StringUtil.isNotEmpty(homeworkBean.getCid()))
                match += "AND cid='" + homeworkBean.getCid() + "' ";

            if (!match.isEmpty())
                sql += " WHERE " + match.substring(3);

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("hid", re.getString("hid"));
                map.put("start_time", re.getString("start_time"));
                map.put("title", re.getString("title"));
                map.put("content", re.getString("content"));
                map.put("end_time", re.getString("end_time"));
                map.put("cid", re.getString("cid"));
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
