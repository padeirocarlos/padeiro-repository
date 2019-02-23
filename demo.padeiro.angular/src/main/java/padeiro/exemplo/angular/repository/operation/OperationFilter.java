package padeiro.exemplo.angular.repository.operation;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class OperationFilter {

	private String description;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate validatyDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;

	private BigDecimal value;

	private String observation;

	private String operationType;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getValidatyDate() {
		return validatyDate;
	}

	public void setValidatyDate(LocalDate validatyDate) {
		this.validatyDate = validatyDate;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

}
