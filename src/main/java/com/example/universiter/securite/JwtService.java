package com.example.universiter.securite;

import java.security.Key;
import java.util.Date;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.example.universiter.entities.Utilisateur;
import com.example.universiter.service.UtilisateurService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;

@SuppressWarnings("deprecation")
@AllArgsConstructor
@Service
public class JwtService {
    private final String ENCRIPTION_KEY = "35139112c1f67ff25fd84f78203e5e5f8793c71f665dd27e3e1d7a051832bbbc";
    private UtilisateurService utilisateurService;
    public Map<String, String> generate(String username)
    {
        Utilisateur utilisateur = this.utilisateurService.loadUserByUsername(username);
        return this.generatejwt(utilisateur);
    }
    private Map<String, String> generatejwt(Utilisateur utilisateur) {
        final Map<String, String> claims = Map.of(
            "nom", utilisateur.getNom(),
            "email", utilisateur.getEmail()
        );
        final long currentTime = System.currentTimeMillis();
        final long expirationTime = currentTime + 30 * 60 * 1000;
        final String bearer = Jwts.builder()
                    .setIssuedAt(new Date(currentTime))
                    .setExpiration(new Date(expirationTime))
                    .setSubject(utilisateur.getEmail())
                    .setClaims(claims)
                    .signWith(getKey(), SignatureAlgorithm.HS256)
                    .compact();
       return Map.of("bearer", bearer);
    }
    private Key getKey() {
        final byte[] decoder = Decoders.BASE64.decode(ENCRIPTION_KEY);
        return Keys.hmacShaKeyFor(decoder);
    }

}
