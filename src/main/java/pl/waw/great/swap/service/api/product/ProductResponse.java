package pl.waw.great.swap.service.api.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductResponse {
    private String ean;

    private String name;
    private ContentDto content;

    private String lot;
    private LocalDate expireDate;
}
