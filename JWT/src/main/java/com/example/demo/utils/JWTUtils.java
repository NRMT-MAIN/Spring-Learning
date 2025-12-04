package com.example.demo.utils;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtils {
	
	
	public static String generateToken(String id, String subject, String skey) {
		byte[] keyBytes = Base64.getEncoder().encode(skey.getBytes()) ; 
		
		return Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuer("Nirmit")
				.setIssuedAt(new Date(System.currentTimeMillis()))
	            .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1))) 
	            .signWith(SignatureAlgorithm.HS256, keyBytes)
	            .compact(); 
	}
}
