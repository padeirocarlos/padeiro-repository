package padeiro.exemplo.angular.repository.operation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import padeiro.exemplo.angular.model.category.CategoryEntity_;
import padeiro.exemplo.angular.model.operation.OperationEntity;
import padeiro.exemplo.angular.model.operation.OperationEntity_;
import padeiro.exemplo.angular.model.operation.OperationEnum;
import padeiro.exemplo.angular.model.operation.ProjectionOperation;
import padeiro.exemplo.angular.model.person.PersonEntity_;
import padeiro.exemplo.angular.utils.StringUtils;

@Service
public class OperationRepositoryImpl implements OperationRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;

	public List<OperationEntity> findOperationByDescriptionAndDate(final LocalDate validatyDate,
			final String description) {

		TypedQuery<OperationEntity> query = this.getEntityManager()
				.createQuery(OperationRepositoryQuery.findOperationByDescriptionAndDate, OperationEntity.class);
		query.setParameter("pdescription", StringUtils.lowerCaseAndConact(description));
		query.setParameter("pvalidatyDate", validatyDate);
		// query.setParameter("pactive", IObjectActiveState.ACTIVED);

		return query.getResultList();
	}

	public List<OperationEntity> findOperationByDescriptionAndOperationType(final OperationEnum operationType,
			final String description) {
		TypedQuery<OperationEntity> query = this.getEntityManager().createQuery(
				OperationRepositoryQuery.findOperationByDescriptionAndOperationType, OperationEntity.class);
		query.setParameter("pdescription", StringUtils.lowerCaseAndConact(description));
		query.setParameter("poperationType", operationType.OUTGOING);
		// query.setParameter("pactive", IObjectActiveState.ACTIVED);
		return query.getResultList();

	}

	public List<OperationEntity> findOperationByDescriptionAndOperationType(final String operationType,
			final String description) {
		TypedQuery<OperationEntity> query = this.getEntityManager().createQuery(
				OperationRepositoryQuery.findOperationByDescriptionAndOperationType, OperationEntity.class);
		query.setParameter("pdescription", StringUtils.lowerCaseAndConact(description));
		query.setParameter("poperationType", operationType);
		// query.setParameter("pactive", IObjectActiveState.ACTIVED);
		return query.getResultList();

	}

	@Override
	public Page<ProjectionOperation> findProjectionOperationByDescriptionAndDate(LocalDate validatyDate,
			String description, Pageable pageable) {

		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ProjectionOperation> criteria = builder.createQuery(ProjectionOperation.class);
		Root<OperationEntity> root = criteria.from(OperationEntity.class);

		criteria.select(builder.construct(ProjectionOperation.class, root.get(OperationEntity_.id),
				root.get(OperationEntity_.description), root.get(OperationEntity_.validatyDate),
				root.get(OperationEntity_.paymentDate), root.get(OperationEntity_.value),
				root.get(OperationEntity_.observation), root.get(OperationEntity_.person).get(PersonEntity_.name),
				root.get(OperationEntity_.category).get(CategoryEntity_.name)));

		Predicate[] predicates = createRestritions(validatyDate, description, builder, root);
		criteria.where(predicates);

		TypedQuery<ProjectionOperation> query = this.getEntityManager().createQuery(criteria);
		addRestritionOfPages(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(predicates));

	}

	@Override
	public Page<ProjectionOperation> findProjectionOperationByDescriptionAndOperationType(OperationEnum operationType,
			String description, Pageable pageable) {

		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ProjectionOperation> criteria = builder.createQuery(ProjectionOperation.class);
		Root<OperationEntity> root = criteria.from(OperationEntity.class);

		criteria.select(builder.construct(ProjectionOperation.class, root.get(OperationEntity_.id),
				root.get(OperationEntity_.description), root.get(OperationEntity_.validatyDate),
				root.get(OperationEntity_.paymentDate), root.get(OperationEntity_.value),
				root.get(OperationEntity_.observation), root.get(OperationEntity_.person).get(PersonEntity_.name),
				root.get(OperationEntity_.category).get(CategoryEntity_.name)));

		List<Predicate> predicates = new ArrayList<>();

		if (!org.springframework.util.StringUtils.isEmpty(description)) {
			predicates.add(builder.like(builder.lower(root.get(OperationEntity_.description)),
					"%" + description.toLowerCase() + "%"));
		}

		if (operationType != null) {
			predicates.add(builder.equal(root.get(OperationEntity_.operationType), operationType));
		}
		
		Predicate[] predicatesArray=predicates.toArray(new Predicate[predicates.size()]);
		
		criteria.where();

		TypedQuery<ProjectionOperation> query = this.getEntityManager().createQuery(criteria);
		addRestritionOfPages(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(predicatesArray));
	}
	private Predicate[] createRestritions(LocalDate validatyDate, String description, CriteriaBuilder builder,
			Root<OperationEntity> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!org.springframework.util.StringUtils.isEmpty(description)) {
			predicates.add(builder.like(builder.lower(root.get(OperationEntity_.description)),
					"%" + description.toLowerCase() + "%"));
		}

		if (validatyDate != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(OperationEntity_.validatyDate), validatyDate));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void addRestritionOfPages(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(Predicate[] predicates) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<OperationEntity> root = criteria.from(OperationEntity.class);

		criteria.where(predicates);
		criteria.select(builder.count(root));
		return this.getEntityManager().createQuery(criteria).getSingleResult();
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
