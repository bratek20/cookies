package pl.bratek20.cookies.identity.api;

import org.junit.jupiter.api.Test;
import pl.bratek20.cookies.module.test.BaseApiTest;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ApiTest extends BaseApiTest<IdentityApi> {
    @Test
    void shouldGenerateDifferentIdentityId() {
        IdentityId id1 = api.generate();
        IdentityId id2 = api.generate();
        IdentityId id3 = api.generate();

        assertThat(id1).isNotIn(id2, id3);
        assertThat(id2).isNotEqualTo(id3);
    }
}