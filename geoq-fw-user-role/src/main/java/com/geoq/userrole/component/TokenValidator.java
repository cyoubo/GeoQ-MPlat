package com.geoq.userrole.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "validator")
public class TokenValidator {

    public enum TokenMode
    {
        admin,
        visit
    }

    private String admin_token;

    public TokenMode validate_token(String token)
    {
        if(token==null)
            return TokenMode.visit;

        if(token.trim().contentEquals(admin_token))
            return TokenMode.admin;
        else
            return TokenMode.visit;
    }
}