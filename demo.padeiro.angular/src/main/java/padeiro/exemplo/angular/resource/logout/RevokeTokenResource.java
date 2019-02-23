package padeiro.exemplo.angular.resource.logout;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padeiro.exemplo.angular.config.EAuthorizedAndAuthenticationConfig;
import padeiro.exemplo.angular.config.proporty.PadeiroApiProperty;
import padeiro.exemplo.angular.token.ETokenConfig;

/**
 * @author cpadeiro
 */
@RestController
@RequestMapping("/revoke")
@CrossOrigin(maxAge = 10, origins = { EAuthorizedAndAuthenticationConfig._CORS_ORIGINS })
public class RevokeTokenResource {

	@Inject
	private PadeiroApiProperty padeiroApiProperty;
	
	@DeleteMapping("/logout")
	public void revoke(HttpServletRequest req, HttpServletResponse resp) {
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setHttpOnly(getPadeiroApiProperty().getHttpOnly().isEnableHttpOnly());
		cookie.setSecure(getPadeiroApiProperty().Security().isEnableHttps()); // TODO: We have to change it in production
		cookie.setPath(req.getContextPath() + ETokenConfig._OAUTH_TOKEN);
		cookie.setMaxAge(0);

		resp.addCookie(cookie);
		resp.setStatus(HttpStatus.NO_CONTENT.value());
	}

	public PadeiroApiProperty getPadeiroApiProperty() {
		return padeiroApiProperty;
	}

	public void setPadeiroApiProperty(PadeiroApiProperty padeiroApiProperty) {
		this.padeiroApiProperty = padeiroApiProperty;
	}
}
