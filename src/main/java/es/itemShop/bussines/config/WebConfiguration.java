package es.itemShop.bussines.config;

import java.util.Arrays;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
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
        config.setAllowedHeaders(Arrays.asList( 
            "Access-Control-Allow-Headers", 
            "Access-Control-Allow-Methods",
            "Access-Control-Allow-Origin",
            "Access-Control-Request-Headers",
            "Access-Control-Request-Method"));
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter());
        bean.setOrder(0);
        return bean;
    }
}