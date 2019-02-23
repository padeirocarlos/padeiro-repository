package padeiro.exemplo.angular.repository.operation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import padeiro.exemplo.angular.model.operation.OperationEntity;
import padeiro.exemplo.angular.model.operation.OperationEnum;
import padeiro.exemplo.angular.model.operation.ProjectionOperation;

public interface OperationRepositoryQuery {

	public String findOperationByDescriptionAndDate = "select p from operation p inner join fetch p.person up inner join fetch p.category i where p.description like :pdescription and p.validatyDate>=:pvalidatyDate";

	public String findOperationByDescriptionAndOperationType = "select p from operation p inner join fetch p.person up inner join fetch p.category i where p.description like :pdescription and p.operationType=:poperationType";

	public List<OperationEntity> findOperationByDescriptionAndDate(final LocalDate validatyDate,
			final String description);

	public List<OperationEntity> findOperationByDescriptionAndOperationType(final OperationEnum operationType,
			final String description);
	
	public Page<ProjectionOperation> findProjectionOperationByDescriptionAndDate(final LocalDate validatyDate,
			final String description,Pageable pageable);

	public Page<ProjectionOperation> findProjectionOperationByDescriptionAndOperationType(final OperationEnum operationType,
			final String description,Pageable pageable);

	public List<OperationEntity> findOperationByDescriptionAndOperationType(final String operationType,
			final String description);
}