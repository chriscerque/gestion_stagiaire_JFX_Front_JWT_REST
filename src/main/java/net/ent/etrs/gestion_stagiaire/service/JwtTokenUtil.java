package net.ent.etrs.gestion_stagiaire.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

    @Getter
    @Setter
    private static String token;


    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        System.out.println("JwtTokenUtil / getUsernameFromToken");
        return getClaimFromToken(token, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        System.out.println("JwtTokenUtil / getExpirationDateFromToken");
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        System.out.println("JwtTokenUtil / getClaimFromToken");
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    //for retrieveing any information from token we will need the secret key
    public Claims getAllClaimsFromToken(String token) {
        System.out.println("JwtTokenUtil / getAllClaimsFromToken");
        System.out.println("token : " + token);
        String[] tab = token.split("\\.");
        return Jwts.parser().parseClaimsJwt(String.format("%s.%s.", tab[0], tab[1])).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        System.out.println("JwtTokenUtil / isTokenExpired");
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }


}
