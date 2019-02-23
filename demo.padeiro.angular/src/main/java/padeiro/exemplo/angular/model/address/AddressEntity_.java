package padeiro.exemplo.angular.model.address;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AddressEntity.class)
public abstract class AddressEntity_ {

	public static volatile SingularAttribute<AddressEntity, String> number;
	public static volatile SingularAttribute<AddressEntity, String> complemento;
	public static volatile SingularAttribute<AddressEntity, String> city;
	public static volatile SingularAttribute<AddressEntity, String> logradouro;
	public static volatile SingularAttribute<AddressEntity, String> outcountry;
	public static volatile SingularAttribute<AddressEntity, String> state;
	public static volatile SingularAttribute<AddressEntity, String> cep;

}

