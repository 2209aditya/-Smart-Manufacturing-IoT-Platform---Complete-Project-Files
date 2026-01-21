package com.iot.telemetry.controller;

import com.iot.telemetry.model.TelemetryData;
import com.iot.telemetry.service.TelemetryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/telemetry")
public class TelemetryController {
    
    private final TelemetryService telemetryService;
    
    public TelemetryController(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }
    
    @PostMapping
    public ResponseEntity<Void> ingest(@RequestBody TelemetryData data) {
        telemetryService.processTelemetry(data);
        return ResponseEntity.accepted().build();
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}
