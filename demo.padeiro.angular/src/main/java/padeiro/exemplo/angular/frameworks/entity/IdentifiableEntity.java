package padeiro.exemplo.angular.frameworks.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
/**
 * @author Carlos Padeiro
 */
import org.springframework.stereotype.Component;

@Component
@MappedSuperclass
public abstract class IdentifiableEntity implements Comparable<Object>, Serializable {
	private static final long serialVersionUID = -9208504714405707791L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, precision = 38, scale = 0)
	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(final Object other) {
		if (other instanceof IdentifiableEntity) {
			return this.equals((IdentifiableEntity) other);
		}
		return false;
	}

	public boolean equals(final IdentifiableEntity other) {
		if (other == null) {
			return false;
		}
		EqualsBuilder builder = new EqualsBuilder();

		if ((this.getId() == null) && (other.getId() == null)) {
			builder.appendSuper(super.equals(other));
		} else {
			builder.append(this.getId(), other.getId());
		}

		return builder.isEquals();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder(1231, -3211);

		if (this.getId() == null) {
			builder.appendSuper(super.hashCode());
		} else {
			builder.append(this.getId());
		}
		return builder.toHashCode();
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + this.getId();
	}

	public boolean isCreated() {
		return this.getId() != null;
	}

	public int compareTo(final Object other) {
		if (other instanceof IdentifiableEntity) {
			return this.compareTo((IdentifiableEntity) other);
		}
		throw new RuntimeException(other.toString());
	}

	public int compareTo(final IdentifiableEntity other) {
		if (other == null) {
			throw new NullPointerException();
		}
		return new CompareToBuilder().append(this.getId(), other.getId()).toComparison();
	}
}
