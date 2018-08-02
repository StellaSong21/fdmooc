import com.google.gson.JsonObject;
import org.junit.Test;
import service.ServiceFactory;

public class TestJson {

    @Test
    public void test() {
//        Discussion_boardDAO d = DAOFactory.getDiscussion_boardDAOInstance();
//        d.append(new Discussion_boardBean("qw4e5rtyu",new Date().toString(),"23456"));
//        DiscussionService ds = ServiceFactory.getDiscussionInstance(new JsonObject());
//        System.out.println(ds.boardInfo().toString());
        JsonObject j = new JsonObject();
        j.addProperty("tid", 2);
        System.out.println(ServiceFactory.getCourseServiceInstance(j).doCourseInfo().toString());
        //System.out.println(j.toString());

    }
}
