package dao;

import entity.UserBean;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOImplement implements UserDAO {
    public int append(UserBean user) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "insert into 'fdmooc'.'user' ('username','nickname','password','authority','email') values ('" +
                    user.getUsername() + "','" + user.getNickname() + "','" + user.getPassword() + "','" + user.getAuthority() + "','" + user.getEmail() + "');";
            PreparedStatement ps = conn.prepareStatement(sql);
            int re = ps.executeUpdate();
            if (DbUtil.closeConnection(conn) == -1)
                return -1;
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int delete(int id) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = " delete from 'fdmooc'.'user' where 'uid'='" + id + "');";
            PreparedStatement ps = conn.prepareStatement(sql);
            int re = ps.executeUpdate();
            if (DbUtil.closeConnection(conn) == -1)
                return -1;
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int modify(UserBean user) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "UPDATE 'fdmooc'.'user' SET username=?, nickname=?, password=?, authority=?, email=? WHERE uid=?";
            PreparedStatement ppst = conn.prepareStatement(sql);
            ppst.setString(6, user.getUid());
            ppst.setString(1, user.getUsername());
            ppst.setString(2, user.getNickname());
            ppst.setString(3, user.getPassword());
            ppst.setString(4, user.getAuthority());
            ppst.setString(5, user.getEmail());

            PreparedStatement ps = conn.prepareStatement(sql);
            int re = ps.executeUpdate();
            if (DbUtil.closeConnection(conn) == -1)
                return -1;
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Map<String, String>> infoList(UserBean user) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "select from 'fdmooc'.'user' where";
            String match = "";
            if (!user.getUid().isEmpty())
                match += "and uid='" + user.getUid() + "' ";
            if (!user.getUsername().isEmpty())
                match += "and usename='" + user.getUsername() + "' ";
            if (!user.getNickname().isEmpty())
                match += "and nickname='" + user.getNickname() + "' ";
            if (!user.getPassword().isEmpty())
                match += "and password='" + user.getPassword() + "' ";
            if (!user.getAuthority().isEmpty())
                match += "and authority='" + user.getAuthority() + "' ";
            if (!user.getEmail().isEmpty())
                match += "and email='" + user.getEmail() + "' ";
            if (!match.isEmpty())
                sql += match.substring(3);
            PreparedStatement ps = conn.prepareStatement(sql + ";");
            ResultSet re = ps.executeQuery();
            if (DbUtil.closeConnection(conn) == -1)
                return null;
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
