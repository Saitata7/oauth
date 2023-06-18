package com.security3.Oauth.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimAccessor;
import org.springframework.security.oauth2.jwt.JwtTimestampValidator;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
@Configuration
public class ConfigOauth2 extends AuthorizationServerConfigurerAdapter {
    private String clientId="sai";
    private String clientSecret="secret";
    private String privateKey="-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAzvP2U7wxro5Awexs5PIAQkX9QqzBwH4R33y/VgYfRyx1IN6u\n" +
            "cfLS9UhCG+pTOV91KKu/mGxTsoqNwS4RybAmkdvOXpBWZ7lLTepWf09TLm+6yc12\n" +
            "g7qGV9X1m/gct0a6E+7AicTaavggiZ/E3eUsQqquiuBOgmF2fbOB4mSmGMRpSyCb\n" +
            "Ih6mUaHd/pBBGItH25sBSSsHKHerC+Nr6bAUxdHFep+M99bAdyavuZRGQ3+CLlb+\n" +
            "5p8qLQhtEEQQmvC8B6yq8mchKTE6ywu+oZolCYu8Z64N2laKBaGCwHG/j1F4SIFq\n" +
            "PuqEZeUzg+/BYXM8YQKrNbbte8vcYn456HsYEwIDAQABAoIBADxNKcFMXM2X9ZaL\n" +
            "5U7wlNK6wgjjfbExCtQr7TSLpCGA+sARIpNhRcbivyCTLpzRC7pGERXAusKTTKq1\n" +
            "WcmC4jot6fvz4rlmbGLPnVSLMJmfRLX4gEfx2aNOXLqNmRBuM1oLf16lVV9F3XU8\n" +
            "cIiXdkYWpbUhlr6212fZHkdxPFSKoFsDqbMEoEONH+8r0HOqDqrynwZP/tNVQ68o\n" +
            "WXbnpYR10jEB5jxVKeupHve1zOlhxgwtDTPJg9hSJcbracpFRxjhoeHuvdoOq6UX\n" +
            "RBPOTwxK/rzWV44Eq/aReRezm0lrmzZfslF/h/qMW/ke55dT5eB1i9L5j2XGdjxC\n" +
            "SLv4WAECgYEA6lj9yZVD2vgWnSnn/lEpxXbQzFqjV9jhXkbDVY5farGo87sXqIA+\n" +
            "mVUT9dveSi2lDs+9VCpUO8PIcQOxK2TUbFJnmXAWtaZkznCj1IOw0m+2+Qkl05l3\n" +
            "pgvunp1jOrjshQqdXV9ZXbvMKxRqaGvs5VQKyAmJsSp+xqJE6GtaQIECgYEA4hMB\n" +
            "1JIh2wFr4+WNWMWGKCGitpTiWO6UmNtFgiaIzYXMEXgMkV+9ZCVbZ5iUWrBOtvaH\n" +
            "TyKEUE221yRCczz8p60AgAiUavbHoL8t/DNUNdLcA+8/j+LCA61fdQM/mSWqRvm/\n" +
            "5gieNycXH1Aqf85wmzOjiIqW8y8CtWfzwUOhDpMCgYBGs2p9sqayHT7VU5tGQr5T\n" +
            "cLE1tfKpwijcBIVR/o4S5l6OiddtYqOAJwbKmfbKclLl0Q7RoaOgFEUYs4B0Ewtz\n" +
            "UrkmtYZkbzrifWEv8Dscgc+1+miLGjXaxqbK+7jAMqJI0RcA4I9ZlBrYtGQV9NmX\n" +
            "pm9KQnZkGOn+i142sIyeAQKBgQDh41IB3x264Vm3Naec2oho0urs+iiL6Z9KeFWk\n" +
            "bPJmQNkdX1FXdE0dooIJKhiZ4O5VvFCIzplcT7pwj0diM77Tn3YPeAMsOXZP9JZz\n" +
            "F6p9uTmjKMve7hkjaXkmxt8mG89e6a9HnrbPrtxYqlY8q74yJU+yX5/iTserELor\n" +
            "EnL7xwKBgQChbqhTjIskZmL8RUW5/HndtrKf36NjpwH1nSw3hscdKDLwHkuNd3Nu\n" +
            "Hg7UMrXSUFt1SnSF1F2OkpdyGh5Oh1o+6O8mj7Y5q2twGhcxYA8/dpNG4kgEx6aw\n" +
            "shyZLnELFzRYU5ej87y/0zi4N2OjcRgiMhbRAV/YmvT7wXfRpf7h+A==\n" +
            "-----END RSA PRIVATE KEY-----";
    private String publicKey="-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzvP2U7wxro5Awexs5PIA\n" +
            "QkX9QqzBwH4R33y/VgYfRyx1IN6ucfLS9UhCG+pTOV91KKu/mGxTsoqNwS4RybAm\n" +
            "kdvOXpBWZ7lLTepWf09TLm+6yc12g7qGV9X1m/gct0a6E+7AicTaavggiZ/E3eUs\n" +
            "QqquiuBOgmF2fbOB4mSmGMRpSyCbIh6mUaHd/pBBGItH25sBSSsHKHerC+Nr6bAU\n" +
            "xdHFep+M99bAdyavuZRGQ3+CLlb+5p8qLQhtEEQQmvC8B6yq8mchKTE6ywu+oZol\n" +
            "CYu8Z64N2laKBaGCwHG/j1F4SIFqPuqEZeUzg+/BYXM8YQKrNbbte8vcYn456HsY\n" +
            "EwIDAQAB\n" +
            "-----END PUBLIC KEY-----";
    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Bean
    public JwtAccessTokenConverter tokenEnhance()
    {
        JwtAccessTokenConverter converter=new JwtAccessTokenConverter();
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;
    }
    @Bean
    public JwtTokenStore tokenStore() //jwt token store 
    {
        return new JwtTokenStore(tokenEnhance());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore()).accessTokenConverter(tokenEnhance());

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(clientId).secret(passwordEncoder.encode(clientSecret)).scopes("read","write").authorizedGrantTypes("password","refresh_token").accessTokenValiditySeconds(2000).refreshTokenValiditySeconds(20000);
    }
}

