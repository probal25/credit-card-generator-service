package ws.probal.creditcardgenerator.common.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ws.probal.creditcardgenerator.domain.events.VerifyCreditCardEvent;
import ws.probal.creditcardgenerator.service.CreditCardGeneratorService;

import java.util.function.Consumer;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CreditCardVerificationEventListener {

    private final CreditCardGeneratorService creditCardGeneratorService;

    @Bean
    public Consumer<VerifyCreditCardEvent> generateCreditCard() {
        return verifyCreditCardEvent -> {
            log.info("Received records in total : {}", verifyCreditCardEvent.getVerificationDetails().size());
            creditCardGeneratorService.generateCreditCardAndCVV(verifyCreditCardEvent.getVerificationDetails());
        };
    }
}
