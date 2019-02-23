package padeiro.exemplo.angular.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import padeiro.exemplo.angular.model.person.PersonEntity;
import padeiro.exemplo.angular.repository.person.IPersonRepository;

@Service
public class PersonService {

	@Autowired
	private IPersonRepository personRepository;

	public PersonEntity updatePerson(Long id, PersonEntity person) {

		PersonEntity personToSave = personRepository.findOne(id);
	
		if (personToSave == null) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(person, personToSave, "id");

		return personRepository.save(personToSave);
	}
}
