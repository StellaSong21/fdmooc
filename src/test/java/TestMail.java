import org.junit.Test;
import service.MailService;
import service.ServiceFactory;

public class TestMail {
    @Test
    public void test() {
        MailService s = ServiceFactory.getMailServiceInstance();
        s.sendMsg("1092534779@qq.com", "asdfasdf", "asdfasdfasdf\nsadfasfsda");

    }
}
