package br.com.cd2.integrator.core.ms.rest;
import java.util.UUID;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
import br.com.cd2.integrator.core.ms.i18n.Messages;
import br.com.cd2.integrator.core.ms.i18n.MessagesProperties;
import br.com.cd2.integrator.core.ms.rest.services.UserService;
import br.com.cd2.integrator.core.utils.MD5;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LoginAdapterInbound {
	
	@Autowired
	Messages message;
	
	@Autowired
	UserService service ;
	
	@Autowired
	IntegratorDAO dao;
	
	@ApiOperation(value = "Efetua o cadastro dos produtos na base cliente final.")
	@ApiResponses(value = {
				@io.swagger.annotations.ApiResponse(code = 200, message = "Possíveis retornos: produtos cadastrados/atualizados com sucesso."),
				@io.swagger.annotations.ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
				@io.swagger.annotations.ApiResponse(code = 500, message = "Erro interno. Por favor, contate o nosso suporte."),
				@io.swagger.annotations.ApiResponse(code = 422, message = "Possíveis retornos: / Erro nos campos enviados. Verifique os valores e nomes dos campos, assim como a estrutura da query."),

		})

	@PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> processedProducts(@RequestBody @Validated User user) {
		System.out.println(user);
		User domazzi = null;
		MD5 md5 =  new MD5();
		try {
			
			if(user==null) {
				return ResponseEntityUtil.unprocessableResponseEntity
						(message.get(MessagesProperties.ENTITY_NOT_FOUND), user);
			}
			else {
				if(user.getEmail().equalsIgnoreCase ("")) {
					return ResponseEntityUtil.notFoundResponseEntity
							(message.get(MessagesProperties.API_UNKNOWN_FILDS), user);
				}else {
					domazzi = dao.findByUserAndPass(user.getEmail(),MD5.getMd5(user.getPass_md5()));
					if(domazzi!=null) {
						java.util.Random r = new java.util.Random();
						byte[] bytes = new byte[20];
						
						r.nextBytes(bytes);
						
							UUID uuid = UUID.randomUUID();
							String myRandom = uuid.toString();
							user.setRemember_token((myRandom.substring(0,200).toString()));
							System.out.println(myRandom.substring(0,200));
						return ResponseEntityUtil.okResponseEntity(message.get
							(MessagesProperties.CLI_SUCESS),user);
					}else {
						return ResponseEntityUtil.unprocessableResponseEntity(message.get
								(MessagesProperties.CLI_NOT_FOUND),user);
						
					}
				}
				
			}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity
					(message.get(MessagesProperties.ENTITY_NOT_FOUND), user);
	
		}
		
		}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Validated @RequestBody User objDTO) throws ObjectNotFoundException {
		
		service.sendNewPassword(objDTO.getEmail());
		return ResponseEntity.noContent().build();
	}
	
}





