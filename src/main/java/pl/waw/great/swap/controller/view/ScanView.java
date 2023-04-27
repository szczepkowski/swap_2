package pl.waw.great.swap.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ScanView {

    private String id;
    private String ean;
    private String status;

    private LocalDateTime createdAt;
}
