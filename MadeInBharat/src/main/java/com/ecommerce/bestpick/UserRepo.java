package com.ecommerce.bestpick;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository that extends JPA Repository.
 *
 */
@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

}
