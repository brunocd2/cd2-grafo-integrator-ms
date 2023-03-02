package br.com.cd2.integrator.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cd2.integrator.core.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>,JpaRepository<User, Long>{
	
	
	@Query(value = "SELECT ID,NAME, EMAIL, REMEMBER_TOKEN, PASS_MD5 FROM USERS WHERE EMAIL = ?1 AND PASS_MD5 =?2", nativeQuery = true)
	User findByUserAndPass(String user,String pass);
	
	@Query(value = "SELECT ID,NAME, EMAIL, REMEMBER_TOKEN, PASS_MD5 FROM USERS WHERE EMAIL = ?1 ", nativeQuery = true)
	User findByEmail(String email);

	
	@Query(value = "UPDATE USERS SET PASS_MD5 = '?2' WHERE EMAIL = '?1'", nativeQuery = true)
	Boolean updateForgotEmail(String email,String pass);
	
	

}
