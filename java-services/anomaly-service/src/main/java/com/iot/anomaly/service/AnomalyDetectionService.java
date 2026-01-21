package com.iot.anomaly.service;

import com.iot.anomaly.model.Anomaly;
import org.springframework.stereotype.Service;

@Service
public class AnomalyDetectionService {
    
    private static final double TEMP_THRESHOLD = 85.0;
    private static final double VIBRATION_THRESHOLD = 15.0;
    
    public Anomaly detectAnomaly(double temperature, double vibration, String machineId) {
        Anomaly anomaly = new Anomaly();
        anomaly.setMachineId(machineId);
        
        if (temperature > TEMP_THRESHOLD) {
            anomaly.setDetected(true);
            anomaly.setSeverity("HIGH");
            anomaly.setMessage("Temperature exceeds threshold: " + temperature + "°C");
        } else if (vibration > VIBRATION_THRESHOLD) {
            anomaly.setDetected(true);
            anomaly.setSeverity("MEDIUM");
            anomaly.setMessage("Vibration exceeds threshold: " + vibration + " mm/s");
        }
        
        return anomaly;
    }
}
