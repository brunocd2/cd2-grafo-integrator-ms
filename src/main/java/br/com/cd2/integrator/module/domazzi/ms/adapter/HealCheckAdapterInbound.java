package br.com.cd2.integrator.module.domazzi.ms.adapter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cd2.integrator.core.ms.i18n.Messages;
import br.com.cd2.integrator.core.ms.i18n.MessagesProperties;
import br.com.cd2.integrator.core.ms.rest.ApiResponse;
import br.com.cd2.integrator.core.ms.rest.ResponseEntityUtil;
import br.com.cd2.integrator.module.domazzi.ms.dao.DomazziDAO;
import br.com.cd2.integrator.module.domazzi.ms.dto.DomazziDTO;
import br.com.cd2.integrator.module.domazzi.ms.model.Domazzi;
import br.com.cd2.integrator.module.domazzi.ms.model.Sql;

@RestController
@CrossOrigin
@RequestMapping("/notification")
public class HealCheckAdapterInbound {
	
	@Autowired
	Messages message;
	
	@Autowired
	DomazziDAO dao;
	
	@ApiOperation(value = "Mostra os status dos processamentos ocorridos e seus integradores.")
	@ApiResponses(value = {
				@io.swagger.annotations.ApiResponse(code = 200, message = "Possíveis retornos: produtos cadastrados/atualizados com sucesso."),
				@io.swagger.annotations.ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
				@io.swagger.annotations.ApiResponse(code = 500, message = "Erro interno. Por favor, contate o nosso suporte."),
				@io.swagger.annotations.ApiResponse(code = 422, message = "Possíveis retornos: / Erro nos campos enviados. Verifique os valores e nomes dos campos, assim como a estrutura da query."),

		})

	@PostMapping(value = "/integrator_sucess", produces = "application/json", consumes = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> processedProducts(@RequestBody @Validated Sql sql) {
		System.out.println(sql);
		Boolean domazzi = null;
		try {
			Sql processamentoNovo = sql;
			if(processamentoNovo==null) {
				return ResponseEntityUtil.unprocessableResponseEntity
						(message.get(MessagesProperties.ENTITY_NOT_FOUND), sql);
			}
			else {
				if(processamentoNovo.getSql().equalsIgnoreCase("")) {
					return ResponseEntityUtil.notFoundResponseEntity
							(message.get(MessagesProperties.API_UNKNOWN_FILDS), sql);
				}else {
					domazzi = dao.saveProducts(processamentoNovo.getSql());
					if(domazzi!=false) {
					
						return ResponseEntityUtil.okResponseEntity(message.get
							(MessagesProperties.CLI_SUCESS));
					}else {
						return ResponseEntityUtil.unprocessableResponseEntity(message.get
								(MessagesProperties.API_UNKNOWN_FILDS),processamentoNovo);
						
					}
				}
				
			}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity
					(message.get(MessagesProperties.ENTITY_NOT_FOUND), sql);
	
		}
		
		}
	
	@ApiOperation(value = "Efetua o cadastro/atualização dos produtos na base cliente final que foram criados ou atualizados no dia atual.")
	@ApiResponses(value = {
				@io.swagger.annotations.ApiResponse(code = 200, message = "Possíveis retornos: produtos cadastrados/atualizados com sucesso."),
				@io.swagger.annotations.ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
				@io.swagger.annotations.ApiResponse(code = 500, message = "Erro interno. Por favor, contate o nosso suporte."),
				@io.swagger.annotations.ApiResponse(code = 422, message = "Possíveis retornos: / Erro nos campos enviados. Verifique os valores e nomes dos campos, assim como a estrutura da query."),

		})
	@PostMapping(value = "/dailly_products", produces = "application/json", consumes = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> daillyProducts(@RequestBody @Validated Sql sql) {
		System.out.println(sql);
		Boolean domazzi = null;
		try {
			Sql processamentoNovo = sql;
			if(processamentoNovo==null) {
				return ResponseEntityUtil.unprocessableResponseEntity
						(message.get(MessagesProperties.ENTITY_NOT_FOUND), sql);
			}
			else {
				if(processamentoNovo.getSql().equalsIgnoreCase("")) {
					return ResponseEntityUtil.notFoundResponseEntity
							(message.get(MessagesProperties.API_UNKNOWN_FILDS), sql);
				}else {
					domazzi = dao.saveProducts(processamentoNovo.getSql());
					if(domazzi!=false) {
					
						return ResponseEntityUtil.okResponseEntity(message.get
							(MessagesProperties.CLI_SUCESS));
					}else {
						return ResponseEntityUtil.unprocessableResponseEntity(message.get
								(MessagesProperties.API_UNKNOWN_FILDS),processamentoNovo);
						
					}
				}
				
			}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity
					(message.get(MessagesProperties.ENTITY_NOT_FOUND), sql);
	
		}
		
		}

	

}





