package dao;

import entity.discussionBoardBean;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discussion_boardDAOImplement implements Discussion_boardDAO {
    @Override
    public int append(discussionBoardBean discussionBoardBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`discussion_board` (content,`time`,uid) VALUES (?, ?, ?)";
            PreparedStatement ppst = conn.prepareStatement(sql);
            ppst.setString(1, discussionBoardBean.getContent());
            ppst.setString(2, discussionBoardBean.getTime());
            ppst.setString(3, discussionBoardBean.getUid());

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
    public int modify(discussionBoardBean discussionBoardBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "UPDATE `fdmooc`.`discussion_board` SET ";
            String match = "";
            if (!discussionBoardBean.getContent().isEmpty())
                match += ", content='" + discussionBoardBean.getContent() + "' ";
            if (!discussionBoardBean.getTime().isEmpty())
                match += ", time='" + discussionBoardBean.getTime() + "' ";
            if (!discussionBoardBean.getUid().isEmpty())
                match += ", uid='" + discussionBoardBean.getUid() + "' ";

            if (!match.isEmpty())
                sql += match.substring(1);

            sql += "WHERE did='" + discussionBoardBean.getDid() + "'";

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
    public List<Map<String, String>> infoList(discussionBoardBean discussionBoardBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`discussion_board` ";
            String match = "";
            if (!discussionBoardBean.getDid().isEmpty())
                match += "AND did='" + discussionBoardBean.getDid() + "' ";
            if (!discussionBoardBean.getContent().isEmpty())
                match += "AND content='" + discussionBoardBean.getContent() + "' ";
            if (!discussionBoardBean.getTime().isEmpty())
                match += "AND time='" + discussionBoardBean.getTime() + "' ";
            if (!discussionBoardBean.getUid().isEmpty())
                match += "AND uid='" + discussionBoardBean.getUid() + "' ";

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
