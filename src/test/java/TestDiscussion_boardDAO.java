import dao.DAOFactory;
import dao.Discussion_boardDAO;
import entity.Discussion_boardBean;
import org.junit.Test;
import util.DbUtil;

public class TestDiscussion_boardDAO {
    @Test
    public void test() {
        new DbUtil();
        Discussion_boardDAO discussion_boardDAO = DAOFactory.getDiscussion_boardDAOInstance();
        Discussion_boardBean discussion_boardBean = new Discussion_boardBean("1", "we", "2000-2-22", "1");

//        discussion_boardDAO.append(discussion_boardBean);

//        discussion_boardDAO.delete("1");

//        discussion_boardDAO.modify(new Discussion_boardBean("1", "yu", "", "4"));

//        List<Map<String, String>> result = discussion_boardDAO.infoList(discussion_boardBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(discussion_boardBean.getDid(), m.get("did"));
    }
}
