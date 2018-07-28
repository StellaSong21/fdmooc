import dao.Course_tableDAO;
import dao.DAOFactory;
import entity.courseTableBean;
import org.junit.Test;
import util.DbUtil;

public class TestCourse_tableDAO {
    @Test
    public void test() {
        new DbUtil();
        Course_tableDAO course_tableDAO = DAOFactory.getCourse_tableDAOInstance();
        courseTableBean courseTableBean = new courseTableBean("", "");

//        course_tableDAO.append(courseTableBean);

        course_tableDAO.delete(new courseTableBean("1", ""));

//        List<Map<String, String>> result = course_tableDAO.infoList(courseTableBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(courseTableBean.getUid(), m.get("uid"));
    }
}
