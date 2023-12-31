package pl.bratek20.cookies.test;

import org.junit.jupiter.api.extension.*;
import org.testcontainers.containers.MySQLContainer;

public class MySQLExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0");

        container.start();
        System.setProperty("spring.datasource.url", container.getJdbcUrl());
        System.setProperty("spring.datasource.username", container.getUsername());
        System.setProperty("spring.datasource.password", container.getPassword());
    }
}
