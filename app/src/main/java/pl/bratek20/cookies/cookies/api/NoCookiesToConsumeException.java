package pl.bratek20.cookies.cookies.api;

import pl.bratek20.common.modules.api.ApiException;

public class NoCookiesToConsumeException extends ApiException {
    public NoCookiesToConsumeException() {
        super("No cookies to consume");
    }
}
