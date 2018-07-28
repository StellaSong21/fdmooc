import dao.CourseDAO;
import dao.DAOFactory;
import entity.CourseBean;
import org.junit.Test;
import util.DbUtil;

public class TestCourseDAO {
    @Test
    public void test() {
        new DbUtil();
        CourseDAO courseDAO = DAOFactory.getCourseDAOInstance();
        CourseBean courseBean = new CourseBean("2", "we", "1", "haohao", "xuexi");

//        courseDAO.append(courseBean);

//        courseDAO.delete("3");

//        courseDAO.modify(new CourseBean("1", "mo", "2", "pi", "mn"));

//        List<Map<String, String>> result = courseDAO.infoList(courseBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(courseBean.getCid(), m.get("cid"));
    }
}
