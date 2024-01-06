package ws.probal.creditcardgenerator.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private BigDecimal annualIncome;

    private String address;

    private String referenceId;

    private Date creationDate;

    private Date expirationDate;

    private Long cardNumber;

    private String cardType;

    private Long cvv;

    private boolean isActive;

}
