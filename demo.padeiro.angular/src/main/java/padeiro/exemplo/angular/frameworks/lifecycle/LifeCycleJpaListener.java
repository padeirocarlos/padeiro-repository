package padeiro.exemplo.angular.frameworks.lifecycle;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import padeiro.exemplo.angular.frameworks.entity.IObjectActiveState;
import padeiro.exemplo.angular.frameworks.entity.IObjectDeleteState;

/**
 * @author carlos padeiro
 */
public class LifeCycleJpaListener {

	private final Timestamp now = new Timestamp(System.currentTimeMillis());

	@PrePersist
	public void onPrePersist(final LifeCycleEntity entity) {

		entity.setActivationDate(this.now);
		entity.setCreationDate(this.now);
		entity.setActive(IObjectActiveState.ACTIVED.getValue());
		entity.setState(IObjectDeleteState.UNDELETED.getValue());
	}

	@PreUpdate
	void onPreUpdate(final LifeCycleEntity entity) {
		// Last changed data{user and date of change
		entity.setUpdateDate(this.now);
	}

	@PreRemove
	void onPreRemove(final LifeCycleEntity entity) {
		// Last changed data{user and date of change}
		entity.setUpdateDate(this.now);
	}
}
