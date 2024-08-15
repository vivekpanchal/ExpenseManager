package com.vivek.ExpenseManager.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final UserDetails principal;
    private String credentials;

    public JwtAuthenticationToken(UserDetails principal, String credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false); // Not authenticated at this point
    }

    public JwtAuthenticationToken(UserDetails principal, String credentials,
                                  Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true); // Authenticated now
    }

    @Override
    public String getCredentials() {
        return this.credentials;
    }

    @Override
    public UserDetails getPrincipal() {
        return this.principal;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                "Cannot set this token to trusted - use constructor with GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }
}
