package dao;

import entity.Discussion_boardBean;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discussion_boardDAOImplement implements Discussion_boardDAO {
    @Override
    public int append(Discussion_boardBean discussion_boardBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`discussion_board` (content,`time`,uid) VALUES (?, ?, ?)";
            PreparedStatement ppst = conn.prepareStatement(sql);
            ppst.setString(1, discussion_boardBean.getContent());
            ppst.setString(2, discussion_boardBean.getTime());
            ppst.setString(3, discussion_boardBean.getUid());

            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(String did) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "DELETE FROM `fdmooc`.`discussion_board` WHERE did='" + did + "'";
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
    public int modify(Discussion_boardBean discussion_boardBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "UPDATE `fdmooc`.`discussion_board` SET ";
            String match = "";
            if (StringUtil.isNotEmpty(discussion_boardBean.getContent()))
                match += ", content='" + discussion_boardBean.getContent() + "' ";
            if (StringUtil.isNotEmpty(discussion_boardBean.getTime()))
                match += ", time='" + discussion_boardBean.getTime() + "' ";
            if (StringUtil.isNotEmpty(discussion_boardBean.getUid()))
                match += ", uid='" + discussion_boardBean.getUid() + "' ";

            if (!match.isEmpty())
                sql += match.substring(1);

            sql += "WHERE did='" + discussion_boardBean.getDid() + "'";

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
    public List<Map<String, String>> infoList(Discussion_boardBean discussion_boardBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`discussion_board` ";
            String match = "";
            if (StringUtil.isNotEmpty(discussion_boardBean.getDid()))
                match += "AND did='" + discussion_boardBean.getDid() + "' ";
            if (StringUtil.isNotEmpty(discussion_boardBean.getContent()))
                match += "AND content='" + discussion_boardBean.getContent() + "' ";
            if (StringUtil.isNotEmpty(discussion_boardBean.getTime()))
                match += "AND time='" + discussion_boardBean.getTime() + "' ";
            if (StringUtil.isNotEmpty(discussion_boardBean.getUid()))
                match += "AND uid='" + discussion_boardBean.getUid() + "' ";

            if (!match.isEmpty())
                sql += "WHERE " + match.substring(3);

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("did", re.getString("did"));
                map.put("content", re.getString("content"));
                map.put("time", re.getString("time"));
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
