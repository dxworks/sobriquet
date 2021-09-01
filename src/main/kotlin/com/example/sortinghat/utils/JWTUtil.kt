package com.example.sortinghat.utils

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import java.util.*


@Service
class JWTUtil {
    private val secret = "randomKey"

    fun createToken(username: String): String {
        val claims = Jwts.claims().setSubject(username)
        val now = Date()
        val validity = Date(now.getTime() + 3600000)
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact()
    }
}
