package padeiro.exemplo.angular.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class APIAuthorizedSecurityConfig extends AuthorizationServerConfigurerAdapter {

	@Inject
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(EAuthorizedAndAuthenticationConfig.CLIENT_ANGULAR_NAME.getValue())
				.secret(EAuthorizedAndAuthenticationConfig.CLIENT_ANGULAR_PASSWORD.getValue())
				.scopes(EAuthorizedAndAuthenticationConfig.SCOPE_READ.getValue(),
						EAuthorizedAndAuthenticationConfig.SCOPE_WRITE.getValue())
				.authorizedGrantTypes(EAuthorizedAndAuthenticationConfig.GRANT_TYPE.getValue(),
						EAuthorizedAndAuthenticationConfig.GRANT_REFRESH_TOKEN.getValue())
				.accessTokenValiditySeconds(120).refreshTokenValiditySeconds(3600 * 24).
			and()
				.withClient(EAuthorizedAndAuthenticationConfig.CLIENT_MOBILE_NAME.getValue())
				.secret(EAuthorizedAndAuthenticationConfig.CLIENT_MOBILE_PASSWORD.getValue())
				.scopes(EAuthorizedAndAuthenticationConfig.SCOPE_READ.getValue())
				.authorizedGrantTypes(EAuthorizedAndAuthenticationConfig.GRANT_TYPE.getValue(),
						EAuthorizedAndAuthenticationConfig.GRANT_REFRESH_TOKEN.getValue())
				.accessTokenValiditySeconds(120).refreshTokenValiditySeconds(3600 * 24);

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter()).reuseRefreshTokens(false)
				.authenticationManager(authenticationManager);
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey(EAuthorizedAndAuthenticationConfig.SIGNING_KEY.getValue());
		return accessTokenConverter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
}
