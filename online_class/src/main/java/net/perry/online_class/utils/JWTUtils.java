package net.perry.online_class.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.perry.online_class.model.entity.User;

/**
 * JWT工具类
 * 注意点：
 * 1，生成的token是可以通过base64解密出明文信息的
 * 2，base64进行解密出明文信息，修改再进行编码，则会解密失败
 * 3，无法作废已经颁布的token，除非改密钥
 */
public class JWTUtils {
    
    /**
     * 过期时间为一周
     */
    private static final long EXPIRE = 60000 * 60 * 24 * 7; 

    /**
     * 加密密钥
     */
    private static final byte [] SECRET = "perry.net520".getBytes(StandardCharsets.UTF_8);

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "perryclass";

    /**
     * 主题
     */
    private static final String SUBJECT = "perryclass";

    /**
     * 根据用户信息生成令牌
     * @param user
     * @return
     */
    public static String genJsonWebToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
            .claim("name", user.getName())
            .claim("head_img", user.getHeadImg())
            .claim("id", user.getId())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
            .signWith(SignatureAlgorithm.HS256, SECRET).compact();

        token = TOKEN_PREFIX + token;

        return token;
    }

    /**
     * 校验token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return claims;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
