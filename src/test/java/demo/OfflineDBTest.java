package demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.generated.JdbcTemplateFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*This class does not need access to a real database but uses the recorded information from the online stage to complete*/
@Test
public class OfflineDBTest {
    private JdbcTemplate jt = new JdbcTemplateFactory().buildJdbcTemplate();

    @Test
    public void testDBQuery() throws Exception {
        DBQuery dbQuery = new DBQuery(jt);
                    List<String> call = null;
                    call = dbQuery.call();
                    Assert.assertEquals(call.size(), 4);
                    Assert.assertEquals(call.get(0), "Hello");
                    Assert.assertEquals(call.get(1), " ");
                    Assert.assertEquals(call.get(2), "World");
                    Assert.assertEquals(call.get(3), "!");
    }
}
