package pl.waw.great.swap.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.waw.great.swap.domain.Product;
import pl.waw.great.swap.service.api.verification.VerificationState;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ScanView {

    private String id;
    private String ean;
    private Product product;
    private VerificationState status;

    private LocalDateTime createdAt;
}
