package dao;

import entity.RecordBean;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordDAOImplement implements RecordDAO {
    @Override
    public int append(RecordBean recordBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "INSERT INTO `fdmooc`.`record` (uid,cid,pid) VALUES (?, ?, ?)";
            PreparedStatement ppst = conn.prepareStatement(sql);
            ppst.setString(1, recordBean.getUid());
            ppst.setString(2, recordBean.getCid());
            ppst.setString(3, recordBean.getPid());

            int re = ppst.executeUpdate();
            DbUtil.closeConnection();
            return re;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(RecordBean recordBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "DELETE FROM `fdmooc`.`record` WHERE ";
            String match = "";
            if (!recordBean.getUid().isEmpty())
                match += "AND uid='" + recordBean.getUid() + "' ";
            if (!recordBean.getCid().isEmpty())
                match += "AND cid='" + recordBean.getCid() + "' ";
            if (!recordBean.getPid().isEmpty())
                match += "AND pid='" + recordBean.getPid() + "' ";

            if (!match.isEmpty())
                sql += match.substring(3);

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
    public List<Map<String, String>> infoList(RecordBean recordBean) {
        Connection conn = DbUtil.getConnecction();
        try {
            String sql = "SELECT * FROM `fdmooc`.`record` ";
            String match = "";
            if (!recordBean.getUid().isEmpty())
                match += "AND uid='" + recordBean.getUid() + "' ";
            if (!recordBean.getCid().isEmpty())
                match += "AND cid='" + recordBean.getCid() + "' ";
            if (!recordBean.getPid().isEmpty())
                match += "AND pid='" + recordBean.getPid() + "' ";

            if (!match.isEmpty())
                sql += "WHERE " + match.substring(3);

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("uid", re.getString("uid"));
                map.put("cid", re.getString("cid"));
                map.put("pid", re.getString("pid"));
                result.add(map);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
