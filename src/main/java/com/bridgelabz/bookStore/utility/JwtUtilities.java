package com.bridgelabz.bookStore.utility;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.bookStore.dto.LoginDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtilities implements Serializable {

	@Autowired
	LoginDto logindto;
	String secretekey = "Rukmini";

	public String generateToken(LoginDto logindto) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("email", logindto.getEmail());
		claims.put("password", logindto.getEmail());
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, secretekey).compact();
	}

	public String getEmailFromToken(String token) {
		Map<String, Object> claims = Jwts.parser().setSigningKey(secretekey).parseClaimsJws(token).getBody();
		System.out.println(claims.get("email"));
		return claims.get("email").toString();
	}

	public LoginDto decodeToken(String token) {
		Map<String, Object> claims = new HashMap<>();
		claims = Jwts.parser().setSigningKey(secretekey).parseClaimsJws(token).getBody();
		logindto.setEmail((String) claims.get("email"));
		logindto.setPassword((String) claims.get("password"));

		return logindto;
	}

}
