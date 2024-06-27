package com.ahlymomkn.cashout.util;

import com.ahlymomkn.cashout.exception.ConflictException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;
    @Value("${app.jwt-expiration-milliseconds}")
    private Long jwtExpirationDate;

    public String generateToken(Authentication authentication){

        String username = authentication.getName();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + jwtExpirationDate);

        return Jwts.builder().
                subject(username).
                issuedAt(new Date()).
                expiration(expiryDate).
                signWith(key()).
                compact();
    }

    private SecretKey key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUsername(String token){
        Claims claims = Jwts.parser()
                .verifyWith(key())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .verifyWith(key())
                    .build()
                    .parse(token);

            return true;
        }
        catch (MalformedJwtException e){
            throw new ConflictException(HttpStatus.BAD_REQUEST,"Invalid jwt token");
        }
        catch (ExpiredJwtException e){
            throw new ConflictException(HttpStatus.BAD_REQUEST,"token expired");
        } catch (UnsupportedJwtException e){
            throw new ConflictException(HttpStatus.BAD_REQUEST,"unsupported jwt token");
        } catch (IllegalArgumentException e){
            throw new ConflictException(HttpStatus.BAD_REQUEST,"Jwt claims is empty");
        }

    }

}
