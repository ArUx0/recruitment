package com.energysolution.recruitment.IoTDeviceConfiguration;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Builder
@Table(name = "IOT_DEVICE_CONFIG")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IoTDeviceConfiguration {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long id;

    @Column(name = "DEVICE_ID", unique = true, nullable = false)
    public String deviceIdentifier;

    @Column(name = "DEVICE_FOREIGN_ID", nullable = false)
    @JoinTable(name = "IOT_DEVICE")
    public Long deviceForeignId;

    @Column(name = "DEVICE_CONFIGURATION", length = 10000, nullable = false)
    public String deviceConfiguration;

    @Column(name = "CREATED", nullable = false, updatable = false)
    @CreationTimestamp
    public Instant created;

    @Column(name = "UPDATED")
    @UpdateTimestamp
    public Instant updated;

}
