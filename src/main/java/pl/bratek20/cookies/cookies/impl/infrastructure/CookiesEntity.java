package pl.bratek20.cookies.cookies.impl.infrastructure;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.bratek20.cookies.cookies.api.CookieFlavor;

@Entity
@Setter
@Getter
@Table(name = "cookies")
public class CookiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated primary key

    private String identityId;
    private String flavor;
    private int amount;
}
