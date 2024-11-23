package MyFinanceHub.fino.Utisl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTutil {

    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
//                .parseClaimsJwt(token)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpirationToken(token).before(new Date());
    }

    public  Date extractExpirationToken(String token){
        return extractAllClaims(token).getExpiration();
    }

    public String generateToken(String username){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,username);
    }

    private String createToken(Map<String, Object> claims, String Subject) {
       Map<String, Object> header = new HashMap<>(); header.put("typ", "JWT");

       return  Jwts.builder().setClaims(claims).setHeader(header).
                setSubject(Subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+100*60*5*60))
                .signWith(getSignKey()).compact();

//          Jwts.builder().
//                claim(claims)
//                .setSubject(Subject).
//                header().empty().add("typ","JWT")
//                  .and().
//          issueAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis()+100*60*5))
//                  .signwith(getSignKey()).compact;

    }
    private static SecretKey getSignKey() { return secretKey;}

    public Boolean validateToke(String token,String username){
        final String extractedName=extractUsername(token);
        return (extractedName.equals(username) && !isTokenExpired(token));
    }
}
