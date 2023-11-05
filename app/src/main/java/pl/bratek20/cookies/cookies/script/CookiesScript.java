package pl.bratek20.cookies.cookies.script;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.impl.infrastructure.configs.CookiesInMemoryConfig;
import pl.bratek20.common.identity.api.IdentityId;
import pl.bratek20.common.script.CreateArgsException;
import pl.bratek20.common.script.Script;
import pl.bratek20.common.script.SpringScriptRunner;

public class CookiesScript extends Script<CookiesApi, CookiesScript.Args> {

    public CookiesScript(CookiesApi cookiesApi) {
        super(cookiesApi);
    }

    record Args(String method, CookieFlavor flavor, IdentityId identityId) { }

    @Override
    protected void addOptions(Options options) {
        options.addOption("m", "method", true, "Method to run");
        options.addOption("f", "flavor", true, "Cookie flavor");
        options.addOption("i", "identityId", true, "Identity id");
    }

    @Override
    protected Args createArgs(CommandLine cmd) throws CreateArgsException {
        var method = cmd.getOptionValue("method");
        var flavor = cmd.getOptionValue("flavor");
        var identityId = cmd.getOptionValue("identityId");

        if (!methodSupported(method)) {
            throw new CreateArgsException("Method %s not supported".formatted(method));
        }
        return new Args(method, CookieFlavor.valueOf(flavor), new IdentityId(Long.parseLong(identityId)));
    }

    private boolean methodSupported(String method) {
        return method.equals("add") || method.equals("consume") || method.equals("count");
    }

    @Override
    protected String run(CookiesApi api, Args args) {
        switch (args.method) {
            case "add" -> api.addCookie(new Cookie(args.flavor), args.identityId);
            case "consume" -> api.consumeCookie(args.flavor, args.identityId);
            case "count" -> {
                var count = api.countCookies(args.flavor, args.identityId);
                return "Cookies count: " + count;
            }
        }
        return "Done";
    }

    public static void main(String[] args) {
        new SpringScriptRunner<>(
            CookiesInMemoryConfig.class,
            CookiesApi.class,
            CookiesScript.class
        ).run(args);
    }
}
