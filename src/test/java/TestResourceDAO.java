import dao.DAOFactory;
import dao.ResourceDAO;
import entity.ResourceBean;
import org.junit.Test;
import util.DbUtil;

public class TestResourceDAO {
    @Test
    public void test() {
        new DbUtil();
        ResourceDAO resourceDAO = DAOFactory.getResourceDAOInstance();
        ResourceBean resourceBean = new ResourceBean("1", "", "");

//        resourceDAO.append(resourceBean);

//        resourceDAO.delete(resourceBean);

//        resourceDAO.modify(new ResourceBean("1", "", ""));

//        List<Map<String, String>> result = resourceDAO.infoList(resourceBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(resourceBean.getCid(), m.get("cid"));
    }
}
