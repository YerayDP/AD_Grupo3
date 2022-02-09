package com.example.demo.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/","/api/**","/auth/**","assets/**","/css/**","/js/**","/public/**","/static/**").permitAll()
		.antMatchers(HttpMethod.POST,"/api/**").permitAll()
		.antMatchers(HttpMethod.PUT,"/api/**").permitAll()
		.antMatchers(HttpMethod.DELETE,"/api/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/auth/login").failureUrl("/login?error")
		.usernameParameter("email")
		.defaultSuccessUrl("/",true)
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/auth/login?logout")
		.permitAll();
	}

	
	
}
