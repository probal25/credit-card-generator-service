package ws.probal.creditcardgenerator.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ws.probal.creditcardgenerator.common.exception.RecordNotFoundException;
import ws.probal.creditcardgenerator.domain.entity.CreditCard;
import ws.probal.creditcardgenerator.domain.response.CreditCardInfo;
import ws.probal.creditcardgenerator.repository.CreditCardRepository;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardInfo getCreditCardInfo(String referenceId) {
        CreditCard creditCard = creditCardRepository.findByReferenceId(referenceId).orElse(null);

        if (Objects.isNull(creditCard)) {
            log.error("No data found with this reference id: {}", referenceId);
            throw new RecordNotFoundException("No data found with this reference id: " + referenceId);
        }

        CreditCardInfo creditCardInfo = CreditCardInfo.builder().build();
        BeanUtils.copyProperties(creditCard, creditCardInfo);
        return creditCardInfo;
    }
}
