package com.test.responsetimedatabase.dbconfiguration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataBaseConfiguration {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.data-username}")
	private String dbUsername;
	
	@Value("${spring.datasource.data-password}")
	private String dbPassword;
	
	private JdbcTemplate jdbcTemplate;

	private DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.driverClassName);
		dataSource.setUrl(this.url);
		dataSource.setUsername(this.dbUsername);
		dataSource.setPassword(this.dbPassword);
		return dataSource;
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return Optional.ofNullable(this.jdbcTemplate).orElse(new JdbcTemplate(getDataSource()));
	}
}
