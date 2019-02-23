package padeiro.exemplo.angular.token;

public enum ETokenConfig {

	_OAUTH_TOKEN("/oauth/token"), _REFRESH_TOKEN("refresh_token"), _GRANT_TYPE("grant_type");

	private final String value;

	private ETokenConfig(final String name) {
		this.value = name;
	}

	public String getValue() {
		return this.value;
	}
}

