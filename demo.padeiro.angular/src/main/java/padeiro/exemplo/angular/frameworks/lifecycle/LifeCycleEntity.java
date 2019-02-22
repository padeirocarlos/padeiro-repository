package padeiro.exemplo.angular.frameworks.lifecycle;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.stereotype.Component;

import padeiro.exemplo.angular.frameworks.entity.IObjectActiveState;
import padeiro.exemplo.angular.frameworks.entity.IObjectDeleteState;
import padeiro.exemplo.angular.frameworks.entity.IdentifiableEntity;

/**
 * @author carlos padeiro
 */
@Component
@MappedSuperclass
@EntityListeners(value = { LifeCycleJpaListener.class })
public class LifeCycleEntity extends IdentifiableEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1096932604155572044L;

	@Version
	@Column(name = "OPTLOCK", nullable = true)
	private long optlock;

	@Column(name = "UPDATED_BY", nullable = true, precision = 38, scale = 0)
	private Long updatedBy;

	@Column(name = "ACTIVATION_DATE", nullable = true)
	private Timestamp activationDate;

	@Column(name = "ACTIVATED_BY", nullable = true, precision = 38, scale = 0)
	private Long activatedBy;

	@Column(name = "CREATION_DATE", nullable = true)
	private Timestamp creationDate;

	@Column(name = "CREATED_BY", nullable = true, precision = 38, scale = 0)
	private Long createdBy;

	@Column(name = "UPDATED_DATE", nullable = true)
	private Timestamp updateDate;

	@Column(name = "STATE", nullable = true, columnDefinition = "TINYINT(1)")
	private int state;

	@Column(name = "ACTIVE", nullable = true, columnDefinition = "TINYINT(1)")
	private boolean active;

	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(final Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getActivationDate() {
		return this.activationDate;
	}

	public void setActivationDate(final Timestamp activationDate) {
		this.activationDate = activationDate;
	}

	public Long getActivatedBy() {
		return this.activatedBy;
	}

	public void setActivatedBy(final Long activatedBy) {
		this.activatedBy = activatedBy;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(final Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(final Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(final Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public int getState() {
		return this.state;
	}

	public void setState(final int state) {
		this.state = state;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public void copyLifeCycleData(final LifeCycleEntity other) {
		this.setActivatedBy(other.getActivatedBy());
		this.setActive(other.isActive());
		this.setState(other.getState());
	}

	public void toActive() {
		this.setActive(IObjectActiveState.ACTIVED.getValue());
		this.setState(IObjectDeleteState.UNDELETED.getValue());
	}

	public void toInactiveActive() {
		this.setActive(IObjectActiveState.INACTIVED.getValue());
		this.setState(IObjectDeleteState.DELETED.getValue());
	}

	public long getOptlock() {
		return this.optlock;
	}

	public void setOptlock(final long optlock) {
		this.optlock = optlock;
	}

}
