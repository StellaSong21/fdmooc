import dao.Course_tableDAO;
import dao.DAOFactory;
import entity.Course_tableBean;
import org.junit.Test;
import util.DbUtil;

public class TestCourse_tableDAO {
    @Test
    public void test() {
        new DbUtil();
        Course_tableDAO course_tableDAO = DAOFactory.getCourse_tableDAOInstance();
        Course_tableBean Course_tableBean = new Course_tableBean("", "");

//        course_tableDAO.append(Course_tableBean);

        course_tableDAO.delete(new Course_tableBean("1", ""));

//        List<Map<String, String>> result = course_tableDAO.infoList(Course_tableBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(Course_tableBean.getUid(), m.get("uid"));
    }
}
