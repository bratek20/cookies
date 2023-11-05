package pl.bratek20.cookies.test.dbcleaner;

import org.jetbrains.annotations.NotNull;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class DBCleanerTestListener implements TestExecutionListener {

    @Override
    public void afterTestMethod(@NotNull TestContext testContext) {
        var context = testContext.getApplicationContext();
        if (context.containsBean("dbCleaner")) {
            var dbCleaner = context.getBean(DBCleaner.class);
            dbCleaner.deleteAllTables();
        }
    }
}