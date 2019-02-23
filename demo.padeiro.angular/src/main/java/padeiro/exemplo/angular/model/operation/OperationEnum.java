package padeiro.exemplo.angular.model.operation;

public enum OperationEnum {

	INCOME(0), OUTGOING(1);

	private final int value;

	private OperationEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
