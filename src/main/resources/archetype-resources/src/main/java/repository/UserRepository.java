#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import ${package}.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByEmail(String email);
    Page<User> findByNameStartsWithIgnoreCase(String name, Pageable pageable);
}
