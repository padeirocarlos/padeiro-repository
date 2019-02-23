package padeiro.exemplo.angular.usercontext;


import java.io.Serializable;

/**
 * @author carlos padeiro
 */
public class UserContext implements IUserContext,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2076775740704872587L;
	
	private String clientHostAddress;
	private String sessionId;
	private String username;
	private Long userId;
	
	
	public String getClientHostAddress() {
		return this.clientHostAddress;
	}
	public void setClientHostAddress(final String clientHostAddress) {
		this.clientHostAddress = clientHostAddress;
	}
	
	public String getSessionId() {
		return this.sessionId;
	}
	public void setSessionId(final String sessionId) {
		this.sessionId = sessionId;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(final String username) {
		this.username = username;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(final Long userId) {
		this.userId = userId;
	}
}
