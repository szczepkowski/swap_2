package pl.waw.great.swap.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.waw.great.swap.domain.Product;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ScanView {

    private String id;
    private String ean;
    private Product product;
    private String status;

    private LocalDateTime createdAt;
}
