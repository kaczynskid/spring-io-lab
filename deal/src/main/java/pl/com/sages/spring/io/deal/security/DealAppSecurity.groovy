package pl.com.sages.spring.io.deal.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.AuthenticationEntryPoint

//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client
import org.springframework.security.web.access.AccessDeniedHandler

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS

@Configuration
@EnableWebSecurity(debug = true)
@EnableWebMvcSecurity
//@EnableOAuth2Client
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class DealAppSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService

    @Autowired
    private PasswordEncoder passwordEncoder

    DealAppSecurity() {
        super(true)
    }

    @Bean
    static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder()
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder)
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .regexMatchers("/", "/games.*")
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //log.info("##### configuring security #####")

        http.securityContext()
            .securityContextRepository(new RequestBasedSecurityContextRepository())

        http.servletApi()
            .rolePrefix("ROLE_")

        http.csrf()
            .disable()

        http.anonymous()
            .disable()
//            .principal(new User("player", "player", Arrays.asList(
//                new SimpleGrantedAuthority("PLAYER")
//            )))

        http.sessionManagement()
            .sessionCreationPolicy(STATELESS)

        http.exceptionHandling()
            .authenticationEntryPoint({ HttpServletRequest req, HttpServletResponse res, AuthenticationException e ->
                    res.sendError(SC_UNAUTHORIZED, "You have to pass credentials to use this service!")
                } as AuthenticationEntryPoint)
            .accessDeniedHandler({ HttpServletRequest req, HttpServletResponse res, AccessDeniedException e ->
                    res.sendError(SC_FORBIDDEN, "You not have required permission to use this service!")
                } as AccessDeniedHandler)


        http.httpBasic()
            .realmName("Spring IO")

        http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().permitAll()

    }
}
