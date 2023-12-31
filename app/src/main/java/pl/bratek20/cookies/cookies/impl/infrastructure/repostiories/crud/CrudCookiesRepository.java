package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.crud;

import lombok.RequiredArgsConstructor;
import pl.bratek20.cookies.cookies.api.CookieFlavor;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;
import pl.bratek20.commons.identity.api.IdentityId;

import java.util.Optional;

@RequiredArgsConstructor
public class CrudCookiesRepository implements CookiesRepository {

    private final CrudCookiesEntityRepository repository;

    @Override
    public int getAmount(IdentityId identityId, CookieFlavor flavor) {
        Optional<CookiesEntity> entity = repository.findByIdentityIdAndFlavor(identityId.value(), flavor.name());
        return entity.map(CookiesEntity::getAmount).orElse(0);
    }

    @Override
    public void setAmount(IdentityId identityId, CookieFlavor flavor, int amount) {
        Optional<CookiesEntity> entity = repository.findByIdentityIdAndFlavor(identityId.value(), flavor.name());
        if (entity.isPresent()) {
            CookiesEntity cookiesEntity = entity.get();
            cookiesEntity.setAmount(amount);
            repository.save(cookiesEntity);
        } else {
            CookiesEntity newCookiesEntity = new CookiesEntity();
            newCookiesEntity.setIdentityId(identityId.value());
            newCookiesEntity.setFlavor(flavor.name());
            newCookiesEntity.setAmount(amount);
            repository.save(newCookiesEntity);
        }
    }
}

