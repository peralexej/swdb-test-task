package com.swedbank.conf;

import java.io.IOException;
import java.util.Properties;

/**
 * Copyright (c) 2020.
 * Class for working with config file (config.properties)
 *
 * @author Aleksei Perov
 * @version 1.0
 * @since 1.0
 */
public final class ConfigProperties {
    private static final String DRIVER_TYPE = "driver.type";
    private static final String ENV = "env";
    private static final String MAX_WAIT_TIME = "max_wait_time";
    private static ConfigProperties instance = null;
    private Properties props;

    private ConfigProperties() {
        try {
            props = new Properties();
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to load configuration file", e);
        }
    }

    public static ConfigProperties getInstance() {
        if (instance == null) {
            instance = new ConfigProperties();
        }
        return instance;
    }


    private String getProperty(final String key) {
        return props.getProperty(key);
    }


    public String getDriverType() {
        return getProperty(DRIVER_TYPE);
    }


    public String getDefaultEnvAddress() {
        return getProperty(ENV);
    }

}
