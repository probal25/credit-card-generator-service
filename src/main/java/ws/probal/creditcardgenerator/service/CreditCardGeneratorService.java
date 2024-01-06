package ws.probal.creditcardgenerator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ws.probal.creditcardgenerator.domain.dto.VerificationDetail;
import ws.probal.creditcardgenerator.domain.entity.CreditCard;
import ws.probal.creditcardgenerator.domain.entity.CreditCardApplication;
import ws.probal.creditcardgenerator.domain.enums.ApplicationStatusEnum;
import ws.probal.creditcardgenerator.domain.enums.CardType;
import ws.probal.creditcardgenerator.repository.CreditCardApplicationRepository;
import ws.probal.creditcardgenerator.repository.CreditCardRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditCardGeneratorService {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardApplicationRepository creditCardApplicationRepository;

    public void generateCreditCardAndCVV(List<VerificationDetail> verificationDetails) {
        List<CreditCard> creditCards = verificationDetails.stream().map(verificationDetail -> {
            CreditCard creditCard = new CreditCard();
            BeanUtils.copyProperties(verificationDetail, creditCard);
            if (verificationDetail.getStatus().equals(ApplicationStatusEnum.APPROVED.getCode())) {
                creditCard.setCardNumber(generateRandomInt(100000000L, 9999999999L));
                creditCard.setCvv(generateRandomInt(100L, 999L));
                creditCard.setCreationDate(new Date());
                creditCard.setExpirationDate(addYears(3));
                creditCard.setActive(true);
                creditCard.setCardType(CardType.VISA.getValue());
            }
            return creditCard;
        }).toList();
        log.info("*********** generating credit card *************");
        creditCardRepository.saveAll(creditCards);
        updateCreditCardApplicationStatus(creditCards);

    }

    private void updateCreditCardApplicationStatus(List<CreditCard> creditCards) {
        for (CreditCard creditCard : creditCards) {
            if (creditCard.isActive()) {
                CreditCardApplication creditCardApplication = creditCardApplicationRepository
                        .findByReferenceId(creditCard.getReferenceId()).orElse(null);

                if (Objects.isNull(creditCardApplication)) {
                    log.error("Can not find any application with reference id : {}", creditCard.getReferenceId());
                } else {
                    creditCardApplication.setStatus(ApplicationStatusEnum.GENERATED.getCode());
                    creditCardApplicationRepository.save(creditCardApplication);
                }
            }
        }
    }

    private Long generateRandomInt(long min, long max) {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        return randomDataGenerator.nextLong(min, max);
    }

    private Date addYears(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }
}
