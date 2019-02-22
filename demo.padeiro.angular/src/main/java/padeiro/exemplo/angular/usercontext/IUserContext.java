package padeiro.exemplo.angular.usercontext;

/**
 * @author carlos padeiro
 */
public interface IUserContext {
	
	public abstract String getClientHostAddress();

	public abstract String getSessionId();

	public abstract Long getUserId();

	public abstract String getUsername();
}
