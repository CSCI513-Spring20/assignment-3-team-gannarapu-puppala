variable "region" {
  default = "us-east-1"
}

variable "access_key" {
  default = "AKIAYV5ZXJLNHYH5EEZ5"
}

variable "secret_key" {
  default = "ua8PDuBmdMa/AUrXkix1KGDFuArvyTFNinhuJaI4"
}

variable "cidr_block" {
  default = "10.0.0.0/24"
}

variable "tenancy" {
  default = "default"
}

variable "dnshost" {
  default = "true"
}

variable "subcidr" {
  default = "10.0.0.0/24"
}

variable "ami" {
  default = "ami-08f3d892de259504d"
}

variable "instancetype" {
  default = "t2.micro"
}
