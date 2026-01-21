terraform {
  required_version = ">= 1.5.0"
  
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "~> 3.0"
    }
  }
}

provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "main" {
  name     = "iot-platform-rg-dev"
  location = var.location
  tags     = var.tags
}

module "aks" {
  source = "../../modules/aks"
  
  cluster_name        = "iot-platform-aks-dev"
  resource_group_name = azurerm_resource_group.main.name
  location            = var.location
  dns_prefix          = "iotdev"
  tags                = var.tags
}

module "iot_hub" {
  source = "../../modules/iot-hub"
  
  iothub_name         = "iot-platform-hub-dev"
  resource_group_name = azurerm_resource_group.main.name
  location            = var.location
  tags                = var.tags
}
