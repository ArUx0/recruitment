package com.energysolution.recruitment.IoTDeviceConfiguration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "IOT_DEVICE")
@NoArgsConstructor
@AllArgsConstructor
public class IoTDevice {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long ID;

    @Column(name = "DEVICE_ID", unique = true, nullable = false)
    public String DEVICE_ID;

    @PrimaryKeyJoinColumn(name = "ADDRESS_ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public IoTDeviceAddress ADDRESS;

    @Column(name = "TURNED_ON_AT")
    public Instant TURNED_ON_AT;

    @Column(name = "TURNED_OFF_AT")
    public Instant TURNED_OFF_AT;

    @Column(name = "CREATED", nullable = false, updatable = false)
    @CreationTimestamp
    public Instant CREATED;

    @Column(name = "UPDATED")
    @UpdateTimestamp
    public Instant UPDATED;

}
