package com.example.user.configuration.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;


@Service
public class JwtService {

    private static final String SECRET_KEY = System.getenv("SECRET_KEY");

    public String getToken(UserDetails user) {

        String role = "";
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        if (!authorities.isEmpty()) {
            role = authorities.iterator().next().getAuthority();
        }


        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", role);

        return getToken(extraClaims, user);
    }

    private String getToken(Map<String,Object> extraClaims, UserDetails user){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getEmailFromToken(String token) {
        return getClaim(token , Claims::getSubject);
    }

    public boolean isTokenVallid(String token, UserDetails userDetails) {
        final String email = getEmailFromToken(token);
        return  (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token)
    {
        return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
    }

    public  <T> T getClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpeiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token)
    {
        return getExpeiration(token).before(new Date());
    }
}
