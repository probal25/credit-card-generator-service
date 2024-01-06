package ws.probal.creditcardgenerator.domain.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardInfo {

    private String firstName;

    private String lastName;

    private String referenceId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    private Long cardNumber;

    private String cardType;

    private Long cvv;

    private boolean isActive;
}
