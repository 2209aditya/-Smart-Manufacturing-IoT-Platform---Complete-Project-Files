output "iothub_id" {
  description = "IoT Hub ID"
  value       = azurerm_iothub.main.id
}

output "iothub_name" {
  description = "IoT Hub name"
  value       = azurerm_iothub.main.name
}
