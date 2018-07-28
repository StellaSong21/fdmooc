import dao.Course_pageDAO;
import dao.DAOFactory;
import entity.coursePageBean;
import org.junit.Test;
import util.DbUtil;

public class TestCourse_pageDAO {
    @Test
    public void test() {
        new DbUtil();
        Course_pageDAO course_pageDAO = DAOFactory.getCourse_pageDAOInstance();
        coursePageBean coursePageBean = new coursePageBean("", "", "", "", "", "1.1");

//        course_pageDAO.append(coursePageBean);

//        course_pageDAO.modify(new coursePageBean("3","20", "1.3", "haohao", "xuexi", "2.3"));

//        course_pageDAO.delete("2");

//        List<Map<String, String>> result = course_pageDAO.infoList(coursePageBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(coursePageBean.getUrl(), m.get("url"));
    }
}
