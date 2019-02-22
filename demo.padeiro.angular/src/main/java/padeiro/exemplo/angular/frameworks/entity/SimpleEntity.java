package padeiro.exemplo.angular.frameworks.entity;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author carlos padeiro
 */
@Entity(name="simpleEntity")
@Table(name = "SIMPLE_ENTITY", uniqueConstraints = {@UniqueConstraint(columnNames = {"CODE","TYPE"})})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class SimpleEntity extends IdentifiableEntity{
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = -5193209990946487531L;

	@Column(name = "CODE", nullable = false)
	private String code;

	@Column(name = "DESCRIPTION", length = 255,nullable = false)
	private String description;

	@Column(name = "REMARK", length = 255)
	private String remarks;
	
	@Column(name = "TYPE", nullable = false, insertable = false, updatable = false, length = 255)
	private String type;
	
	@Override
	public Long getId()
	{
		return super.getId();
	}
	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(final String remarks) {
		this.remarks = remarks;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(final String code) {
		this.code = code;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	public String getType() {
		return this.type;
	}
	public void setType(final String type) {
		this.type = type;
	}
	
	public int compareTo(final SimpleEntity simpleEntity)
	{
		final SimpleEntity other = simpleEntity;

		return new CompareToBuilder().append(this.getType(), other.getType())
			.append(this.getCode(), other.getCode()).toComparison();
	}

	@Override
	public int hashCode()
	{
		return new HashCodeBuilder().append(this.getType())
			.append(this.getCode()).toHashCode();
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (obj == null)
		{
			return false;
		}

		if (obj instanceof SimpleEntity)
		{
			final SimpleEntity other = (SimpleEntity) obj;
			return new EqualsBuilder().append(this.getType(), other.getType())
				.append(this.getCode(), other.getCode()).isEquals();
		}

		return false;
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.appendSuper(super.toString()).append("code", this.getCode())
			.append("type", this.getType()).toString();
	}
}
