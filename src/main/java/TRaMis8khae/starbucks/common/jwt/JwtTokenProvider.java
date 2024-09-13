package TRaMis8khae.starbucks.common.jwt;

import TRaMis8khae.starbucks.common.entity.BaseResponseStatus;
import TRaMis8khae.starbucks.common.exception.BaseException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenProvider {

//    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    private final Environment env;
    private final UserDetailsService userDetailsService;

    public String generateAccessToken(String memberUUID) {

        Claims claims = Jwts.claims().subject(memberUUID).build();
        Date now = new Date();
        Date expiration = new Date(now.getTime() + env.getProperty("jwt.access-expire-time", Long.class).longValue());

         return Jwts.builder()
                .signWith(getSignKey())
                .claim("memberUUID", claims.getSubject())
                .setExpiration(expiration)
                .compact();

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

    // 토큰에서 모든 클레임 추출
    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getMemberUUID(String token) throws BaseException {
        try {
            log.info(extractClaim(token, Claims::getSubject));
        } catch (NullPointerException e) {
            throw new BaseException(BaseResponseStatus.WRONG_JWT_TOKEN);
        }
    }

//    public Authentication getAuthentication(String token) {
//
//        log.info("token : {}", token);
//
//        Claims claims = getClaims(token);
//        log.info("claims : {}", claims);
//
//        String memberUUID = claims.get("memberUUID", String.class);
//
//        log.info("memberUUID : {}", memberUUID);
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(memberUUID);
//
//        return new UsernamePasswordAuthenticationToken(
//                userDetails,
//                null,
//                userDetails.getAuthorities()
//        );
//    }

}