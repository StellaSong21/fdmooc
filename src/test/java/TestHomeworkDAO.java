import dao.DAOFactory;
import dao.HomeworkDAO;
import entity.HomeworkBean;
import org.junit.Test;
import util.DbUtil;

public class TestHomeworkDAO {
    @Test
    public void test() {
        new DbUtil();
        HomeworkDAO homeworkDAO = DAOFactory.getHomeworkDAOInstance();
        HomeworkBean homeworkBean = new HomeworkBean("1", "", "", "", "", "1");

//        homeworkDAO.append(homeworkBean);

//        homeworkDAO.delete("1");

//        homeworkDAO.modify(new HomeworkBean("1","", "", "", "", ""));

//        List<Map<String, String>> result = homeworkDAO.infoList(homeworkBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(homeworkBean.getCid(), m.get("cid"));
    }
}
