package com.energysolution.recruitment.IoTDeviceConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IoTDeviceConfigurationRepository extends JpaRepository<IoTDeviceConfiguration, Long> {

}
