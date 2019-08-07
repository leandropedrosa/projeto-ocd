package br.ufg.api.ocd.config.security;

import br.ufg.api.ocd.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Bean
    public UserDetailsService mongoUserDetails() {
        return new UsuarioService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetailsService userDetailsService = mongoUserDetails();
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/projeto-ocd/projet-backend/login").permitAll()
                .antMatchers("/projeto-ocd/projet-backend/signup").permitAll()
                .antMatchers("/projeto-ocd/projet-backend/home/**").hasAuthority("ADM")
                .antMatchers("/projeto-ocd/projet-backend/passo1/**").hasAuthority("ADM")
                .antMatchers("/projeto-ocd/projet-backend/passo2/**").hasAuthority("ADM")
                .antMatchers("/projeto-ocd/projet-backend/passo3/**").hasAuthority("ADM")
                .antMatchers("/projeto-ocd/projet-backend/passo4/**").hasAuthority("ADM").anyRequest()
                .authenticated().and().csrf().disable().formLogin().successHandler(customizeAuthenticationSuccessHandler)
                .loginPage("/projeto-ocd/projet-backend/login").failureUrl("/projeto-ocd/projet-backend/login?error=true")
                .usernameParameter("email")
                .passwordParameter("senha")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/projeto-ocd/projet-backend/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling();
    }
}
