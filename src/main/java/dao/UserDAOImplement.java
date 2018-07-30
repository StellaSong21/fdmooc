package dao;

import entity.UserBean;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOImplement implements UserDAO {
    @Override
    public int append(UserBean userBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`user` (username,nickname,password,authority,email) VALUES ('" +
                    userBean.getUsername() + "','" + userBean.getNickname() + "','" + userBean.getPassword() + "','" + userBean.getAuthority()
                    + "','" + userBean.getEmail() + "')";

            PreparedStatement ps = conn.prepareStatement(sql);
            int re = ps.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(String uid) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "DELETE FROM `fdmooc`.`user` WHERE uid='" + uid + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            int re = ps.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int modify(UserBean userBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "UPDATE `fdmooc`.`user` SET ";
            String match = "";
            if (StringUtil.isNotEmpty(userBean.getUsername()))
                match += ", username='" + userBean.getUsername() + "' ";
            if (StringUtil.isNotEmpty(userBean.getNickname()))
                match += ", nickname='" + userBean.getNickname() + "' ";
            if (StringUtil.isNotEmpty(userBean.getPassword()))
                match += ", password='" + userBean.getPassword() + "' ";
            if (StringUtil.isNotEmpty(userBean.getAuthority()))
                match += ", authority='" + userBean.getAuthority() + "' ";
            if (StringUtil.isEmpty(userBean.getEmail()))
                match += ", email='" + userBean.getEmail() + "' ";

            if (!match.isEmpty())
                sql += match.substring(1);
            sql += "WHERE uid='" + userBean.getUid() + "'";

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
    public List<Map<String, String>> infoList(UserBean userBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`user` ";
            String match = "";
            if (StringUtil.isNotEmpty(userBean.getUid()))
                match += "AND uid='" + userBean.getUid() + "' ";
            if (StringUtil.isNotEmpty(userBean.getUsername()))
                match += "AND username='" + userBean.getUsername() + "' ";
            if (StringUtil.isNotEmpty(userBean.getNickname()))
                match += "AND nickname='" + userBean.getNickname() + "' ";
            if (StringUtil.isNotEmpty(userBean.getPassword()))
                match += "AND password='" + userBean.getPassword() + "' ";
            if (StringUtil.isNotEmpty(userBean.getAuthority()))
                match += "AND authority='" + userBean.getAuthority() + "' ";
            if (StringUtil.isNotEmpty(userBean.getEmail()))
                match += "AND email='" + userBean.getEmail() + "' ";
            if (!match.isEmpty())
                sql += "WHERE " + match.substring(3);

            PreparedStatement ppst = conn.prepareStatement(sql);
            ResultSet re = ppst.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("uid", re.getString("uid"));
                map.put("username", re.getString("username"));
                map.put("nickname", re.getString("nickname"));
                map.put("password", re.getString("password"));
                map.put("authority", re.getString("authority"));
                map.put("email", re.getString("email"));
                result.add(map);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
