package br.com.cd2.integrator.module.domazzi.ms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		
		try {

			Class.forName("org.postgresql.Driver");
			

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return false;

		}
		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://ec2-54-173-77-184.compute-1.amazonaws.com:5432/dab7dm6f9nlecn", "zydcmkrqlequyr",
					"7be726068f9523dc3a22d0eb11c9b35f283a101baa7e7d726750eb5e4cf5f896");
			 
			
			
			PreparedStatement pstm = connection.prepareStatement(sql);
			
			pstm.execute();
			pstm.close();
                        System.out.println("produto adicionado ");
                        connection.close();
                        return true;


		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
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