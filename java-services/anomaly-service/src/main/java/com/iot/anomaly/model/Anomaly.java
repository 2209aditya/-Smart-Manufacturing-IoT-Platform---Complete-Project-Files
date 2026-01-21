package com.iot.anomaly.model;

public class Anomaly {
    private String machineId;
    private boolean detected;
    private String severity;
    private String message;
    private long timestamp;
    
    public Anomaly() {
        this.timestamp = System.currentTimeMillis();
    }
    
    // Getters and Setters
    public String getMachineId() { return machineId; }
    public void setMachineId(String machineId) { this.machineId = machineId; }
    
    public boolean isDetected() { return detected; }
    public void setDetected(boolean detected) { this.detected = detected; }
    
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
