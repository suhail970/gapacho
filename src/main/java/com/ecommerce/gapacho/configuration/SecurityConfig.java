package com.ecommerce.gapacho.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.csrf(crfs -> crfs.disable())
                .authorizeHttpRequests(web ->
                        web.anyRequest().permitAll())
                .formLogin(form -> form.disable())
                .httpBasic(base -> base.disable());

        return http.build();
    }
}
