package com.ecommerce.bestpick;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * UserRepository that extends JPA Repository.
 *
 */
@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

	@Query(nativeQuery = true, value = "SELECT UserDetails.role FROM USER_DETAILS UserDetails WHERE UserDetails.user_id = :userId ")
	String findRole(@Param("userId") String userId);
}
