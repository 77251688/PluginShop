package com.cummins.pluginshop.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWT {
    private static final String secret = "1235677";

    public static String createToken(Map<String, Object> claims) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 60 * 60);

        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeader(map)
                .signWith(SignatureAlgorithm.HS256, secret)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(calendar.getTime());

        return jwtBuilder.compact();
    }

    public static boolean checkToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            System.out.println(claims.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
