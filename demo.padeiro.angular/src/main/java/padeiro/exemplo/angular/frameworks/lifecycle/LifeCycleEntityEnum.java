package padeiro.exemplo.angular.frameworks.lifecycle;

/**
 * @author carlos padeiro
 */
public enum LifeCycleEntityEnum {

	UPDATE_BY("updatedBy"), ACTIVATION_DATE("activationDate"), UPDATE_DATE(
			"updateDate"), CREATE_BY("createdBy"), ACTIVATION_BY("activatedBy"), CREATE_DATE(
			"creationDate"),STATE("state"), ACTIVE("active");

	private final String name;

	private LifeCycleEntityEnum(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
