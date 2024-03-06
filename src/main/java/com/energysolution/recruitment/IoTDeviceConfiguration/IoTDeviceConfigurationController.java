package com.energysolution.recruitment.IoTDeviceConfiguration;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IoTDeviceConfigurationController {

    private final IoTDeviceConfigurationService ioTDeviceConfigurationService;

    @GetMapping("/configurations")
    public List<IoTDeviceConfiguration> findAll(){
        return ioTDeviceConfigurationService.findAll();
    }

    @GetMapping("/configuration/{id}")
    public IoTDeviceConfiguration findById(@PathVariable Long id){
        return ioTDeviceConfigurationService.findById(id).orElse(null);
    }

    @PostMapping("/configuration/{id}")
    public IoTDeviceConfiguration save(
            @PathVariable Long id,
            @RequestBody IoTDeviceConfigurationRequest ioTDeviceConfigurationRequest){
        return ioTDeviceConfigurationService.update(id, ioTDeviceConfigurationRequest);
    }

    @DeleteMapping("/configuration/{deviceId}")
    public void deleteById(@PathVariable Long deviceId){
        ioTDeviceConfigurationService.deleteById(deviceId);
    }
}
