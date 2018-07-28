import dao.DAOFactory;
import dao.Discussion_boardDAO;
import entity.discussionBoardBean;
import org.junit.Test;
import util.DbUtil;

public class TestDiscussion_boardDAO {
    @Test
    public void test() {
        new DbUtil();
        Discussion_boardDAO discussion_boardDAO = DAOFactory.getDiscussion_boardDAOInstance();
        discussionBoardBean discussionBoardBean = new discussionBoardBean("1", "we", "2000-2-22", "1");

//        discussion_boardDAO.append(discussionBoardBean);

//        discussion_boardDAO.delete("1");

//        discussion_boardDAO.modify(new discussionBoardBean("1", "yu", "", "4"));

//        List<Map<String, String>> result = discussion_boardDAO.infoList(discussionBoardBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(discussionBoardBean.getDid(), m.get("did"));
    }
}
