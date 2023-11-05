package pl.bratek20.cookies.cookies.impl.infrastructure.repostiories.crud;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "cookies")
public class CookiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated primary key

    private Long identityId;
    private String flavor;
    private int amount;
}

