package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.crud;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudCookiesEntityRepository extends CrudRepository<CookiesEntity, Long> {
    Optional<CookiesEntity> findByIdentityIdAndFlavor(long identityId, String flavor);
}

