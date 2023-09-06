package pl.bratek20.cookies.cookies.impl.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bratek20.cookies.cookies.api.Cookie;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.impl.application.CookiesService;
import pl.bratek20.cookies.identity.api.IdentityId;

@RestController
@RequestMapping("/cookies")
@RequiredArgsConstructor
public class CookiesController {

    private final CookiesService cookiesService;

    @PostMapping("/add/{identityId}")
    public ResponseEntity<Integer> addCookie(@PathVariable String identityId, @RequestBody Cookie cookie) {
        int count = cookiesService.addCookie(cookie, new IdentityId(identityId));
        return ResponseEntity.ok(count);
    }

    @PostMapping("/consume/{identityId}/{flavor}")
    public ResponseEntity<Integer> consumeCookie(@PathVariable String identityId, @PathVariable CookieFlavor flavor) {
        int count = cookiesService.consumeCookie(flavor, new IdentityId(identityId));
        return ResponseEntity.ok(count);
    }

    @GetMapping("/count/{identityId}/{flavor}")
    public ResponseEntity<Integer> countCookies(@PathVariable String identityId, @PathVariable CookieFlavor flavor) {
        int count = cookiesService.countCookies(flavor, new IdentityId(identityId));
        return ResponseEntity.ok(count);
    }
}

