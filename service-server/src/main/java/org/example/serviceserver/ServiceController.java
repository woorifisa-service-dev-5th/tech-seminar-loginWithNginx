package org.example.serviceserver;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;

@RestController
public class ServiceController {



    private static final Key SECRET_KEY = Keys.hmacShaKeyFor("jwtsecretkeyforseminar20250730xx".getBytes());


    @GetMapping("/service/test")
    public ResponseEntity<String> test(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("토큰 없음 또는 형식 오류");
        }

        String token = authHeader.substring(7);

        try {
            Claims claims = Jwts
                    .parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();



            String email = claims.getSubject();
            return ResponseEntity.ok("인증된 사용자: " + email + " → 서비스 서버에 접속했습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("유효하지 않은 토큰");
        }
    }
}
