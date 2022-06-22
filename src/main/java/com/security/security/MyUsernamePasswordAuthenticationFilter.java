package com.security.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
@Configuration
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public MyUsernamePasswordAuthenticationFilter() {
        super();
        this.setAuthenticationSuccessHandler(
                (request, response, exception) -> {
//                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//                    PrintWriter out = response.getWriter();
//                    out.write("MyUsernamePasswordAuthenticationFilter - success");
//                    out.flush();
//                    out.close();
                    log.info("MyUsernamePasswordAuthenticationFilter - success");
                }
        );
        this.setAuthenticationFailureHandler(
                (request, response, exception) -> {
                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                    PrintWriter out = response.getWriter();
                    out.write("MyUsernamePasswordAuthenticationFilter - failure");
                    out.flush();
                    out.close();
                }
        );
    }

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //
        UsernamePasswordAuthenticationToken authRequest =
                UsernamePasswordAuthenticationToken.unauthenticated("ADMIN", "password");
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
        // 或者直接
        // return UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
        //                new UsernamePasswordAuthenticationToken(
        //                        authentication.getPrincipal(),
        //                        authentication.getCredentials(),
        //                        Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))
        //                );
    }

}
