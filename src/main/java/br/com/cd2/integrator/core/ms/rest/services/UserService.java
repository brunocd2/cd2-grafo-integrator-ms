package br.com.cd2.integrator.core.ms.rest.services;

import java.util.Random;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cd2.integrator.core.model.User;
import br.com.cd2.integrator.core.ms.dao.IntegratorDAO;
import br.com.cd2.integrator.core.repository.UserRepository;
import br.com.cd2.integrator.core.utils.MD5;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private AbstractEmailService emailService;

	private Random random = new Random();
	
	@Autowired
	IntegratorDAO dao;
	
	@Autowired
	UserRepository repository;

	MD5 crypt =  new MD5();
	
	public User insert(User obj) throws EmailException {
		obj = repository.save(obj);
		emailService.sendNewUserEmail(obj);
		return obj;
	}

	
	public void sendNewPassword(String email) throws ObjectNotFoundException {
		
		User cliente = dao.findByEmail(email);
		if (cliente == null)
			throw new ObjectNotFoundException("Email não encontrado");

		String newPass = newPassword();
		cliente.setPass_md5(crypt.getMd5(newPass));
		
		try {
			
			repository.updateForgotEmail(cliente.email,cliente.pass_md5);
			emailService.sendNewPasswordEmail(cliente, newPass);
		} catch (Exception e) {
			emailService.sendNewPasswordEmail(cliente, newPass);
		} 
		

	}

	public String newPassword() {

		char[] vet = new char[10];

		for (int i = 0; i < vet.length; i++) {
			vet[i] = randomChar();
		}

		return new String(vet);
	}

	private char randomChar() {

		int opt = random.nextInt(3);

		switch (opt) {
		case 0:
			return (char) (random.nextInt(10) + 48);
		case 1:
			return (char) (random.nextInt(26) + 65);
		case 2:
			return (char) (random.nextInt(26) + 97);
		default:
			return 0;

		}

	}
}
