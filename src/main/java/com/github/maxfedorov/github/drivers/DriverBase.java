package com.github.maxfedorov.github.drivers;

import com.github.maxfedorov.github.config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;

public class DriverBase {
    static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);
}
