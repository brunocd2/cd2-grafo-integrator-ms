package br.com.cd2.integrator.module.domazzi.ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cd2.integrator.module.domazzi.ms.model.Domazzi;

@Repository
public interface DomazziRepositoy extends 
CrudRepository<Domazzi, Long>,JpaRepository<Domazzi, Long>{
	
	@Query(value = "SELECT * FROM PRODUCTS WHERE ID=?1", nativeQuery = true)
	Domazzi findId(Long id);
	
	@Query(value = "?1", nativeQuery = true)
	Boolean insertProductProcessed(String sql);

	@Query(value = "SELECT * FROM PRODUCTS WHERE DESCRICAO like ?1%", nativeQuery = true)
	List<Domazzi> findByName(String name);

}
