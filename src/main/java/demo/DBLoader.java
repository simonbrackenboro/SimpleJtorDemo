package demo;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;

/* Simple class that created and loads the table with data */
public class DBLoader implements Runnable{
    private final JdbcTemplate jt;

    @Inject
    public DBLoader(JdbcTemplate jt) {
        this.jt = jt;
    }

    public void run() {
        jt.execute("CREATE TABLE TEST ( COL varchar(255) )");
        jt.execute("INSERT INTO TEST VALUES ('Hello')");
        jt.execute("INSERT INTO TEST VALUES (' ')");
        jt.execute("INSERT INTO TEST VALUES ('World')");
        jt.execute("INSERT INTO TEST VALUES ('!')");
    }
}
