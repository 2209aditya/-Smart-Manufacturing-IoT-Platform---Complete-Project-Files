resource "azurerm_iothub" "main" {
  name                = var.iothub_name
  resource_group_name = var.resource_group_name
  location            = var.location

  sku {
    name     = "S1"
    capacity = 2
  }

  endpoint {
    type              = "AzureIotHub.EventHub"
    name              = "telemetry-endpoint"
  }

  route {
    name           = "telemetry-route"
    source         = "DeviceMessages"
    condition      = "true"
    endpoint_names = ["telemetry-endpoint"]
    enabled        = true
  }

  tags = var.tags
}
