package com.tigris.springsecurityjwt.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    @Value("${tigris.secret}")
    private String SECRET_KEY;

    @Value("${tigris.expiration}")
    private long expiration;

    public String generateJwtToken(Authentication authentication){
          JwtUserDetails userDetails= (JwtUserDetails) authentication.getPrincipal();
          Date expireDate=new Date(new Date().getTime() + expiration);
          return Jwts.builder()
                  .setSubject(Long.toString(userDetails.getId()))
                  .setIssuedAt(new Date()).setExpiration(expireDate)
                  .signWith(SignatureAlgorithm.HS512,SECRET_KEY).compact();

    }

    public String generateJwtTokenByUserId(Long userId) {
        Date expireDate = new Date(new Date().getTime() + expiration);
        return Jwts.builder().setSubject(Long.toString(userId))
                .setIssuedAt(new Date()).setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
    }
    
    public Long getUserIdFromJwt(String token){
        Claims claims=Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
       
    }
    
    boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (SignatureException e) {
            return false;
        } catch (MalformedJwtException e) {
            return false;
        } catch (ExpiredJwtException e) {
            return false;
        } catch (UnsupportedJwtException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Date expiration=Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }

}
