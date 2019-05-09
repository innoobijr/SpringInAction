package com.example.demo.config;

import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
    //DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService; // Need to configure security for the service

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Essentially shutting of the security settings in order to test the DB
       http
               .authorizeRequests().antMatchers("/").permitAll()
               .and()
               .authorizeRequests().antMatchers("/h2-console/**").permitAll();

       http.csrf().disable();
       http.headers().frameOptions().disable();
                //.authorizeRequests()
                    //.antMatchers("/design", "/orders")
                    //    .access("hasRole('ROLE_USER')")
                //    .antMatchers("/", "/**").access("permitAll"); // SpELs are much more powerful ways of specifying rules
                /*.and()
                    .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticate")
                        .usernameParameter("user")
                        .passwordParameter("pwd")
                .and()
                    .logout()
                        .logoutSuccessUrl("/");*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("buzz")
                    .password("infinity")
                    .authorities("ROLE_USER")
                ;
                //.userDetailsService(userDetailsService)
                //.passwordEncoder(encoder());
        /*auth //JDBC Example
                .inMemoryAuthentication()
                    .withUser("buzz")
                        .password("infinity")
                        .authorities("ROLE_USER")
                    .and()
                    .withUser("woody")
                        .password("bullseyes")
                        .authorities("ROLE_USER");
          im-memory user store
        .jdbcAuthentication()
                .dataSource(dataSource) // JDBC-based user store
                .usersByUsernameQuery( // this edits Spring's default user queries
                        "select username, password, enabled from Users " +
                        "where username=?")
                .authoritiesByUsernameQuery(
                        "select username, authority from UserAuthorities " +
                        "where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());// Using a password encoder from https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt*/

    }
    /* LDAP-backed user store
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .ldapAuthentication()
                .userSearchFilter("(uid={0})")
                .groupSearchFilter("member={0}");

        ****** LDAP password comparisons
        * the default strategy for authenticating against LDAP is to perform a bind operation (authenticating directly on the server)
        * Another options is the comparison operation:
        *   This involed send the entered passowrld to the LDAP directory and asking
        *   the server to compare teh password againsts a user's password attribute
        *
        *   auth
        *       .ldapAuthentication()
        *       .userSearchBase("ou=people")
        *       .userSearchFilter("(uid={0})")
        *       .groupSearchBase("ou=groups")
        *       .groupSearchFilter("member={0}")
        *       .passwordCompare();
        *       .passwordEncoder(new BCryptPasswordEncoder())
        *       .passwordAttribute("passcode") // attribute where the password is kept
        *       .contextSource() // assuming not using Spring default LDAP server. This is for a remote LDAP.
        *           .url("ldap://tacocloud.com:389/dc=tacocloud,dc=com");
        *        // but if you want to use an embedded server then:
        *           .contextSource()
        *               .root("dc=example,dc=com");
    }
     */
}
