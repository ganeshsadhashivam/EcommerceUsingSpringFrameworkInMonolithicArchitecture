package com.ecommerce.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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

	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		
		ds.setDriverClassName( "com.mysql.cj.jdbc.Driver");
		
		 ds.setUrl(
	                "jdbc:mysql://localhost:3306/ecommercespringframeworkdb"
	        );

	        ds.setUsername("root");

	        ds.setPassword("root");
	        
	        return ds;
	}
	
	@Bean
    public JdbcTemplate jdbcTemplate() {

        JdbcTemplate jdbcTemplate =
                new JdbcTemplate();

        jdbcTemplate.setDataSource(
                dataSource()
        );

        return jdbcTemplate;
    }
}





