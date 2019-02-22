package padeiro.exemplo.angular.frameworks.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SimpleEntity.class)
public abstract class SimpleEntity_ extends padeiro.exemplo.angular.frameworks.entity.IdentifiableEntity_ {

	public static volatile SingularAttribute<SimpleEntity, String> code;
	public static volatile SingularAttribute<SimpleEntity, String> description;
	public static volatile SingularAttribute<SimpleEntity, String> type;
	public static volatile SingularAttribute<SimpleEntity, String> remarks;

}

