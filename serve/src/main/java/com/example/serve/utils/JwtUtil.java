package com.example.serve.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    private static final long EXPIRE_TIME = 120 * 60 * 1000;

    public static String sign(String userId, String account, String password) {
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //使用用户密码作为私钥进行加密
        Algorithm algorithm = Algorithm.HMAC256(password);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        return JWT.create().withHeader(header).withClaim("userId", userId).withClaim("account", account).withExpiresAt(date).sign(algorithm);
    }

    //校验token
    public static boolean verity(String token, String password) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public static Long getUserId(String jwtToken) {
        String jwt = "";
        if(jwt.startsWith("Bearer")){
            // 去掉 Bearer 前缀
            jwt = jwtToken.replace("Bearer ", "");
        } else{
            jwt = jwtToken;
        }
        String userId = JWT.decode(jwt).getClaim("userId").asString();
        return new Long(userId);
    }

    public static String getAccount(String jwtToken) {
        String jwt = "";
        if(jwt.startsWith("Bearer")){
            // 去掉 Bearer 前缀
            jwt = jwtToken.replace("Bearer ", "");
        } else{
            jwt = jwtToken;
        }
        return JWT.decode(jwt).getClaim("account").asString();
    }
}