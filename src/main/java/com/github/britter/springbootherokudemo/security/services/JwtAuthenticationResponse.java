package com.github.britter.springbootherokudemo.security.services;

public class JwtAuthenticationResponse {
    private final String token;
    private final String kodekantor;

    public JwtAuthenticationResponse(String token,String kodekantor) {
        this.token = token;
        this.kodekantor=kodekantor;
    }

    public String getToken() {
        return this.token;
    }

    public String getKodekantor() {
        return kodekantor;
    }
}
