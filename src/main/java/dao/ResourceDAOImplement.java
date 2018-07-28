package dao;

import entity.ResourceBean;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDAOImplement implements ResourceDAO {

    @Override
    public int append(ResourceBean resourceBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`resource` (cid,url,`number`) VALUES (?, ?, ?)";
            PreparedStatement ppst = conn.prepareStatement(sql);
            ppst.setString(1, resourceBean.getCid());
            ppst.setString(2, resourceBean.getUrl());
            ppst.setString(3, resourceBean.getNumber());

            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(ResourceBean resourceBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "DELETE FROM `fdmooc`.`resource` WHERE cid='" + resourceBean.getCid() + "'";
            if (StringUtil.isNotEmpty(resourceBean.getNumber())) {
                sql += " AND `number`='" + resourceBean.getNumber() + "'";
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
    public int modify(ResourceBean resourceBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "UPDATE `fdmooc`.`resource` SET url=? WHERE cid=? AND number=?";
            PreparedStatement ppst = conn.prepareStatement(sql);
            ppst.setString(1, resourceBean.getUrl());
            ppst.setString(2, resourceBean.getCid());
            ppst.setString(3, resourceBean.getNumber());

            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Map<String, String>> infoList(ResourceBean resourceBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`resource` ";
            String match = "";
            if (!StringUtil.isEmpty(resourceBean.getCid()))
                match += "AND cid='" + resourceBean.getCid() + "' ";
            if (!StringUtil.isEmpty(resourceBean.getUrl()))
                match += "AND url='" + resourceBean.getUrl() + "' ";
            if (!StringUtil.isEmpty(resourceBean.getNumber()))
                match += "AND `number`='" + resourceBean.getNumber() + "' ";

            if (!match.isEmpty())
                sql += "WHERE " + match.substring(3);

            PreparedStatement ppst = conn.prepareStatement(sql);
            ResultSet re = ppst.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("cid", re.getString("cid"));
                map.put("url", re.getString("url"));
                map.put("number", re.getString("number"));
                result.add(map);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
