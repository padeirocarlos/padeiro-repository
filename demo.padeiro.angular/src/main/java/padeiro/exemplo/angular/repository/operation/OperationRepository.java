package padeiro.exemplo.angular.repository.operation;

import org.springframework.data.jpa.repository.JpaRepository;

import padeiro.exemplo.angular.model.operation.OperationEntity;


public interface OperationRepository extends JpaRepository<OperationEntity, Long>,OperationRepositoryQuery{
		

}
