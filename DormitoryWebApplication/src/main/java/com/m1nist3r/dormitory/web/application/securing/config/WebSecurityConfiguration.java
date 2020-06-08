package com.m1nist3r.dormitory.web.application.securing.config;

import com.m1nist3r.dormitory.web.application.securing.auth.DormitoryAdministratorDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final DormitoryAdministratorDetailsService dormitoryAdministratorDetailsService;

    public WebSecurityConfiguration(DormitoryAdministratorDetailsService dormitoryAdministratorDetailsService) {
        this.dormitoryAdministratorDetailsService = dormitoryAdministratorDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(dormitoryAdministratorDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(11));
        provider.setAuthoritiesMapper(authoritiesMapper());
        return provider;
    }

    @Bean
    public GrantedAuthoritiesMapper authoritiesMapper() {
        SimpleAuthorityMapper authorityMapper = new SimpleAuthorityMapper();
        authorityMapper.setConvertToUpperCase(true);
        authorityMapper.setDefaultAuthority("RECEPTIONIST");
        return authorityMapper;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/registration",
                        "/css/*", "/js/*", "/img/*", "/favicon.ico").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login.html?error=true")

                .and()
                .logout().deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .clearAuthentication(true)
                //   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll()

                .and()
                .rememberMe().key("superOmegaLulKey")
                .userDetailsService(dormitoryAdministratorDetailsService)
        ;
    }


}
