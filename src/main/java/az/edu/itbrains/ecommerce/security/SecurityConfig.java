package az.edu.itbrains.ecommerce.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService userDetailService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        http
                .csrf(x->x.disable())
                .authorizeHttpRequests((request) -> request
                                .requestMatchers("/cart").authenticated()
                                .requestMatchers("/checkout").authenticated()
                                .anyRequest().permitAll()
                        )
                .formLogin((form) ->{
                    form
                            .loginPage("/login")
                            .failureUrl("/login")
                            .defaultSuccessUrl("/");
                })
                .exceptionHandling(e -> {
                    e.accessDeniedPage("/");
                });

       return http.build();
    }



    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }
}
