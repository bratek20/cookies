package pl.bratek20.cookies.cookies.impl.infrastructure;

import lombok.Getter;
import lombok.Setter;
import pl.bratek20.cookies.cookies.api.CookieFlavor;


//@Entity
@Setter
@Getter
public class CookiesEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated primary key

    private String identityId;
    private CookieFlavor flavor;
    private int amount;
}

