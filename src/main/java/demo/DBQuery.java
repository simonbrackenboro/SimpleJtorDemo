package demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.Callable;

/* Simple class that queries the data */
public class DBQuery implements Callable<List<String>> {
    private final JdbcTemplate jt;

    @Inject
    public DBQuery(JdbcTemplate jt) {
        this.jt = jt;
    }

    @SuppressWarnings("unchecked")
    public List<String> call() throws Exception {
        return (List<String>) jt.queryForList("SELECT COL FROM TEST", String.class);
    }
}
