//package ir.isc.assignment.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    protected void configure(HttpSecurity http ) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/h2-console/**").authenticated()
//                .antMatchers("/swagger-ui/**").authenticated();
//    }
//}
