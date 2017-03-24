package com.subratrout.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by subratrout on 3/24/17.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.subratrout")
@ActiveProfiles("jpadao")
public class JpaIntegrationConfig {
}
