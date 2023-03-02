package br.com.cd2.integrator.core.ms.dao;

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
		//Fixo para domazzi, mudar depois
		try {
			User userLoged = repository.findByUserAndPass(user,pass);
		
			return userLoged;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
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
