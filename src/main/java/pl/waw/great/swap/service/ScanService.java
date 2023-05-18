package pl.waw.great.swap.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.waw.great.swap.controller.request.ScanRequest;
import pl.waw.great.swap.controller.view.ScanView;
import pl.waw.great.swap.domain.Content;
import pl.waw.great.swap.domain.Form;
import pl.waw.great.swap.domain.Product;
import pl.waw.great.swap.domain.Scan;
import pl.waw.great.swap.repository.ScanRepository;
import pl.waw.great.swap.service.api.product.ProductClient;
import pl.waw.great.swap.service.api.product.ProductResponse;
import pl.waw.great.swap.service.api.verification.VerificationClient;
import pl.waw.great.swap.service.api.verification.VerificationResponse;
import pl.waw.great.swap.service.mapper.ScanMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ScanService {

    private final ScanRepository scanRepository;
    private final ScanMapper scanMapper;
    private final ProductClient productClient;
    private final VerificationClient verificationClient;

    public ScanService(ScanRepository scanRepository, ScanMapper scanMapper, ProductClient productClient, VerificationClient verificationClient) {
        this.scanRepository = scanRepository;
        this.scanMapper = scanMapper;
        this.productClient = productClient;
        this.verificationClient = verificationClient;
    }

    public ScanView findByEan(String ean) {
        Scan scan = scanRepository.findByEan(ean);
        return scanMapper.map(scan);
    }

    public ScanView scan(ScanRequest scanRequest) {

        String ean = scanRequest.getEan();
        ProductResponse productApi = productClient.getProductApi(ean);
        Product product = null;
        try {
             product = getProductFromApi(productApi);
        } catch (Exception e) {
            log.info("product api call not found with ean" + ean);
        }

        VerificationResponse verificationResponse = verificationClient.postVerification(ean, scanRequest.getActionType());

        Scan scan = Scan.builder()
                .ean(scanRequest.getEan())
                .product(product)
                .id(UUID.randomUUID().toString())
                .status(verificationResponse.getVerificationState())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Scan scanSaved = scanRepository.save(scan);
        return scanMapper.map(scanSaved);
    }

    private Product getProductFromApi(ProductResponse productApi) {
        return Product.builder()
                .ean(productApi.getEan())
                .name(productApi.getName())
                .lot(productApi.getLot())
                .expireDate(productApi.getExpireDate())
                .content(Content.builder()
                        .form(Form.valueOf(productApi.getContent().getForm().name()))
                        .value(productApi.getContent().getValue())
                        .build())
                .build();
    }

    public List<ScanView> findAll() {
        List<Scan> scans = new ArrayList<>();
        scanRepository.findAll().forEach(scans::add);

        return scans.stream()
                .map(scan -> scanMapper.map(scan))
                .collect(Collectors.toList());
    }
}