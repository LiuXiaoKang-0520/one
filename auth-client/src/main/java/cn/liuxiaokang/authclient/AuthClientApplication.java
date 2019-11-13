package cn.liuxiaokang.authclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@SpringBootApplication
@EnableOAuth2Sso
@EnableZuulProxy
public class AuthClientApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(AuthClientApplication.class, args);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http    .csrf().disable()
                .authorizeRequests().antMatchers("/index.html", "/app.html", "/").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout(logout -> {
                    logout.logoutSuccessUrl("/");
                });
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.js", "/*.ico", "/*.map");
    }
}
