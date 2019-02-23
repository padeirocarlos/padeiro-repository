package padeiro.exemplo.angular.model.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, String> name;
	public static volatile ListAttribute<UserEntity, AuthorizationEntity> authorizations;
	public static volatile SingularAttribute<UserEntity, Long> id;
	public static volatile SingularAttribute<UserEntity, String> email;

}

