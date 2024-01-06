package ws.probal.creditcardgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.probal.creditcardgenerator.domain.entity.CreditCard;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    Optional<CreditCard> findByReferenceId(String referenceId);
}
