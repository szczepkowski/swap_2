package pl.waw.great.swap.service.mapper;

import org.springframework.stereotype.Component;
import pl.waw.great.swap.controller.view.ScanView;
import pl.waw.great.swap.domain.Scan;

@Component
public class ScanMapper {
    public ScanView map(Scan scan){
        return ScanView.builder()
                .status(scan.getStatus())
                .id(scan.getId())
                .ean(scan.getEan())
                .createdAt(scan.getCreatedAt())
                .product(scan.getProduct())
                .build();
    }
}
