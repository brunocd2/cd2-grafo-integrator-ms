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

	public User findByUserAndPass(String user, String pass) {

		User userLogado = new User();
		// Fixo para domazzi, mudar depois

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return null;

		}
		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:postgresql://179.188.16.145/domazzi", "domazzi",
					"FcZv4P8#6,Ijz:");
			String sql = "select * from users where EMAIL = ? AND PASS_MD5 =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			ResultSet r = preparedStatement.executeQuery();

			while (r.next()) {
				userLogado.setId(r.getLong("id"));
				userLogado.setCreated_at(r.getDate("created_at"));
				userLogado.setFirst_acess(r.getBoolean("first_acess"));
				userLogado.setLast_name(r.getString("last_name"));
				userLogado.setName(r.getString("name"));
				userLogado.setPassword(r.getString("password"));
				userLogado.setRemember_token(r.getString("remember_token"));
				userLogado.setEmail(r.getString("email"));

			}
			connection.close();
			return userLogado;

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}
		/*
		 * try { User userLoged = repository.findByUserAndPass(user,pass);
		 * 
		 * return userLoged; } catch (Exception e) { e.printStackTrace(); return null; }
		 */

	}

	public User findByEmail(String email) {
		User userLogado = new User();
		// Fixo para domazzi, mudar depois

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return null;

		}
		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:postgresql://179.188.16.145/domazzi", "domazzi",
					"FcZv4P8#6,Ijz:");
			String sql = "select * from users where EMAIL = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet r = preparedStatement.executeQuery();

			while (r.next()) {
				userLogado.setId(r.getLong("id"));
				userLogado.setCreated_at(r.getDate("created_at"));
				userLogado.setFirst_acess(r.getBoolean("first_acess"));
				userLogado.setLast_name(r.getString("last_name"));
				userLogado.setName(r.getString("name"));
				userLogado.setPassword(r.getString("password"));
				userLogado.setRemember_token(r.getString("remember_token"));
				userLogado.setEmail(r.getString("email"));

			}
			connection.close();
			return userLogado;

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}
	}
	
	public User updateFirstAcess(User user) {
		User userLogado = new User();
		// Fixo para domazzi, mudar depois

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return null;

		}
		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:postgresql://179.188.16.145/domazzi", "domazzi",
					"FcZv4P8#6,Ijz:");
			String sql = "UPDATE USERS SET PASS_MD5 = ?, PASSWORD = ?, FIRST_ACESS = false WHERE EMAIL = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getPass_md5());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());

			ResultSet r = preparedStatement.executeQuery();

			connection.close();
			return user;

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}
	}
	
	public User createUser(User user) {
		User userLogado = new User();
		// Fixo para domazzi, mudar depois

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return null;

		}
		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:postgresql://179.188.16.145/domazzi", "domazzi",
					"FcZv4P8#6,Ijz:");
			String sql = " INSERT INTO users\n"
					+ "(\"name\", email, last_name, email_verified_at, \"password\", remember_token, created_at, updated_at, pass_md5, first_acess)\n"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);\n"
					+ "";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(3, user.getLast_name());
			preparedStatement.setDate(4, user.getEmail_verified_at());
			preparedStatement.setString(5, user.getPassword());

			preparedStatement.setString(6, user.getRemember_token());
			preparedStatement.setDate(7, user.getCreated_at());
			preparedStatement.setDate(8, user.getUpdated_at());

			preparedStatement.setString(9, user.getPass_md5());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setBoolean(10, true);

			ResultSet r = preparedStatement.executeQuery();

			connection.close();
			return user;

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}
	}


}
