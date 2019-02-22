package padeiro.exemplo.angular.model.operation;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * @author cpadeiro
 */
public class ProjectionOperation {
	
	private Long id;
	private String description;
	private LocalDate validatyDate;
	private LocalDate paymentDate;
	private BigDecimal value;
	private String observation;
	private String person;
	private String category;
	
	public ProjectionOperation(Long id, String description, LocalDate validatyDate, LocalDate paymentDate,
			BigDecimal value, String observation, String person, String category) {
		super();
		this.id = id;
		this.description = description;
		this.validatyDate = validatyDate;
		this.paymentDate = paymentDate;
		this.value = value;
		this.observation = observation;
		this.person = person;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}