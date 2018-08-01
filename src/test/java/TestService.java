import com.google.gson.JsonObject;
import org.junit.Test;
import service.CourseService;
import service.ServiceFactory;

public class TestService {
    @Test
    public void test() {
        //System.out.println(ServiceFactory.getCourseServiceInstance().getTopHotCourse());
        //System.out.println(ServiceFactory.getCourseServiceInstance().getLatestCourse());
        //DAOFactory.getCourseDAOInstance().delete("1");
        JsonObject j = new JsonObject();
        j.addProperty("cid", "13");
        //ServiceFactory.getDiscussionInstance(j).append();
        CourseService cs = ServiceFactory.getCourseServiceInstance(j);
        System.out.println(cs.getCourseInfo());
        System.out.println(cs.getCoursePageInfo());
        System.out.println(cs.getResourceInfo());
        System.out.println(cs.getHomeworkInfo());
        JsonObject j1 = new JsonObject();
        j1.addProperty("uid", "1");
        System.out.println(ServiceFactory.getUserServiceInstance(j1).userInfo());
    }
}
