import dao.DAOFactory;
import dao.UserDAO;
import entity.UserBean;
import org.junit.Test;
import util.DbUtil;

public class TestUserDAO {
    @Test
    public void test() {
        new DbUtil();
        UserDAO userDAO = DAOFactory.getUserDAOInstance();
        UserBean userBean = new UserBean("1", "", "", "", "", "");

//        userDAO.append(userBean);

//        userDAO.delete("1");

//        userDAO.modify(new UserBean("1", "1", "9", "8", "7", "6"));

//        List<Map<String, String>> result = userDAO.infoList(userBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(userBean.getUsername(), m.get("uid"));
    }
}
