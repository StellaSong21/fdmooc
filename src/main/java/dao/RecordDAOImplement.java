package dao;

import entity.RecordBean;
import util.DbUtil;
import util.StringUtil;

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
        Connection conn = DbUtil.getConnection();
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
            DbUtil.closeConnection();
            return -1;
        }
    }

    @Override
    public int delete(RecordBean recordBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "DELETE FROM `fdmooc`.`record` WHERE ";
            String match = "";
            if (StringUtil.isNotEmpty(recordBean.getUid()))
                match += "AND uid='" + recordBean.getUid() + "' ";
            if (StringUtil.isNotEmpty(recordBean.getCid()))
                match += "AND cid='" + recordBean.getCid() + "' ";
            if (StringUtil.isNotEmpty(recordBean.getPid()))
                match += "AND pid='" + recordBean.getPid() + "' ";

            if (!match.isEmpty())
                sql += match.substring(3);

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
    public List<Map<String, String>> infoList(RecordBean recordBean) {
        Connection conn = DbUtil.getConnection();
        try {
            String sql = "select count(pid), nickname, record.uid from user, record where cid=" + recordBean.getCid() + " and user.uid=record.uid group by record.uid order by count(pid) desc, record.uid;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet re = ps.executeQuery();
            DbUtil.closeConnection();
            List<Map<String, String>> result = new ArrayList<>();
            while (re.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("count(pid)", re.getString("count(pid)"));
                map.put("uid", re.getString("uid"));
                map.put("nickname", re.getString("nickname"));
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
