package pl.bratek20.cookies.cookies.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.commons.identity.api.IdentityId;

@RestController
@RequestMapping("/cookies")
@RequiredArgsConstructor
public class CookiesController {

    private final CookiesApi cookiesApi;

    @PostMapping("/add/{identityId}")
    public void addCookie(@PathVariable long identityId, @RequestBody Cookie cookie) {
        cookiesApi.addCookie(cookie, new IdentityId(identityId));
    }

    @PostMapping("/consume/{identityId}/{flavor}")
    public void consumeCookie(@PathVariable long identityId, @PathVariable CookieFlavor flavor) {
        cookiesApi.consumeCookie(flavor, new IdentityId(identityId));
    }

    @GetMapping("/count/{identityId}/{flavor}")
    public int countCookies(@PathVariable long identityId, @PathVariable CookieFlavor flavor) {
        return cookiesApi.countCookies(flavor, new IdentityId(identityId));
    }
}

