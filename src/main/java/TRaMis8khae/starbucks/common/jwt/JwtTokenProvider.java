package TRaMis8khae.starbucks.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    private final Environment env;

    public String generateAccessToken(Authentication authentication) {
        Claims claims = Jwts.claims().subject(authentication.getName()).build();
        Date now = new Date();
        Date expiration = new Date(now.getTime() + env.getProperty("jwt.access-expire-time", Long.class).longValue());

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();

        logger.info("Generated JWT AccessToken: {}", token);
        logger.info("Login ID: {}", claims.getSubject());

        return token;
    }

    public String generateRefreshToken(Authentication authentication) {
        Claims claims = Jwts.claims().subject(authentication.getName()).build();
        Date now = new Date();
        Long expirationTime = env.getProperty("jwt.refresh-expire-time", Long.class);

        if (expirationTime == null) {
            throw new IllegalArgumentException("JWT refresh expiration time must be defined in the environment.");
        }

        Date expiration = new Date(now.getTime() + expirationTime);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();

        logger.info("Generated JWT RefreshToken: {}", token);
        return token;
    }

    public Key getSignKey() {
        String secretKey = env.getProperty("jwt.secret-key");
        if (secretKey == null || secretKey.isEmpty()) {
            throw new IllegalArgumentException("JWT secret key must be defined in the environment.");
        }
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
