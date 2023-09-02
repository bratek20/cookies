package pl.bratek20.cookies.cookies.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.api.CookiesApi;
import pl.bratek20.cookies.identity.api.IdentityId;

@RestController
@RequestMapping("/cookies")
@RequiredArgsConstructor
public class CookiesController {

    private final CookiesApi cookiesApi;

    @PostMapping("/add/{identityId}")
    public ResponseEntity<Void> addCookie(@PathVariable String identityId, @RequestBody Cookie cookie) {
        cookiesApi.addCookie(cookie, new IdentityId(identityId));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/consume/{identityId}/{flavor}")
    public ResponseEntity<Void> consumeCookie(@PathVariable String identityId, @PathVariable CookieFlavor flavor) {
        cookiesApi.consumeCookie(flavor, new IdentityId(identityId));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count/{identityId}/{flavor}")
    public ResponseEntity<Integer> countCookies(@PathVariable String identityId, @PathVariable CookieFlavor flavor) {
        int count = cookiesApi.countCookies(flavor, new IdentityId(identityId));
        return ResponseEntity.ok(count);
    }
}

