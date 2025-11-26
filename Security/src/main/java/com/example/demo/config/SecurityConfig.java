package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final String CUSTOMER_ROLE = "CUSTOMER";
    private final String MANAGER_ROLE = "MANAGER";
 
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder() ; 
    }
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = passwordEncoder() ; 
		auth.inMemoryAuthentication()
		.withUser("Nirmit")
		.password(encoder.encode("Sahu"))
		.roles(CUSTOMER_ROLE) ;
		
		auth.inMemoryAuthentication()
		.withUser("Anshu")
		.password(encoder.encode("Sahu"))
		.roles(MANAGER_ROLE) ; 
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll() 
        .antMatchers("/offers").authenticated() 
        .antMatchers("/balance").hasAnyRole(CUSTOMER_ROLE, MANAGER_ROLE) 
        .antMatchers("/loanApprove").hasRole(MANAGER_ROLE) 
        .anyRequest().authenticated() 
		.and().httpBasic() 
        .and().csrf().disable(); 
	}
}
