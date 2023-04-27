package pl.waw.great.swap.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.waw.great.swap.controller.request.ScanRequest;
import pl.waw.great.swap.controller.view.ScanView;
import pl.waw.great.swap.domain.Scan;
import pl.waw.great.swap.repository.ScanRepository;
import pl.waw.great.swap.service.mapper.ScanMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScanService {

    private ScanRepository scanRepository;
    private ScanMapper scanMapper;

    public ScanView findByEan(String ean) {
        Scan scan = scanRepository.findByEan(ean);
        return scanMapper.map(scan);
    }

    public ScanView scan(ScanRequest scanRequest) {

        Scan scan = Scan.builder()
                .ean(scanRequest.getEan())
                .id(UUID.randomUUID().toString())
                .status("VERIFIED")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Scan scanSaved = scanRepository.save(scan);
        return scanMapper.map(scanSaved);
    }

    public List<ScanView> findAll() {
        List<Scan> scans = new ArrayList<>();
        scanRepository.findAll().forEach(scans::add);

        return scans.stream()
                .map(scan -> scanMapper.map(scan))
                .collect(Collectors.toList());
    }
}