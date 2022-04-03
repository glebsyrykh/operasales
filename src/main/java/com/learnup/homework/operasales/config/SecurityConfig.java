package com.learnup.homework.operasales.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails user = User.withUsername("user1")
                .password("12345").roles("USER").build();
        UserDetails admin = User.withUsername("admin1")
                .password("67890").roles("ADMIN").build();
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(user);
        userDetailsManager.createUser(admin);

        return userDetailsManager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/tickets").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/v1/premiere").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/premiere").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/premiere").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/premiere").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin(Customizer.withDefaults());
    }


}