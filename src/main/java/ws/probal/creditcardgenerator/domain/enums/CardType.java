package ws.probal.creditcardgenerator.domain.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardType {

    VISA("Visa"),
    MASTERCARD("Mastercard"),
    AMEX("American Express"),
    ;
    private String value;
}
