package pl.bratek20.cookies.test;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class DBCleaner {
    private final JdbcTemplate jdbcTemplate;

    public void deleteAll(String tableName) {
        jdbcTemplate.update(String.format("DELETE FROM %s", tableName));
    }
}
