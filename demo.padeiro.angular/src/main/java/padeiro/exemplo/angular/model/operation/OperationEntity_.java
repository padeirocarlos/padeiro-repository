package padeiro.exemplo.angular.model.operation;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import padeiro.exemplo.angular.model.category.CategoryEntity;
import padeiro.exemplo.angular.model.person.PersonEntity;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OperationEntity.class)
public abstract class OperationEntity_ {

	public static volatile SingularAttribute<OperationEntity, String> observation;
	public static volatile SingularAttribute<OperationEntity, PersonEntity> person;
	public static volatile SingularAttribute<OperationEntity, String> description;
	public static volatile SingularAttribute<OperationEntity, OperationEnum> operationType;
	public static volatile SingularAttribute<OperationEntity, Long> id;
	public static volatile SingularAttribute<OperationEntity, LocalDate> validatyDate;
	public static volatile SingularAttribute<OperationEntity, LocalDate> paymentDate;
	public static volatile SingularAttribute<OperationEntity, CategoryEntity> category;
	public static volatile SingularAttribute<OperationEntity, BigDecimal> value;

}

