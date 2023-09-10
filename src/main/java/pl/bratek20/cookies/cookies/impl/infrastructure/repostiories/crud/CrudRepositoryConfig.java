package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import pl.bratek20.cookies.cookies.impl.application.CookiesRepository;

import javax.sql.DataSource;

@Configuration
public class CrudRepositoryConfig {
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/cookies_db");
//        dataSource.setUsername("cookies_user");
//        dataSource.setPassword("password");
//        return dataSource;
//    }

    @Bean
    public CookiesRepository cookiesRepository(CrudCookiesEntityRepository crudCookiesEntityRepository) {
        return new CrudCookiesRepository(crudCookiesEntityRepository);
    }
}
