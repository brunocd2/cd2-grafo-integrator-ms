package br.com.cd2.integrator.module.domazzi.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cd2.integrator.core.model.User;
import br.com.cd2.integrator.module.domazzi.ms.model.Domazzi;

@Repository
public interface DomazziRepositoy extends 
CrudRepository<Domazzi, Long>,JpaRepository<Domazzi, Long>{
	
	@Query(value = "SELECT * FROM PRODUCTS WHERE CODIGO_ACESSO_PRINCIPAL=?1", nativeQuery = true)
	Domazzi findId(Long id);
	
	@Query(value = "SELECT * FROM PRODUCTS WHERE PARCEIRO like ?1", nativeQuery = true)
	List<Domazzi> findByName(String name);
	
	@Query(value = "SELECT * FROM PRODUCTS WHERE PARCEIRO = ?2 AND CODIGO_ACESSO_PRINCIPAL =?1", nativeQuery = true)
	List<Domazzi> findByEanAndPartner(Long ean,String partner);
	
	@Query(value = "SELECT NAME, EMAIL, REMEMBER_TOKEN, PASS_MD5 FROM USERS WHERE EMAIL = ?1 AND PASS_MD5 =?2", nativeQuery = true)
	User findByUserAndPass(String user,String pass);
	
	@Query(value = "SELECT * FROM PRODUCTS WHERE  CATEGORIA like ?1%", nativeQuery = true)
	List<Domazzi> findByCategoria(String categoria);

}
