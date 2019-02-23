package padeiro.exemplo.angular.config.proporty;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("padeiro")
public class PadeiroApiProperty {

	private String originAllowed = "http://localhost:8000";

	private final Security security = new Security();

	private final HttpOnly httpOnly = new HttpOnly();

	public Security Security() {
		return this.security;
	}

	public String getOriginPermitida() {
		return this.originAllowed;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originAllowed = originPermitida;
	}

	public HttpOnly getHttpOnly() {
		return httpOnly;
	}

	public static class Security {

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}

	public static class HttpOnly {

		private boolean enableHttpOnly;

		public boolean isEnableHttpOnly() {
			return enableHttpOnly;
		}

		public void setEnableHttpOnly(boolean enableHttpOnly) {
			this.enableHttpOnly = enableHttpOnly;
		}
	}
}
