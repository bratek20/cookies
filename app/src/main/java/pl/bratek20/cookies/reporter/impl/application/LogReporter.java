package pl.bratek20.cookies.reporter.impl.application;

import lombok.extern.slf4j.Slf4j;
import pl.bratek20.cookies.reporter.api.Reporter;

@Slf4j
public class LogReporter implements Reporter {

    @Override
    public void report(String message) {
        log.info(message);
    }
}
