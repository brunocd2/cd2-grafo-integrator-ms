package br.com.cd2.integrator.core.ms.rest.services;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import br.com.cd2.integrator.core.model.User;

@Service
public class AbstractEmailService {

	//@Value("${default.sender}")
	private String sender = "bruno.santos@cd2.com.br";

	// @Autowired
	// private TemplateEngine engine;

	// @Autowired
	// private JavaMailSender javaMailSender;
	//


	

	
	public void sendNewUserEmail(User cliente) throws EmailException {
		 prepareNewUserEmail(cliente);
		
	}

	protected void prepareNewUserEmail(User obj) throws EmailException {
		// Cria o e-mail
		HtmlEmail email = new HtmlEmail();
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setAuthentication("bruno.santos@cd2.com.br", "230617!Bb");
		email.setSmtpPort(587);
		email.setSSL(true);
		email.setTLS(true);
		email.addTo(obj.getEmail(), obj.getName());
					email.setFrom("nao_responda@cd2.com.br", "SOLICITAÇÃO CADASTRO");
					email.setSubject("SOLICITAÇÃO CADASTRO");

					// configura a mensagem para o formato HTML
					email.setHtmlMsg("<html>\r\n"
							+ "<head></head>\r\n"
							+ "<body><p style=\"text-align: justify;\"></p><div class=\"separator\" style=\"clear: both; text-align: center;\"><br /></div><div class=\"separator\" style=\"clear: both; text-align: center;\"><a href=\"https://claudiaklein.com.br/wp-content/uploads/2018/08/1-A-import%C3%A2ncia-da-Pol%C3%ADtica-de-boas-vindas.png\" imageanchor=\"1\" style=\"margin-left: 1em; margin-right: 1em;\"><img border=\"0\" data-original-height=\"413\" data-original-width=\"800\" height=\"324\" src=\"https://claudiaklein.com.br/wp-content/uploads/2018/08/1-A-import%C3%A2ncia-da-Pol%C3%ADtica-de-boas-vindas.png\" width=\"627\" /></a></div><br /><div class=\"separator\" style=\"clear: both; text-align: center;\"><a href=\"http://solucaosacadas.com.br/wp-content/uploads/2017/05/solucao-sacadas-logo-site.png\" imageanchor=\"1\" style=\"margin-left: 1em; margin-right: 1em;\"><img border=\"0\" data-original-height=\"71\" data-original-width=\"200\" height=\"116\" src=\"http://solucaosacadas.com.br/wp-content/uploads/2017/05/solucao-sacadas-logo-site.png\" width=\"328\" /></a></div><div class=\"separator\" style=\"clear: both; text-align: center;\"><br /></div><p></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\">Bem vindo "+obj.getName()+"! Estamos muito felizes por você felizes por você possuir interesse em fazer parte da família Soluções.&nbsp;</span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\">Nossa equipe está validando suas informações, e caso estejam todas aderentes aos nossos quesitos, estaremos encaminhando um novo email de confirmação e, com este, você poderá iniciar o acesso ao nosso APP.</span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\">Fique calmo, este processo demora no máximo 24 horas.</span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\">Abaixo seguem as informações principais para que você possa efetuar seu login no aplicativo após nossa liberação:</span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\">Lembre que esses dados são privados e não devem ser compartilhados:</span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2'; font-size: medium;\"><b>Email :"+obj.getEmail()+"</b></span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2'; font-size: medium;\"><b>Senha:"+obj.getPassword()+"&nbsp;</b></span></p></body>");

					// configure uma mensagem alternativa caso o servidor não suporte HTML
					email.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");

					// envia o e-mail
					email.send();
	     

		
		}


	// @Override
	// public void sendOrderConfirmationHtmlEmail(Pedido obj) {
	// try {
	// MimeMessage mm = prepareMimeMessageFromPedido(obj);
	// sendHtmlEmail(mm);
	// } catch (Exception e) {
	// sendOrderConfirmationEmail(obj);
	// }
	//
	// }

	// protected MimeMessage prepareMimeMessageFromPedido(Pedido obj) throws
	// MessagingException {
	// MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	// MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
	// mmh.setTo(obj.getCliente().getEmail());
	// mmh.setFrom(sender);
	// mmh.setSentDate(new Date(System.currentTimeMillis()));
	// mmh.setSubject("Pedido cadaqstrado com sucesso "+obj.getId());
	// mmh.setText(htmlFromTemplatePedido(obj),true);
	// return mimeMessage;
	// }

	// protected String htmlFromTemplatePedido(Pedido obj) {
	// Context context = new Context();
	// context.setVariable("pedido", obj);
	// return engine.process("email/confirmacao-pedido", context);
	//
	// }
	
	public void sendNewPasswordEmail(User cliente, String newPass) {
		 try {
			prepareNewPasswordEmail(cliente,newPass);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void prepareNewPasswordEmail(User obj, String newPass) throws EmailException {
		HtmlEmail email = new HtmlEmail();
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setAuthentication("bruno.santos@cd2.com.br", "230617!Bb");
		email.setSmtpPort(587);
		email.setSSL(true);
		email.setTLS(true);
		email.addTo(obj.getEmail(), obj.getName());
		email.setFrom("nao_responda@cd2.com.br", "RECUPERAÇÃO DE SENHA");
		email.setSubject(" SOLICITAÇÃO NOVA SENHA");

		// configura a mensagem para o formato HTML
		email.setHtmlMsg("<html>\r\n"
				+ "<head></head>\r\n"
				+ "<body><p style=\"text-align: justify;\"></p><div class=\"separator\" style=\"clear: both; text-align: center;\"><br /></div><div class=\"separator\" style=\"clear: both; text-align: center;\"><a href=\"https://claudiaklein.com.br/wp-content/uploads/2018/08/1-A-import%C3%A2ncia-da-Pol%C3%ADtica-de-boas-vindas.png\" imageanchor=\"1\" style=\"margin-left: 1em; margin-right: 1em;\"><img border=\"0\" data-original-height=\"413\" data-original-width=\"800\" height=\"324\" src=\"https://claudiaklein.com.br/wp-content/uploads/2018/08/1-A-import%C3%A2ncia-da-Pol%C3%ADtica-de-boas-vindas.png\" width=\"627\" /></a></div><br /><div class=\"separator\" style=\"clear: both; text-align: center;\"><a href=\"http://solucaosacadas.com.br/wp-content/uploads/2017/05/solucao-sacadas-logo-site.png\" imageanchor=\"1\" style=\"margin-left: 1em; margin-right: 1em;\"><img border=\"0\" data-original-height=\"71\" data-original-width=\"200\" height=\"116\" src=\"http://solucaosacadas.com.br/wp-content/uploads/2017/05/solucao-sacadas-logo-site.png\" width=\"328\" /></a></div><div class=\"separator\" style=\"clear: both; text-align: center;\"><br /></div><p></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\">Bem vindo "+obj.getName()+"! Recebemos uma solicitação de nova senha.&nbsp;</span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\">.</span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\"></span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\">Abaixo seguem as informações principais para que você possa efetuar seu login no aplicativo após sua solicitação. Vale lembrar que será solicitada a atualização no primeiro acesso:</span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2';\">Lembre que esses dados são privados e não devem ser compartilhados:</span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2'; font-size: medium;\"><b>Email :"+obj.getEmail()+"</b></span></p><p style=\"text-align: justify;\"><span style=\"font-family: 'Exo 2'; font-size: medium;\"><b>Senha:"+newPass+"&nbsp;</b></span></p></body>");

		// configure uma mensagem alternativa caso o servidor não suporte HTML
		email.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");

		// envia o e-mail
		email.send();

	}
	
	}
	
/*public static void main(String args[]) throws EmailException {
	AbstractEmailService ab = new AbstractEmailService();
	Cliente obj =  new Cliente();
	obj.setNome("Teste");
	obj.setEmail("bruno.santos@cd2.com.br");
	obj.setSenha("123456");
	ab.prepareNewUserEmail(obj);
	
}*/
