import dao.AnswerDAO;
import dao.DAOFactory;
import entity.AnswerBean;
import org.junit.Test;
import util.DbUtil;

public class TestAnswerDAO {
    @Test
    public void test() throws Exception {
        new DbUtil();
        AnswerDAO answerDAO = DAOFactory.getAnswerDAOInstance();
        AnswerBean answerBean = new AnswerBean("1", "2", "3", null);

//        answerDAO.append(answerBean);

//        answerDAO.delete("1", "2");

        answerDAO.modify(new AnswerBean());

//        List<Map<String, String>> result = answerDAO.infoList(answerBean);
//        assertNotNull(result);
//        Map<String, String> m = result.get(0);
//        assertEquals(answerBean.getUid(), m.get("uid"));
    }
}
