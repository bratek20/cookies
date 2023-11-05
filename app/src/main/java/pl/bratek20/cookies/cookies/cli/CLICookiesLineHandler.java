package pl.bratek20.cookies.cookies.cli;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.bratek20.common.cli.CLILineHandler;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.common.identity.api.IdentityId;

@RequiredArgsConstructor
@Slf4j
public class CLICookiesLineHandler implements CLILineHandler {
    private final CookiesApi cookiesApi;

    @Override
    public String handleLine(String line) {
        var arguments = line.split(" ");
        switch (arguments[0]) {
            case "add":
                return addCookie(arguments);
            case "consume":
                return consumeCookie(arguments);
            case "count":
                return countCookies(arguments);
            default:
                return "Unknown command: " + arguments[0];
        }
    }
    private String addCookie(String[] arguments) {
        var flavor = CookieFlavor.valueOf(arguments[1]);
        var identity = identityId(arguments[2]);
        cookiesApi.addCookie(new Cookie(flavor), identity);
        return "Cookie added";
    }

    private String consumeCookie(String[] arguments) {
        var flavor = CookieFlavor.valueOf(arguments[1]);
        var identity = identityId(arguments[2]);
        cookiesApi.consumeCookie(flavor, identity);
        return "Cookie consumed";
    }

    private String countCookies(String[] arguments) {
        var flavor = CookieFlavor.valueOf(arguments[1]);
        var identity = identityId(arguments[2]);
        int count = cookiesApi.countCookies(flavor, identity);
        return "Cookies count: " + count;
    }

    private IdentityId identityId(String argument) {
        return new IdentityId(Integer.parseInt(argument));
    }
}
