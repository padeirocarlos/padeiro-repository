package padeiro.exemplo.angular.repository.person;

import org.springframework.data.jpa.repository.JpaRepository;

import padeiro.exemplo.angular.model.person.PersonEntity;

public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {
		

}
