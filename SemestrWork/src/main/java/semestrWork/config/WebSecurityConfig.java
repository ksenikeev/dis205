package semestrWork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer ->
                        httpSecurityCorsConfigurer.configurationSource(request ->
                                new CorsConfiguration().applyPermitDefaultValues()))
                .authorizeHttpRequests(requests -> requests
                        //.requestMatchers( "/**").permitAll()
                        //.requestMatchers( "/client/login").permitAll()
                        .requestMatchers( "/client/registration").permitAll()
                        .requestMatchers( "/client/registercheck").permitAll()
                        .requestMatchers( "/client/logincheck").permitAll()
                        .requestMatchers( "/static/**").permitAll()
                        .anyRequest().authenticated()
                );
        http.formLogin(formLogin ->
                        formLogin
                                .loginPage("/client/login").permitAll()
                                .loginProcessingUrl("/client/logincheck")// /login (POST)
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/client/clientaccount")
                                .failureUrl("/login?error")
                                .permitAll())
                .logout((logout) ->
                        logout.permitAll()
                );

        return http.build();
    }

}