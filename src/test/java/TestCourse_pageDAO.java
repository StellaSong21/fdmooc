import dao.Course_pageDAO;
import dao.DAOFactory;
import entity.Course_pageBean;
import org.junit.Test;
import util.DbUtil;

public class TestCourse_pageDAO {
    @Test
    public void test() {
        new DbUtil();
        Course_pageDAO course_pageDAO = DAOFactory.getCourse_pageDAOInstance();
        Course_pageBean Course_pageBean = new Course_pageBean("", "", "", "", "", "1.1");

//        course_pageDAO.append(Course_pageBean);

//        course_pageDAO.modify(new Course_pageBean("3","20", "1.3", "haohao", "xuexi", "2.3"));

//        course_pageDAO.delete("2");

//        List<Map<String, String>> result = course_pageDAO.infoList(Course_pageBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(Course_pageBean.getUrl(), m.get("url"));
    }
}
