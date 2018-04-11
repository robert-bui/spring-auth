/*
package com.gobear.security.service.impl;

import com.gobear.couchbase.service.CouchbaseUserService;
import com.gobear.model.UserInfo;
import com.gobear.security.service.LoginService;
import com.gobear.security.utils.CookieUtils;
import com.gobear.security.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class LoginServiceImpl implements LoginService {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";

    @Autowired
    private CouchbaseUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public boolean isAuthenSuccess(String username, String password, HttpServletResponse httpServletResponse) {

        UserInfo user = userService.findByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return false;
        }


        // login success
        String token = TokenUtils.generateToken(username);
        CookieUtils.create(httpServletResponse, token, false, -1, "localhost");

        return true;
    }
}
*/
