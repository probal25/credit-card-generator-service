package ws.probal.creditcardgenerator.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationStatusEnum {

    PENDING("PENDING", "Application Pending"),
    PUBLISHED("PUBLISHED", "Application Published"),
    APPROVED("APPROVED", "Application Approved"),
    REJECTED("REJECTED", "Application Rejected"),
    GENERATED("GENERATED", "Application Generated"),
    ;

    private String code;
    private String description;
}
