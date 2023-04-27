package pl.waw.great.swap.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.waw.great.swap.domain.ScanType;

@AllArgsConstructor
@Getter
@Setter
public class ScanRequest {
    private String ean;
    private ScanType scanType;
}
