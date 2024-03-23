package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.crud;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Table(name = "cookies")
public class CookiesEntity {

    @Id
    private Long id; // Auto-generated primary key

    private Long identityId;
    private String flavor;
    private int amount;
}

