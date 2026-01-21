variable "location" {
  description = "Azure region"
  type        = string
  default     = "eastus"
}

variable "tags" {
  description = "Resource tags"
  type        = map(string)
  default     = {
    environment = "dev"
    project     = "iot-platform"
    managed_by  = "terraform"
  }
}
