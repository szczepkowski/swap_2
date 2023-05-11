package pl.waw.great.swap.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Builder
public class Product {
    private String ean;

    private String name;
    private Content content;

    private String lot;
    private LocalDate expireDate;
}
