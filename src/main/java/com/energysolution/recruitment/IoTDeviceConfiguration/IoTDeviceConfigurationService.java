package com.energysolution.recruitment.IoTDeviceConfiguration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IoTDeviceConfigurationService {

    private final IoTDeviceConfigurationRepository ioTDeviceConfigurationRepository;

    public List<IoTDeviceConfiguration> findAll() {
        return ioTDeviceConfigurationRepository.findAll();
    }

    public Optional<IoTDeviceConfiguration> findById(Long Id) {
        return ioTDeviceConfigurationRepository.findById(Id);
    }

    public void deleteById(Long Id) {
        ioTDeviceConfigurationRepository.deleteById(Id);
    }

    public IoTDeviceConfiguration save(Long deviceId,
                                       IoTDeviceConfigurationRequest ioTDeviceConfigurationRequest) {
        return ioTDeviceConfigurationRepository.save(IoTDeviceConfiguration.builder()
                .deviceIdentifier(ioTDeviceConfigurationRequest.identifier)
                .deviceForeignId(deviceId)
                .deviceConfiguration(ioTDeviceConfigurationRequest.configuration)
                .build()
        );
    }

    public IoTDeviceConfiguration update(Long Id,
                                       IoTDeviceConfigurationRequest ioTDeviceConfigurationRequest) {

        Optional<IoTDeviceConfiguration> ioTDeviceConfigurationOptional = ioTDeviceConfigurationRepository.findById(Id);
        if(ioTDeviceConfigurationOptional.isPresent()){
            IoTDeviceConfiguration ioTDeviceConfiguration = ioTDeviceConfigurationOptional.get();
            ioTDeviceConfiguration.setDeviceForeignId(Id);
            ioTDeviceConfiguration.setDeviceConfiguration(ioTDeviceConfigurationRequest.configuration);
            return ioTDeviceConfigurationRepository.save(ioTDeviceConfiguration);
        }
        return save(Id, ioTDeviceConfigurationRequest);
    }
}
