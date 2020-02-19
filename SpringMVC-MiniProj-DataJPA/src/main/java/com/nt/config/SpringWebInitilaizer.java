package com.nt.config;

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.AbstractContextLoaderInitializer;


@Configuration
@ComponentScan(basePackages = "com.nt.controller")
public class SpringWebInitilaizer {

}
