package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.inmemory;

import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;
import pl.bratek20.common.identity.api.IdentityId;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class InMemoryCookiesRepository implements CookiesRepository {

    private static class Cookies {
        private final Map<CookieFlavor, Integer> amounts = new EnumMap<>(CookieFlavor.class);

        public void setAmount(CookieFlavor flavor, int amount) {
            amounts.put(flavor, amount);
        }

        public int getAmount(CookieFlavor flavor) {
            return amounts.getOrDefault(flavor, 0);
        }
    }

    private final Map<IdentityId, Cookies> map = new HashMap<>();

    @Override
    public int getAmount(IdentityId identityId, CookieFlavor flavor) {
        return getOrCreate(identityId).getAmount(flavor);
    }

    @Override
    public void setAmount(IdentityId identityId, CookieFlavor flavor, int amount) {
        getOrCreate(identityId).setAmount(flavor, amount);
    }

    private Cookies getOrCreate(IdentityId identityId) {
        return map.computeIfAbsent(identityId, id -> new Cookies());
    }
}
