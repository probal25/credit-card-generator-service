package ws.probal.creditcardgenerator.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.probal.creditcardgenerator.domain.response.CreditCardInfo;
import ws.probal.creditcardgenerator.service.CreditCardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/credit-card")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Operation(summary = "Get info of credit card")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/info/{referenceId}")
    public ResponseEntity<CreditCardInfo> creditCardApplicationStatus(@PathVariable String referenceId) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(creditCardService.getCreditCardInfo(referenceId));
    }
}
