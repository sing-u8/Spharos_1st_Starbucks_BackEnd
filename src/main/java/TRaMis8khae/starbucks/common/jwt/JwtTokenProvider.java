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

//        return Jwts.builder()
//                .signWith(getSignKey())
//                .claim("loginId", claims.getSubject())
//                .issuedAt(expiration)
//                .compact();

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();

        logger.info("Generated JWT Token: {}", token);
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

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public Key getSignKey() {
        String secretKey = env.getProperty("jwt.secret-key");
        if (secretKey == null || secretKey.isEmpty()) {
            throw new IllegalArgumentException("JWT secret key must be defined in the environment.");
        }
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }


//    public Key getSignKey() {
//        return Keys.hmacShaKeyFor( env.getProperty("jwt.secret-key").getBytes() );
//    }


//    // 서명에 사용할 SecretKey 생성
//    public Key getSignKey() {
//        String secretKey = env.getProperty("jwt.secret-key");
//        if (secretKey == null || secretKey.isEmpty()) {
//            throw new IllegalArgumentException("JWT secret key must be defined in the environment.");
//        }
//        return Keys.hmacShaKeyFor(secretKey.getBytes());
//    }
//
//    // 액세스 토큰 생성
//    public String generateAccessToken(Authentication authentication) {
//        Claims claims = Jwts.claims().setSubject(authentication.getName()).build();
//        Date now = new Date();
//        Long expirationTime = env.getProperty("jwt.access-expire-time", Long.class);
//
//        if (expirationTime == null) {
//            throw new IllegalArgumentException("JWT expiration time must be defined in the environment.");
//        }
//
//        Date expiration = new Date(now.getTime() + expirationTime);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(expiration)
//                .signWith(getSignKey(), SignatureAlgorithm.HS256) // 키와 서명 알고리즘 설정
//                .compact();
//    }
//
//    // JWT 토큰의 유효성 검사 및 클레임 파싱
//    public Claims parseClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(getSignKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
}
