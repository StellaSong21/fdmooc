import dao.DAOFactory;
import dao.RecordDAO;
import entity.RecordBean;
import org.junit.Test;
import util.DbUtil;

public class TestRecordDAO {
    @Test
    public void test() {
        new DbUtil();
        RecordDAO recordDAO = DAOFactory.getRecordDAOInstance();
        RecordBean recordBean = new RecordBean("2", "4", "4");

//        recordDAO.append(recordBean);

//        recordDAO.delete(new RecordBean("2", "", ""));

//        List<Map<String, String>> result = recordDAO.infoList(recordBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(recordBean.getCid(), m.get("cid"));
    }
}
