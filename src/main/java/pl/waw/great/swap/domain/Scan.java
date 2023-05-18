package pl.waw.great.swap.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.waw.great.swap.service.api.verification.VerificationState;

import java.time.LocalDateTime;

@Document("scan")
@AllArgsConstructor
@Getter
@Builder
public class Scan {

    @Id
    private String id;
    private String ean;
    private Product product;
    private VerificationState status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
