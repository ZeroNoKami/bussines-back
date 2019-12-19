package es.itemShop.bussines.security;
import java.util.Arrays;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()   
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().authenticated()
                .and()
        .httpBasic();
    }
    
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter()
    {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        // Maybe I can just say "*" for methods and headers
        // I just copied these lists from another Dropwizard project
        config.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTIONS", "HEAD"));
        config.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept",
            "Authorization", "Access-Control-Allow-Credentials", "Access-Control-Allow-Headers", "Access-Control-Allow-Methods",
            "Access-Control-Allow-Origin", "Access-Control-Expose-Headers", "Access-Control-Max-Age",
            "Access-Control-Request-Headers", "Access-Control-Request-Method", "Age", "Allow", "Alternates",
            "Content-Range", "Content-Disposition", "Content-Description"));
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter());
        bean.setOrder(0);
        return bean;
    }
}