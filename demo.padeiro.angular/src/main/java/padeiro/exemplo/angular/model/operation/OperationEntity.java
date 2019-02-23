package padeiro.exemplo.angular.model.operation;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import padeiro.exemplo.angular.model.category.CategoryEntity;
import padeiro.exemplo.angular.model.person.PersonEntity;

@Entity(name = "operation")
@Table(name = "operation")
public class OperationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "description")
	private String description;

	@Column(name = "validaty_date", nullable=false)
	private LocalDate validatyDate;

	@Column(name = "payment_date")
	private LocalDate paymentDate;
	
	@NotNull
	@Column(name = "value")
	private BigDecimal value;

	@Column(name = "observation")
	private String observation;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "person_id")
	private PersonEntity person;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@JoinColumn(name = "operation_type")
	private OperationEnum operationType;

	public PersonEntity getPerson() {
		return person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

	public OperationEnum getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationEnum operationType) {
		this.operationType = operationType;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
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
}
