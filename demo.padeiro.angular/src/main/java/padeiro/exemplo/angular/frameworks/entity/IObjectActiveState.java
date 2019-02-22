package padeiro.exemplo.angular.frameworks.entity;

/**
 * @author carlos padeiro
 */
public enum IObjectActiveState {

	ACTIVED(Boolean.TRUE), INACTIVED(Boolean.FALSE);

	private final boolean value;

	private IObjectActiveState(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}
}
