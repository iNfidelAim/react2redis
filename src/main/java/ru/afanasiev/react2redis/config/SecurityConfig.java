package ru.afanasiev.react2redis.config;


import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.afanasiev.react2redis.services.PersonDetailsService;


@EnableWebFluxSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final  PersonDetailsService personDetailsServicel;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsServicel) {
        this.personDetailsServicel = personDetailsServicel;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsServicel);


    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}

    /*    http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll();*/
