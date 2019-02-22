package padeiro.exemplo.angular.frameworks.lifecycle;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LifeCycleEntity.class)
public abstract class LifeCycleEntity_ extends padeiro.exemplo.angular.frameworks.entity.IdentifiableEntity_ {

	public static volatile SingularAttribute<LifeCycleEntity, Timestamp> updateDate;
	public static volatile SingularAttribute<LifeCycleEntity, Long> updatedBy;
	public static volatile SingularAttribute<LifeCycleEntity, Long> createdBy;
	public static volatile SingularAttribute<LifeCycleEntity, Long> optlock;
	public static volatile SingularAttribute<LifeCycleEntity, Boolean> active;
	public static volatile SingularAttribute<LifeCycleEntity, Long> activatedBy;
	public static volatile SingularAttribute<LifeCycleEntity, Integer> state;
	public static volatile SingularAttribute<LifeCycleEntity, Timestamp> activationDate;
	public static volatile SingularAttribute<LifeCycleEntity, Timestamp> creationDate;

}

