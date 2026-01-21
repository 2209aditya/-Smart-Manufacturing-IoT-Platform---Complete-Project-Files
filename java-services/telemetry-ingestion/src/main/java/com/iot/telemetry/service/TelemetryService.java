package com.iot.telemetry.service;

import com.iot.telemetry.model.TelemetryData;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class TelemetryService {
    
    private final MeterRegistry meterRegistry;
    private final Counter telemetryCounter;
    
    public TelemetryService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.telemetryCounter = Counter.builder("telemetry.processed")
                .description("Number of telemetry messages processed")
                .register(meterRegistry);
    }
    
    public void processTelemetry(TelemetryData data) {
        // Record metrics
        Gauge.builder("machine.temperature", data, TelemetryData::getTemperature)
                .tag("machineId", data.getMachineId())
                .register(meterRegistry);
        
        telemetryCounter.increment();
        
        // Process telemetry data
        System.out.println("Processing telemetry from machine: " + data.getMachineId());
        System.out.println("Temperature: " + data.getTemperature() + "°C");
        System.out.println("Vibration: " + data.getVibration() + " mm/s");
        System.out.println("RPM: " + data.getRpm());
        
        // Here you would:
        // 1. Validate data
        // 2. Store in database
        // 3. Publish to Kafka for downstream processing
    }
}
