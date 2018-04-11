package com.gobear.security;

import com.gobear.couchbase.service.CouchbaseUserService;
import com.gobear.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenProvider implements AuthenticationProvider {

    @Autowired
    private CouchbaseUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) authentication;

        UserInfo user = userService.findByUsername(authenticationToken.getName());
        if (!passwordEncoder.matches(authenticationToken.getCredentials().toString(), user.getPassword())) {
            throw new BadCredentialsException("Username or password is not correct!");
        }

        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole()));
    }

    @Override
    public boolean supports(Class<?> authenClass) {
        return UsernamePasswordAuthenticationToken.class.equals(authenClass);
    }

}
