package br.ufg.api.ocd.config.security;

/*
import br.ufg.api.ocd.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
*/

public class OAuth2ServerConfiguration {
/*
    private static final String RESOURCE_ID = "restservice";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends
            ResourceServerConfigurerAdapter {

        @Autowired
        CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources
                    .resourceId(RESOURCE_ID);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {


            http
                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .and().authorizeRequests()
                    .antMatchers("/usuario/**").permitAll()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/tipoDeUsuario/**").hasAnyRole("ADM, USER")
                    .antMatchers("/tipoDeLesao/**").hasAnyRole("ADM, USER")
                    .antMatchers("/tipoDeCancer/**").hasAnyRole("ADM, USER")
                    .antMatchers("/rastreamento/**").hasAnyRole("ADM, USER")
                    .antMatchers("/localAtendimento/**").hasAnyRole("ADM, USER")
                    .antMatchers("/lesao/**").hasAnyRole("ADM, USER")
                    .antMatchers("/fatorVunerabilidade/**").hasAnyRole("ADM, USER")
                    .anyRequest().authenticated().and().csrf().disable().formLogin().successHandler(customizeAuthenticationSuccessHandler)
                    .loginPage("/login").failureUrl("/login?error=true")
                    .usernameParameter("cpf")
                    .passwordParameter("senha")
                    .and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/").and().exceptionHandling();
        }

        @Configuration
        @EnableAuthorizationServer
        @EnableGlobalMethodSecurity(
                prePostEnabled = true
        )
        protected static class AuthorizationServerConfiguration extends
                AuthorizationServerConfigurerAdapter {

            private TokenStore tokenStore = new InMemoryTokenStore();

            @Autowired
            AuthenticationManager authenticationManager;

            @Autowired
            @Qualifier("myUserDetailsService")
            private MyUserDetailsService userDetailsService;

            @Override
            public void configure(AuthorizationServerEndpointsConfigurer endpoints)
                    throws Exception {
                endpoints
                        .tokenStore(this.tokenStore)
                        .authenticationManager(this.authenticationManager)
                        .userDetailsService(userDetailsService);
            }

            @Override
            public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
                clients
                        .inMemory()
                        .withClient("client")
                        .authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("all")
                        .refreshTokenValiditySeconds(300000)
                        .resourceIds(RESOURCE_ID)
                        .secret("{noop}123")
                        .accessTokenValiditySeconds(50000)
                ;

            }

            @Bean
            @Primary
            public DefaultTokenServices tokenServices() {
                DefaultTokenServices tokenServices = new DefaultTokenServices();
                tokenServices.setSupportRefreshToken(true);
                tokenServices.setTokenStore(this.tokenStore);
                return tokenServices;
            }

        }
    }
    */

}
