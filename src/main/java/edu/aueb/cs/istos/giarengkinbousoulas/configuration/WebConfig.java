package edu.aueb.cs.istos.giarengkinbousoulas.configuration;

import edu.aueb.cs.istos.giarengkinbousoulas.dao.UserDAO;
import edu.aueb.cs.istos.giarengkinbousoulas.dao.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {

    @Bean
    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/istos");
        ds.setUsername("root");
        ds.setPassword("linuxtoor");

        return ds;
    }

    @Bean
    public UserDAO getUserDao() {
        return new UserDAOImpl(getDataSource());
    }

}