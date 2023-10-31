package net.perry.online_class;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Claims;
import net.perry.online_class.model.entity.User;
import net.perry.online_class.utils.JWTUtils;

@SpringBootTest
class OnlineClassApplicationTests {

	@Test
	public void testGenJwt(){

		User user = new User();
		user.setId(66);
		user.setName("ruby");
		user.setHeadImg("png");
		String token = JWTUtils.genJsonWebToken(user);
		System.out.println(token);
		Claims claims = JWTUtils.checkJWT(token);
		System.out.println(claims.get("name"));
	}

}
