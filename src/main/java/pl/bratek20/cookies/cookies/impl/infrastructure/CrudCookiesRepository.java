package pl.bratek20.cookies.cookies.impl.infrastructure;

import org.springframework.data.repository.CrudRepository;
import pl.bratek20.cookies.cookies.api.CookieFlavor;

import java.util.Optional;

public interface CrudCookiesRepository extends CrudRepository<CookiesEntity, Long> {
    Optional<CookiesEntity> findByIdentityIdAndFlavor(String identityId, CookieFlavor flavor);
}

