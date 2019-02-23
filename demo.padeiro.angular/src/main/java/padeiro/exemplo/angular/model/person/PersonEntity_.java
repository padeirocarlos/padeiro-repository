package padeiro.exemplo.angular.model.person;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import padeiro.exemplo.angular.model.address.AddressEntity;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PersonEntity.class)
public abstract class PersonEntity_ {

	public static volatile SingularAttribute<PersonEntity, AddressEntity> address;
	public static volatile SingularAttribute<PersonEntity, String> name;
	public static volatile SingularAttribute<PersonEntity, Boolean> active;
	public static volatile SingularAttribute<PersonEntity, Long> id;

}

