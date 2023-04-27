package pl.waw.great.swap.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.waw.great.swap.controller.request.ScanRequest;
import pl.waw.great.swap.controller.view.ScanView;
import pl.waw.great.swap.service.ScanService;

import java.util.List;

@RestController
@RequestMapping("scan")
@AllArgsConstructor
public class ScanController {

    private ScanService scanService;

    @PostMapping
    public ScanView post(@RequestBody ScanRequest scanRequest){
        return this.scanService.scan(scanRequest);
    }

    @GetMapping(value = "/{ean}")
    public ScanView get(@PathVariable String ean){
        return this.scanService.findByEan(ean);
    }

    @GetMapping
    public List<ScanView> getAll(){
        return this.scanService.findAll();
    }

}
