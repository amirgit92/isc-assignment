package ir.isc.assignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui/").authenticated();

        http.authorizeRequests()
                .antMatchers("/console-h2/**").permitAll();

        http.formLogin().permitAll()
                .and()
                .logout().permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
