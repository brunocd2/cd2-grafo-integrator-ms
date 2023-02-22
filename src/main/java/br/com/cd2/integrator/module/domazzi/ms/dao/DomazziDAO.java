package br.com.cd2.integrator.module.domazzi.ms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cd2.integrator.module.domazzi.ms.model.Domazzi;
import br.com.cd2.integrator.module.domazzi.ms.repository.DomazziRepositoy;

@Service
public class DomazziDAO {

	@Autowired
	DomazziRepositoy repository;
	
	public Boolean saveProducts(String sql) {
		
		Boolean novoProduto = false;
		try {
			return novoProduto = repository.insertProductProcessed(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Domazzi> findAll() {
		List<Domazzi> novoProduto = null;
		try {
			return novoProduto = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return novoProduto;
		}
		
	}
	
	public Domazzi findById(Long id) {
		Domazzi novoProduto = null;
		try {
			return novoProduto = repository.findId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return novoProduto;
		}
		
	}
	
	public List<Domazzi> findByName(String name) {
		List<Domazzi> novoProduto = null;
		try {
			return novoProduto = repository.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return novoProduto;
		}
		
	}
	
	public Boolean delete(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
