package com.energysolution.recruitment.IoTDeviceConfiguration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "IOT_DEVICE_ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
public class IoTDeviceAddress {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ADDRESS_ID", nullable = false)
    public Long ADDRESS_ID;

    @Column(name = "NAME", nullable = false)
    public String NAME;

    @Column(name = "COUNTRY", nullable = false)
    public String COUNTRY;

    @Column(name = "POSTAL_CODE", nullable = false)
    public String POSTAL_CODE;

    @Column(name = "CITY", nullable = false)
    public String CITY;

    @Column(name = "STREET", nullable = false)
    public String STREET;

    @Column(name = "BUILDING_NUMBER", nullable = false)
    public String BUILDING_NUMBER;

    @Column(name = "APARTMENT_NUMBER")
    public String APARTMENT_NUMBER;
}
