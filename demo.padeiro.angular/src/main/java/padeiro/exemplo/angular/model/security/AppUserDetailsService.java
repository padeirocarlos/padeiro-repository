package padeiro.exemplo.angular.model.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import padeiro.exemplo.angular.model.user.UserEntity;
import padeiro.exemplo.angular.repository.user.UserRepository;
/**
 * @author cpadeiro
 */
@Service
public class AppUserDetailsService implements UserDetailsService{

	@Inject
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<UserEntity> userOptional = userRepository.findByEmail(email);
		
		UserEntity userEntity = userOptional
				.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
		
		return new User(email, userEntity.getPassword(), getPermissoes(userEntity));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(UserEntity userEntity) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		userEntity.getAuthorizations()
				.forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		return authorities;
	}

}
