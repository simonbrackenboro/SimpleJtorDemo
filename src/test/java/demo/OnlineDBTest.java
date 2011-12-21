package demo;

import com.advancedpwr.record.mock.MockBehaviorRecorder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
/* This test uses a real database to run the test */
public class OnlineDBTest {
    private final DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:hsqldb:mem:.", "sa", "");
    private JdbcTemplate jt = new JdbcTemplate(ds);
    private final MockBehaviorRecorder recorder = new MockBehaviorRecorder();

    public OnlineDBTest() {
        recorder.setDestination("src/test/java");
    }

    @Test
    public void testDBLoader() {
        DBLoader instance = new DBLoader(jt);
        instance.run();
    }

    @Test(dependsOnMethods = "testDBLoader")
    public void testDBQuery() throws Exception {
        JdbcTemplate jt = recorder.record(this.jt);
        /* Note we record the actions on jt */
        DBQuery dbQuery = new DBQuery(jt);
        List<String> call = null;
        call = dbQuery.call();
        Assert.assertEquals(call.size(), 4);
        Assert.assertEquals(call.get(0), "Hello");
        Assert.assertEquals(call.get(1), " ");
        Assert.assertEquals(call.get(2), "World");
        Assert.assertEquals(call.get(3), "!");
        recorder.endRecording();
    }
}
