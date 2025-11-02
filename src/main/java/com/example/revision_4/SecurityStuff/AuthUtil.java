package com.example.revision_4.SecurityStuff;

import com.example.revision_4.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
@Component
public class AuthUtil {
    @Value("${jwt.seckey}")
    private  String jwtsecretkey;


    private SecretKey getseckey(){
        return Keys.hmacShaKeyFor(jwtsecretkey.getBytes(StandardCharsets.UTF_8));
    }

    public String getAccessToken(User user){

        return Jwts.builder()
                .issuedAt(new Date())
                .subject(user.getUsername())
                .claim("userID" , "the value")
                .signWith(getseckey())
                .expiration(new Date(System.currentTimeMillis()+ 10000*60))
                .compact();
    }

    public String extractUsername(String token) {
        Claims claim = Jwts.parser()
                .verifyWith(getseckey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String username =claim.getSubject();
        return username;
    }
}
