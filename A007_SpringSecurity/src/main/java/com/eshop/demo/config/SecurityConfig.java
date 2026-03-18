package com.eshop.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

			
	   @Bean
	    public InMemoryUserDetailsManager userDetailsService() {

	        UserDetails user1 = User.withDefaultPasswordEncoder()
	                .username("admin")
	                .password("admin123")
	                .roles("ADMIN")
	                .build();

	        UserDetails user2 = User.withDefaultPasswordEncoder()
	                .username("user")
	                .password("user123")
	                .roles("USER")
	                .build();

	        return new InMemoryUserDetailsManager(user1, user2);
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http
	            .authorizeHttpRequests(auth -> auth
	            	.requestMatchers("/WEB-INF/jsps/**").permitAll()
	            	.requestMatchers("/login","/doLogin","/logout").permitAll()
	                .requestMatchers("/admin").hasRole("ADMIN")
	                .requestMatchers("/user").hasRole("USER")
	                .anyRequest().authenticated()
	            )
	            .formLogin(form -> form
	                    .loginPage("/login")        // custom login page URL
	                    .loginProcessingUrl("/doLogin")
	                    .defaultSuccessUrl("/home", true)
	                    .failureUrl("/fail")
	                    .permitAll()
	                ). logout(logout -> logout
	                        .logoutUrl("/logout")
	                        .logoutSuccessUrl("/login?logout=true")
	                    );

	        return http.build();
	    }
	
}
