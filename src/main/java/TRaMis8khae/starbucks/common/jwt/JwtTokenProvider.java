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
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    private final Environment env;

    public String generateAccessToken(String memberUUID) {
        Claims claims = Jwts.claims().subject(memberUUID).build();
        Date now = new Date();
        Date expiration = new Date(now.getTime() + env.getProperty("jwt.access-expire-time", Long.class).longValue());

        return Jwts.builder()
                .signWith(getSignKey())
                .claim("email", claims.getSubject())
                .issuedAt(expiration)
                .compact();

        //        Claims claims = Jwts.claims().subject(authentication.getName()).build();
//        Date now = new Date();
//        Date expiration = new Date(now.getTime() + env.getProperty("jwt.access-expire-time", Long.class).longValue());
//
//        String token = Jwts.builder()
//                .signWith(getSignKey())
//                .claim("memberUuid", claims.getSubject())
//                .issuedAt(expiration)
//                .compact();
//
//        logger.info("Generated JWT AccessToken: {}", token);
//        logger.info("Login ID: {}", claims.getSubject());
//
//        return token;
    }

    public String generateRefreshToken(Authentication authentication) {
        Claims claims = Jwts.claims().subject(authentication.getName()).build();
        Date now = new Date();
        Date expiration = new Date(now.getTime() + env.getProperty("jwt.access-expire-time", Long.class).longValue());

        return Jwts.builder()
                .signWith(getSignKey())
                .claim("email", claims.getSubject())
                .issuedAt(expiration)
                .compact();
    }

    public Key getSignKey() {
        return Keys.hmacShaKeyFor( env.getProperty("jwt.secret-key").getBytes() );
    }
}
