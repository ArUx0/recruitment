package com.energysolution.recruitment.IoTDeviceConfiguration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IoTDeviceConfigurationRequest {
    public String identifier;
    public String configuration;
}
