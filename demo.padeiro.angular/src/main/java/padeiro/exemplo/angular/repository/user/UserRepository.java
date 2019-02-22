package padeiro.exemplo.angular.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import padeiro.exemplo.angular.model.user.UserEntity;
/**
*
* @author cpadeiro
*/
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public Optional<UserEntity> findByEmail(String email);
}
