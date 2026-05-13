package com.ecommerce.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * @Configuration
 * Tells Spring:
this class contains Spring configuration
 */

/*
 * @ComponentScan(basePackages = "com.ecommerce")
 * @ComponentScan
Spring scans packages and automatically creates beans for:

controllers
services
repositories

This is part of IOC (Inversion of Control).
 */
/*
 * // Enables Spring MVC configuration manually in a pure Spring Framework application.
// It activates:
// 1. Request mapping (@GetMapping, @PostMapping, etc.)
// 2. REST controller support (@RestController)
// 3. JSON/XML message converters
// 4. DispatcherServlet MVC processing
// 5. Handler mappings and adapters
// 6. Static resource handling
// 7. Validation and formatting support
//
// Similar to what Spring Boot auto-configures internally.
@EnableWebMvc
 */
/*
 * // Marks this class as a Spring configuration class.
// Used to define beans and application configuration using Java code
// instead of XML configuration.
//
// Similar to traditional XML configuration files like applicationContext.xml.
//
// Spring IOC container reads this class during application startup.
@Configuration
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ecommerce")
public class AppConfig {

}





