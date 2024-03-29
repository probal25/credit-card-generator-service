package ws.probal.creditcardgenerator.domain.dto;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerificationDetail {
    private String firstName;

    private String lastName;

    private BigDecimal annualIncome;

    private String address;

    private String referenceId;

    private String status;
}
