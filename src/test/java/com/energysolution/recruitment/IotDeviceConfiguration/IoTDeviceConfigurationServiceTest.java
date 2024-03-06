package com.energysolution.recruitment.IotDeviceConfiguration;

import com.energysolution.recruitment.IoTDeviceConfiguration.IoTDeviceConfiguration;
import com.energysolution.recruitment.IoTDeviceConfiguration.IoTDeviceConfigurationRepository;
import com.energysolution.recruitment.IoTDeviceConfiguration.IoTDeviceConfigurationRequest;
import com.energysolution.recruitment.IoTDeviceConfiguration.IoTDeviceConfigurationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class IoTDeviceConfigurationServiceTest {

    @Mock
    private IoTDeviceConfigurationRepository ioTDeviceConfigurationRepository;
    @InjectMocks
    private IoTDeviceConfigurationService ioTDeviceConfigurationService;

    private final static String CONFIG_ID = "TEST00123";
    private final static Long CONFIG_DB_ID = 1L;
    private final static String CONFIG_STRING = "\"{\\\"server\\\":{\\\"ip\\\":\\\"192.168.0.90\\\",\\\"mask\\\":\\\"255.255.255.0\\\",\\\"gate\\\":\\\"192.168.0.1\\\",\\\"port\\\":80,\\\"dhcp\\\":false},\\\"dns\\\":{\\\"addrone\\\":\\\"8.8.8.8\\\",\\\"addrtwo\\\":\\\"8.8.4.4\\\",\\\"addrthree\\\":\\\"0.0.0.0\\\",\\\"addrfour\\\":\\\"0.0.0.0\\\"},\\\"client\\\":{\\\"host\\\":\\\"tdl.es-t.pl\\\",\\\"port\\\":2055},\\\"rtc\\\":{\\\"time\\\":1541504880,\\\"lastdataread\\\":1541504781,\\\"host\\\":\\\"tempus1.gum.gov.pl\\\",\\\"autosync\\\":true,\\\"clientinterval\\\":900,\\\"sntpinterval\\\":86850,\\\"datasaveinterval\\\":900,\\\"updateinterval\\\":30},\\\"info\\\":{\\\"mac\\\":\\\"54:10:ec:f4:c8:fc\\\",\\\"id\\\":\\\"TDLFORTEST_S\\\",\\\"apiversion\\\":\\\"2.0.0 - TS\\\",\\\"lastconfigstatus\\\":true,\\\"lastdatastatus\\\":true},\\\"onewire\\\":{\\\"data\\\":[],\\\"total\\\":0},\\\"registers\\\":{\\\"data\\\":[{\\\"id\\\":20000,\\\"reg\\\":40001,\\\"val\\\":25.900000,\\\"opt\\\":1073742084,\\\"divisor\\\":10.000000,\\\"dev\\\":10000,\\\"unit\\\":\\\"C\\\",\\\"desc\\\":\\\"TDL temperature\\\"},{\\\"id\\\":20001,\\\"reg\\\":40002,\\\"val\\\":23.800000,\\\"opt\\\":1073742340,\\\"divisor\\\":10.000000,\\\"dev\\\":10000,\\\"unit\\\":\\\"V\\\",\\\"desc\\\":\\\"TDL supply\\\"}],\\\"total\\\":2},\\\"devices\\\":{\\\"data\\\":[{\\\"id\\\":10000,\\\"slave\\\":0,\\\"baud\\\":9600,\\\"mode\\\":\\\"rtu\\\",\\\"frame\\\":0,\\\"name\\\":\\\"TDL parametrs\\\",\\\"desc\\\":\\\"TDL temperature and supply\\\",\\\"registers\\\":{\\\"data\\\":[{\\\"id\\\":20000,\\\"reg\\\":40001,\\\"val\\\":25.900000,\\\"opt\\\":1073742084,\\\"divisor\\\":10.000000,\\\"unit\\\":\\\"C\\\",\\\"desc\\\":\\\"TDL temperature\\\"},{\\\"id\\\":20001,\\\"reg\\\":40002,\\\"val\\\":23.800000,\\\"opt\\\":1073742340,\\\"divisor\\\":10.000000,\\\"unit\\\":\\\"V\\\",\\\"desc\\\":\\\"TDL supply\\\"}],\\\"total\\\":2}}],\\\"total\\\":1},\\\"pozyton\\\":{\\\"data\\\":[],\\\"total\\\":0},\\\"templates\\\":{\\\"data\\\":[],\\\"total\\\":0}}\"\n";
    private final static Instant updated = Instant.now();
    private final static IoTDeviceConfigurationRequest CONFIG_REQUEST = new IoTDeviceConfigurationRequest(CONFIG_ID, CONFIG_STRING);
    private final static IoTDeviceConfiguration.IoTDeviceConfigurationBuilder CONFIG_1 = IoTDeviceConfiguration.builder()
            .deviceIdentifier(CONFIG_ID)
            .deviceForeignId(CONFIG_DB_ID)
            .deviceConfiguration(CONFIG_STRING);

    @Test
    public void saveEmployeeTest() {

        IoTDeviceConfiguration build = CONFIG_1.build();
        IoTDeviceConfiguration buildWithId = CONFIG_1
                .id(CONFIG_DB_ID)
                .created(updated)
                .updated(updated)
                .build();

        given(ioTDeviceConfigurationRepository.findById(CONFIG_DB_ID))
                .willReturn(Optional.of(buildWithId));

        given(ioTDeviceConfigurationRepository.save(any(IoTDeviceConfiguration.class))).willReturn(buildWithId);
        System.out.println(buildWithId);

        // when
        IoTDeviceConfiguration savedConfig = ioTDeviceConfigurationService.save(CONFIG_DB_ID, CONFIG_REQUEST);

        // then
        assertThat(savedConfig).isNotNull();

        ioTDeviceConfigurationService.save(CONFIG_DB_ID, CONFIG_REQUEST);

        Assertions.assertThat(ioTDeviceConfigurationService.findById(CONFIG_DB_ID).isPresent());

    }


}
