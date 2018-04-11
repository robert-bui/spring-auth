package com.gobear.security.service.impl;

import com.gobear.security.utils.CookieUtils;
import com.gobear.security.utils.TokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("Authen success!!! " + authentication);

        String token = TokenUtils.generateToken(authentication.getName());
        System.out.println("Token generated: " + token);

        System.out.println("Request from: " + httpServletRequest.getRequestURL());

        CookieUtils.create(httpServletResponse, token, false, -1, "localhost");

        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/hello");

    }
}
