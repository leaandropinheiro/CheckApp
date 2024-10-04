package br.com.check.app.repository;

import br.com.check.app.dto.UserDto;
import br.com.check.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
