package br.com.felipe_scherer.security;

import java.util.Arrays;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.userDetailsService(userDetailsService())
			.formLogin()
			.defaultSuccessUrl("/veiculos.jsf").and()
			.authorizeRequests()
			.antMatchers("/veiculos.jsf")
			.hasRole("ADMIN")
			.anyRequest().authenticated();
		
		
	}
	
	
	@Override
	protected UserDetailsService userDetailsService() {
		UserDetails user1 = new User("sa", "Abcd1234", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
		UserDetails user2 = new User("user", "123", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
		return new InMemoryUserDetailsManager(Arrays.asList(user1, user2));
	}

}
