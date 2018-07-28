import org.junit.Test;
import util.DbUtil;

import static org.junit.Assert.assertNotNull;

public class TestDbUtil {

    @Test
    public void test() throws Exception {
        assertNotNull(new DbUtil().getConnecction());
    }
}
