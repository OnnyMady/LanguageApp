package proj.LanguageApp.webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {


    public static final MediaType AUDIO = new MediaType("audio", "mpeg");
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                        .anyRequest().permitAll()
                )
                .httpBasic(withDefaults());
        http.csrf((authz) -> authz
                        .disable()
                )
                .httpBasic(withDefaults());
        http.cors((authz) -> authz
                        .disable()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

}
