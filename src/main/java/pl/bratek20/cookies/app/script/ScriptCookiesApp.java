package pl.bratek20.cookies.app.script;

import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.cookies.script.CookiesScript;
import pl.bratek20.cookies.script.SpringScriptRunner;

public class ScriptCookiesApp {
    public static void main(String[] args) {
        new SpringScriptRunner<>(
            ScriptCookiesAppConfig.class,
            CookiesApi.class,
            CookiesScript.class
        ).run(args);
    }
}
