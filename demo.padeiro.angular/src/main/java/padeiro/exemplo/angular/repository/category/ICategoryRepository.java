package padeiro.exemplo.angular.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;

import padeiro.exemplo.angular.model.category.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
		

}
