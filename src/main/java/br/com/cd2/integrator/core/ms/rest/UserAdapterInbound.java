package br.com.cd2.integrator.core.ms.rest;

import java.sql.Date;
import java.util.Random;
import java.util.UUID;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cd2.integrator.core.model.User;
import br.com.cd2.integrator.core.ms.dao.IntegratorDAO;
import br.com.cd2.integrator.core.ms.dto.LoginDTO;
import br.com.cd2.integrator.core.ms.dto.MailDTO;
import br.com.cd2.integrator.core.ms.dto.UserDTO;
import br.com.cd2.integrator.core.ms.i18n.Messages;
import br.com.cd2.integrator.core.ms.i18n.MessagesProperties;
import br.com.cd2.integrator.core.ms.rest.services.UserService;
import br.com.cd2.integrator.core.repository.UserRepository;
import br.com.cd2.integrator.core.utils.MD5;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserAdapterInbound {

	@Autowired
	Messages message;

	@Autowired
	UserService service;

	@Autowired
	UserRepository repository;
	
	@Autowired
	IntegratorDAO dao;

	@ApiOperation(value = "Efetua o login dos clientes com usuario e senha.")
	@ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Possíveis retornos: usuario logado com seu token."),
			@io.swagger.annotations.ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@io.swagger.annotations.ApiResponse(code = 500, message = "Erro interno. Por favor, contate o nosso suporte."),
			@io.swagger.annotations.ApiResponse(code = 422, message = "Possíveis retornos: / Erro nos campos enviados. Verifique os valores e nomes dos campos, assim como a estrutura da query."),

	})

	@PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> processedProducts(@RequestBody @Validated LoginDTO user) {
		System.out.println(user);
		User domazzi = null;
		MD5 md5 = new MD5();
		try {

			if (user == null) {
				return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
						user);
			} else {
				if (user.getEmail().equalsIgnoreCase("")) {
					return ResponseEntityUtil.notFoundResponseEntity(message.get(MessagesProperties.API_UNKNOWN_FILDS),
							user);
				} else {
					domazzi = dao.findByUserAndPass(user.getEmail(), MD5.getMd5(user.getPassword()));
					if (!domazzi.getEmail().equalsIgnoreCase("") || domazzi.getEmail()!=null) {
						java.util.Random r = new java.util.Random();
						byte[] bytes = new byte[20];

						r.nextBytes(bytes);

						UUID uuid = UUID.randomUUID();
						String myRandom = uuid.toString();
						String token = myRandom.toString();
						domazzi.setRemember_token(token);
						
						return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.USU_SUCESS), domazzi);
					} else {
						return ResponseEntityUtil
								.unprocessableResponseEntity(message.get(MessagesProperties.USU_NOT_FOUND), user);

					}
				}

			}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
					user);

		}

	}
	
	@PostMapping(value = "/update_first_acess", produces = "application/json", consumes = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> UpdateAcess(@RequestBody @Validated User user) {
		System.out.println(user);
		try {

			if (user == null) {
				return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
						user);
			} else {
				if (user.getEmail().equalsIgnoreCase("")) {
					return ResponseEntityUtil.notFoundResponseEntity(message.get(MessagesProperties.API_UNKNOWN_FILDS),
							user);
				} else {
					if(user.getFirst_acess()==true) {
						
						user.setFirst_acess(false);
						repository.save(user);
					}
					return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.USU_SUCESS), user);
				}

			}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
					user);

		}

	}


	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<ApiResponse> forgot(@Validated @RequestBody MailDTO objDTO) throws ObjectNotFoundException {

		service.sendNewPassword(objDTO.getEmail());
		return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.EMAIL_FOUND), objDTO);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ApiResponse> insert(@Validated @RequestBody UserDTO objDTO) throws EmailException {
		if (objDTO == null) {
			return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.ENTITY_NOT_FOUND),
					objDTO);
		} else {

			if (objDTO.getEmail().equalsIgnoreCase("") || objDTO.getName().equalsIgnoreCase("")) {
				return ResponseEntityUtil.notFoundResponseEntity(message.get(MessagesProperties.API_UNKNOWN_FILDS),
						objDTO);
			} else {
				
				User user_email = repository.findByEmail(objDTO.getEmail());
				
				
				if(user_email!=null) {
					
					return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.EMAIL_FOUND), objDTO.email);
				}else {
				User user = new User();
		        Random gerador = new Random();
		        user.setId(Long.parseLong(String.valueOf(gerador.nextInt(1000000))));
				user.setPassword(service.newPassword());
				user.setPass_md5(MD5.getMd5(user.getPassword()));
				long  millis=System.currentTimeMillis();  
				user.setCreated_at(new Date(millis));
				user.setEmail_verified_at(new Date(millis));
				user.setUpdated_at(null);
				user.setEmail(objDTO.getEmail());
				user.setLast_name(objDTO.getLast_name());
				user.setName(objDTO.getName());
				user.setFirst_acess(true);
				
				user = service.insert(user);
				if (user != null) {

					return ResponseEntityUtil.okResponseEntity(message.get(MessagesProperties.CAD_USU_SUCESS), user);
				} else {
					return ResponseEntityUtil.unprocessableResponseEntity(message.get(MessagesProperties.USU_NOT_FOUND),
							user);
				}
				}
			}
		}

	}

}
