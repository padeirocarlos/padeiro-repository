package padeiro.exemplo.angular.frameworks.entity;

/**
 * @author carlos padeiro
 */
public enum IObjectDeleteState {

	UNDELETED(0), DELETED(1);

	private final int value;

	private IObjectDeleteState(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
