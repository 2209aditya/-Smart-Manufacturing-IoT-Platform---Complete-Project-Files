package com.iot.telemetry.model;

public class TelemetryData {
    private String machineId;
    private double temperature;
    private double vibration;
    private double rpm;
    private long timestamp;
    
    // Constructors
    public TelemetryData() {
        this.timestamp = System.currentTimeMillis();
    }
    
    // Getters and Setters
    public String getMachineId() {
        return machineId;
    }
    
    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }
    
    public double getTemperature() {
        return temperature;
    }
    
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    public double getVibration() {
        return vibration;
    }
    
    public void setVibration(double vibration) {
        this.vibration = vibration;
    }
    
    public double getRpm() {
        return rpm;
    }
    
    public void setRpm(double rpm) {
        this.rpm = rpm;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
