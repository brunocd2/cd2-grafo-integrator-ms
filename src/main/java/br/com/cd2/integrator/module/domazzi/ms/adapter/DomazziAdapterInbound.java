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
import br.com.cd2.integrator.module.domazzi.ms.model.Domazzi;
import br.com.cd2.integrator.module.domazzi.ms.model.Sql;

@RestController
@CrossOrigin
@RequestMapping("/domazzi")
public class DomazziAdapterInbound {
	
	@Autowired
	Messages message;
	
	@Autowired
	DomazziDAO dao;
	
	@ApiOperation(value = "Efetua o cadastro dos produtos na base cliente final.")
	@ApiResponses(value = {
				@io.swagger.annotations.ApiResponse(code = 200, message = "Possíveis retornos: produtos cadastrados/atualizados com sucesso."),
				@io.swagger.annotations.ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
				@io.swagger.annotations.ApiResponse(code = 500, message = "Erro interno. Por favor, contate o nosso suporte."),
				@io.swagger.annotations.ApiResponse(code = 422, message = "Possíveis retornos: / Erro nos campos enviados. Verifique os valores e nomes dos campos, assim como a estrutura da query."),

		})

	@PostMapping(value = "/processed_products", produces = "application/json", consumes = "application/json")
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

	
	@PatchMapping(value = "/update_products", produces = "application/json", consumes = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> updateUser(@RequestBody @Validated Domazzi domazzi) {
		try {
			Domazzi updateNovo = domazzi;
			if(domazzi==null) {
				return ResponseEntityUtil.unprocessableResponseEntity
						(message.get(MessagesProperties.ENTITY_NOT_FOUND), domazzi);
			}
			else {
			/*	if(updateNovo.getNome().equalsIgnoreCase("")
						|| updateNovo.getSenha().equals("")) {
					return ResponseEntityUtil.notFoundResponseEntity
							(message.get(MessagesProperties.API_UNKNOWN_FILDS), domazzi);
				}else {
					updateNovo = dao.saveUser(domazzi);
					if(updateNovo!=null) {
					
						return ResponseEntityUtil.okResponseEntity(message.get
							(MessagesProperties.CLI_UPDATED));
					}else {
						return ResponseEntityUtil.unprocessableResponseEntity(message.get
								(MessagesProperties.API_UNKNOWN_FILDS),updateNovo);
						
					}
					*/
				}
				
			//}
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity
					(message.get(MessagesProperties.ENTITY_NOT_FOUND), domazzi);
	
		}
		return null;
		}
	
	@GetMapping(value = "/find_all_products", produces = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> findAll() {
		List<Domazzi> listProducts = null;
		try {
			
			listProducts = dao.findAll();
				if(listProducts.isEmpty()) {
					return ResponseEntityUtil.notFoundResponseEntity
							(message.get(MessagesProperties.CLI_NOT_FOUND), listProducts);
				}else {
					
						return ResponseEntityUtil.okResponseEntity(message.get
							(MessagesProperties.CLI_FINDED),listProducts);		
				}
		
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity
					(message.get(MessagesProperties.ENTITY_NOT_FOUND), listProducts);

		}		
		}
	
	@GetMapping(value = "/find_products_by_id", produces = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> findById(@RequestParam("id") Long id) {
		Domazzi listProducts = null;
		try {
			
			listProducts = dao.findById(id);
				if(listProducts == null) {
					return ResponseEntityUtil.notFoundResponseEntity
							(message.get(MessagesProperties.CLI_NOT_FOUND), listProducts);
				}else {
					
						return ResponseEntityUtil.okResponseEntity(message.get
							(MessagesProperties.CLI_FINDED),listProducts);		
				}
		
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity
					(message.get(MessagesProperties.ENTITY_NOT_FOUND), listProducts);

		}		
		}
	
	@DeleteMapping(value = "/delete_products", produces = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> delete(@RequestParam("id") Long id) {
		boolean resultado = false;
		try {
				if(resultado = dao.delete(id)==false) {
					return ResponseEntityUtil.notFoundResponseEntity
							(message.get(MessagesProperties.CLI_NOT_FOUND),null);
				}else {		
						return ResponseEntityUtil.okResponseEntity(message.get
							(MessagesProperties.CLI_DELETED));		
				}
		
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity
					(message.get(MessagesProperties.ENTITY_NOT_FOUND),null);
		}		
		}

	@GetMapping(value = "/find_products_by_partner", produces = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> findByName(@RequestParam("partner") String partner) {
		List<Domazzi> listProducts = null;
		try {
			
			listProducts = dao.findByName(partner);
				if(listProducts == null) {
					return ResponseEntityUtil.notFoundResponseEntity
							(message.get(MessagesProperties.CLI_NOT_FOUND), listProducts);
				}else {
					
						return ResponseEntityUtil.okResponseEntity(message.get
							(MessagesProperties.CLI_FINDED),listProducts);		
				}
		
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity
					(message.get(MessagesProperties.ENTITY_NOT_FOUND), listProducts);

		}		
		}
	
	@GetMapping(value = "/find_products_by_partner_and_ean", produces = "application/json")
	@ResponseBody
	@CrossOrigin
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ApiResponse> findByEanAndPartner(@RequestParam("partner") String partner, @RequestParam("ean") Long ean) {
		List<Domazzi> listProducts = null;
		try {
			
			listProducts = dao.findByEanAndPartner(ean,partner);
				if(listProducts == null) {
					return ResponseEntityUtil.notFoundResponseEntity
							(message.get(MessagesProperties.CLI_NOT_FOUND), listProducts);
				}else {
					
						return ResponseEntityUtil.okResponseEntity(message.get
							(MessagesProperties.CLI_FINDED),listProducts);		
				}
		
		} catch (Exception e) {
			return ResponseEntityUtil.unprocessableResponseEntity
					(message.get(MessagesProperties.ENTITY_NOT_FOUND), listProducts);

		}		
		}

}





