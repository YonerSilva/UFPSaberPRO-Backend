package com.ufps.UFPSaberPRO.security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.ufps.UFPSaberPRO.security.jwt.*;

@Configuration
@EnableWebSecurity
public class MainSecurity extends WebSecurityConfigurerAdapter{
	private static final String [] AUTH_WHITELIST = {
			/*"/auth/**",
			"/v3/api-docs",
			"/swagger-resources",
			"/swagger-resources/**",
			"/configuration/ui",
			"/configuration/security",
			"/swagger",
			"/webjars/**"*/
			"/**"
	};
	
    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    	http.csrf().disable()
    		.cors().configurationSource(corsConfigurationSource()).and()
    		.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
    		.anyRequest()
    		.authenticated()
    		.and()
            .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    		.and()
    		.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
    	CorsConfiguration config = new CorsConfiguration();
    	config.setAllowedHeaders(Arrays.asList("*"));
    	config.setAllowedOrigins(Arrays.asList("*"));
    	config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
    	config.setExposedHeaders(Arrays.asList("Access-Control-Allow-Headers","Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Request-With,"+
    	"Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers"));
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("/**", config);
    	return source;
    }
    
    /*@Override 
    public void configure(WebSecurity web) throws Exception{
    	web.ignoring().antMatchers(AUTH_WHITELIST);
    }*/
}
