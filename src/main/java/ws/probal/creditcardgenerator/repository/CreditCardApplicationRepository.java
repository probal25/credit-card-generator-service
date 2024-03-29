package ws.probal.creditcardgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ws.probal.creditcardgenerator.domain.entity.CreditCardApplication;


import java.util.List;
import java.util.Optional;

public interface CreditCardApplicationRepository extends JpaRepository<CreditCardApplication, Long> {
    List<CreditCardApplication> findByStatus(String status);

    Optional<CreditCardApplication> findByReferenceId(String referenceId);
}
