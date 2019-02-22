package padeiro.exemplo.angular.resource;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import padeiro.exemplo.angular.config.EAuthorizedAndAuthenticationConfig;
import padeiro.exemplo.angular.events.CreatedResourceEvent;
import padeiro.exemplo.angular.model.operation.OperationEntity;
import padeiro.exemplo.angular.model.operation.ProjectionOperation;
import padeiro.exemplo.angular.repository.operation.OperationFilter;
import padeiro.exemplo.angular.repository.operation.OperationRepository;
import padeiro.exemplo.angular.service.OperationService;

@RestController
@RequestMapping("/operation")
@CrossOrigin(maxAge = 10, origins = { EAuthorizedAndAuthenticationConfig._CORS_ORIGINS })
public class OperationResource {

	@Inject
	private OperationRepository operationRepository;

	@Inject
	private ApplicationEventPublisher publisher;

	@Inject
	private OperationService operationService;

	/**
	 * @param operation
	 * @param response
	 * @return
	 */
	@PostMapping("/createOperation")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and #oauth2.hasScope('write')")
	public ResponseEntity<OperationEntity> createOperation(@Valid @RequestBody OperationEntity operation,
			HttpServletResponse response) {

		OperationEntity entity = operationRepository.save(operation);

		publisher.publishEvent(new CreatedResourceEvent(this, response, entity.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	/**
	 * @param operationId
	 */
	@DeleteMapping("/deleteOperation/{operationId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO') and #oauth2.hasScope('write')")
	public void deleteOperation1(@Valid @PathVariable Long operationId) {

		operationRepository.delete(operationId);
	}

	@PutMapping("/updateOperation/{operationId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and #oauth2.hasScope('write')")
	public ResponseEntity<OperationEntity> updateOperation(@Valid @PathVariable Long operationId,
			@RequestBody OperationEntity operation) {

		OperationEntity operationEntity = operationService.updateOperation(operationId, operation);

		return ResponseEntity.ok(operationEntity);
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/findById/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
	public ResponseEntity<OperationEntity> findOperationByCode(@PathVariable Long id) {

		OperationEntity OperationEntity = operationRepository.findOne(id);

		return OperationEntity != null ? ResponseEntity.ok(OperationEntity) : ResponseEntity.notFound().build();
	}

	/**
	 * @param validatyDate
	 * @param description
	 * @return
	 */
	@GetMapping("/findByDescriptionAndDate")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
	public List<OperationEntity> findOperationByDescriptionAndDate(OperationFilter operation) {

		return operationService.findOperationByDescriptionAndDate(operation.getValidatyDate(),
				operation.getDescription());
	}

	
	/**
	 * @param validatyDate
	 * @param description
	 * @return
	 */
	@GetMapping("/findProjectionOperationByDescriptionAndDate")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
	public Page<ProjectionOperation> findProjectionOperationByDescriptionAndDate(OperationFilter operation, Pageable pageable) {

		return operationService.findProjectionOperationByDescriptionAndDate(operation.getValidatyDate(),
				operation.getDescription(),pageable);
	}
	
	/**
	 * @param validatyDate
	 * @param description
	 * @return
	 */
	@GetMapping("/findProjectionOperationByDescriptionAndOperationType")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
	public Page<ProjectionOperation> findProjectionOperationByDescriptionAndOperationType(OperationFilter operation, Pageable pageable) {

		return operationService.findProjectionOperationByDescriptionAndOperationType(operation.getOperationType(),
				operation.getDescription(),pageable);
	}
	
	/**
	 * @param operationEnum
	 * @param description
	 * @return
	 */
	@GetMapping("/findByDescriptionAndOperationType")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
	public List<OperationEntity> findOperationByDescriptionAndOperationType(OperationFilter operation) {

		return operationService.findOperationByDescriptionAndOperationType(operation.getOperationType(),
				operation.getDescription());
	}

	/**
	 * @return
	 */
	@GetMapping("/findAll")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and #oauth2.hasScope('read')")
	public List<OperationEntity> findAll() {

		return operationRepository.findAll();
	}

	public ApplicationEventPublisher getPublisher() {
		return publisher;
	}

	public void setPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public OperationService getoperationService() {
		return operationService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

}
