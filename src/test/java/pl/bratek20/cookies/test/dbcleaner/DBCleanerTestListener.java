package pl.bratek20.cookies.test.dbcleaner;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class DBCleanerTestListener implements TestExecutionListener {

    @Autowired
    private DBCleaner dbCleaner;

    @Override
    public void afterTestMethod(@NotNull TestContext testContext) {
        dbCleaner.deleteAllTables();
    }
}