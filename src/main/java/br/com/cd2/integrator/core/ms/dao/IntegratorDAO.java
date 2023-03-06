package br.com.cd2.integrator.core.ms.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cd2.integrator.core.model.User;
import br.com.cd2.integrator.core.repository.UserRepository;
import br.com.cd2.integrator.module.domazzi.ms.repository.DomazziRepositoy;

@Service
public class IntegratorDAO {

	@Autowired
	UserRepository repository;
	

	public User findByUserAndPass(String user,String pass) {
		
		User userLogado =  new User();
		//Fixo para domazzi, mudar depois

		try {

			Class.forName("org.postgresql.Driver");
			

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return null;

		}
		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://179.188.16.145/domazzi", "domazzi",
					"FcZv4P8#6,Ijz:");
			String sql = "select * from users where EMAIL = ? AND PASS_MD5 =?";  
			PreparedStatement preparedStatement = connection.prepareStatement(sql);  
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			ResultSet r = preparedStatement.executeQuery();  
			
			
			  while (r.next()){
				  userLogado.setEmail(r.getString("email"));
					
				}
			                        connection.close();
                        return userLogado;


		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}
		/*try {
			User userLoged = repository.findByUserAndPass(user,pass);
		
			return userLoged;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		*/
		
	}
	
	public User findByEmail(String email
) {
		//Fixo para domazzi, mudar depois
		try {
			User userLoged = repository.findByEmail(email);
		
			return userLoged;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
}
