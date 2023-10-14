package pl.bratek20.cookies.module.test;

import org.junit.jupiter.api.BeforeEach;

public abstract class BaseApiTest<T> {
    protected abstract T createApi();

    protected T api;

    @BeforeEach
    void setUp() {
        api = createApi();
    }
}
