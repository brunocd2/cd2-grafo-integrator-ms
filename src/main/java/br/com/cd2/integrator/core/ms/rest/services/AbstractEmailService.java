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
					email.setFrom("nao_responda@cd2.com.br", "SEU CADASTRO FOI APROVADO");
					email.setSubject("SOLICITAÇÃO CADASTRO");

					// configura a mensagem para o formato HTML
					email.setHtmlMsg("<html><head><meta content=\"text/html; charset=UTF-8\" http-equiv=\"content-type\"><style type=\"text/css\">@import url('https://themes.googleusercontent.com/fonts/css?kit=fvyYZ8D_r6q1snYdb-tnF6Gq3fd52zrAS7XUuAmYWWqZb8Ihm-RxbWLszD2ZWjk_DWcaFCKawO684pOIkIkblA');ol{margin:0;padding:0}table td,table th{padding:0}.c7{background-color:#ffffff;padding-top:0pt;padding-bottom:6pt;line-height:1.15;orphans:2;widows:2;text-align:left;height:36pt}.c1{color:#0d1233;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:16.5pt;font-family:\"Ubuntu\";font-style:normal}.c9{color:#434343;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:12pt;font-family:\"Ubuntu\";font-style:normal}.c17{padding-top:10pt;padding-bottom:0pt;line-height:1.15;orphans:2;widows:2;text-align:left;height:11pt}.c10{color:#0d1233;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:12pt;font-family:\"Ubuntu\";font-style:normal}.c0{padding-top:10pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:center;height:11pt}.c4{padding-top:0pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:left;height:11pt}.c2{background-color:#ffffff;padding-top:5pt;padding-bottom:14pt;line-height:1.625;orphans:2;widows:2;text-align:left}.c15{background-color:#ffffff;padding-top:5pt;padding-bottom:14pt;line-height:1.15;orphans:2;widows:2;text-align:left}.c12{background-color:#ffffff;padding-top:0pt;padding-bottom:6pt;line-height:1.15;orphans:2;widows:2;text-align:left}.c3{color:#0d1233;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:18pt;font-family:\"Ubuntu\";font-style:normal}.c6{padding-top:0pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:center;height:11pt}.c8{color:#666666;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:12pt;font-family:\"Lora\";font-style:normal}.c5{color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:11pt;font-family:\"Lora\";font-style:normal}.c16{padding-top:10pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:center}.c14{font-size:12pt;font-family:\"Ubuntu\";color:#434343;font-weight:700}.c13{font-size:12pt;font-family:\"Ubuntu\";color:#434343;font-weight:400}.c11{background-color:#ffffff;max-width:468pt;padding:54pt 72pt 54pt 72pt}.title{padding-top:10pt;color:#000000;font-weight:700;font-size:12pt;padding-bottom:0pt;font-family:\"Lora\";line-height:1.0;orphans:2;widows:2;text-align:center}.subtitle{padding-top:0pt;color:#666666;font-size:10pt;padding-bottom:0pt;font-family:\"Quicksand\";line-height:1.0;orphans:2;widows:2;text-align:center}li{color:#000000;font-size:11pt;font-family:\"Lora\"}p{margin:0;color:#000000;font-size:11pt;font-family:\"Lora\"}h1{padding-top:10pt;color:#000000;font-size:36pt;padding-bottom:0pt;font-family:\"Lora\";line-height:1.0;orphans:2;widows:2;text-align:center}h2{padding-top:24pt;color:#000000;font-size:20pt;padding-bottom:0pt;font-family:\"Lora\";line-height:1.15;orphans:2;widows:2;text-align:left}h3{padding-top:6pt;color:#999999;font-size:11pt;padding-bottom:6pt;font-family:\"Lora\";line-height:1.3;orphans:2;widows:2;text-align:left}h4{padding-top:0pt;color:#434343;font-size:10pt;padding-bottom:0pt;font-family:\"Quicksand\";line-height:1.0;orphans:2;widows:2;text-align:center}h5{padding-top:8pt;color:#666666;font-size:11pt;padding-bottom:0pt;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h6{padding-top:8pt;color:#666666;font-size:11pt;padding-bottom:0pt;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;font-style:italic;orphans:2;widows:2;text-align:left}</style></head><body class=\"c11 doc-content\"><p class=\"c6\"><span class=\"c5\"></span></p><p class=\"c16 title\" id=\"h.y1cfga7ckpmi\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 154.50px; height: 92.11px;\"><img alt=\"\" src=\"https://i.postimg.cc/vT2rK7tn/image2.png\" style=\"width: 154.50px; height: 92.11px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"\"></span></p><p class=\"c0 title\" id=\"h.26uwcp8lt3xk\"><span class=\"c8\"></span></p><p class=\"c0 title\" id=\"h.r0lfs2g5697e\"><span class=\"c8\"></span></p><p class=\"c17\"><span class=\"c5\"></span></p><h1 class=\"c7\" id=\"h.t3uuyfixi9rn\"><span class=\"c1\"></span></h1><h1 class=\"c12\" id=\"h.7t0ah5fh8p0s\"><span class=\"c1\">Boas vindas, "+obj.getName()+" "+obj.getLast_name()+"!</span></h1><p class=\"c2\"><span class=\"c9\">Estamos muito felizes por voc&ecirc; possuir interesse em fazer parte desta família.</span></p><p class=\"c2\"><span class=\"c9\">Estamos validando suas informa&ccedil;&otilde;es e logo enviaremos um novo email de confirma&ccedil;&atilde;o para o seu acesso ao nosso App.</span></p><p class=\"c2\"><span class=\"c9\">Fique tranquilo, voc&ecirc; já pode utilizar seu usuário e senha para logar no Analytics.</span></p><p class=\"c2\"><span class=\"c9\">Abaixo seguem as informa&ccedil;&otilde;es principais para que voc&ecirc; possa efetuar seu login no aplicativo ap&oacute;s nossa libera&ccedil;&atilde;o.</span></p><p class=\"c15\"><span class=\"c3\">Email: "+obj.getEmail()+" <br>Senha (provisória): "+obj.getPassword()+"</span></p>\r\n"
							+ "	<a href=\"https://domazzi.cd2.com.br\">Clique aqui para acessar o Analytics</a><p class=\"c2\"><span class=\"c14\">Lembre que esses dados s&atilde;o privados e n&atilde;o devem ser compartilhados.</span></p><p class=\"c2\"><span class=\"c13\">Obrigado,<br></span><span class=\"c10\">Equipe CD2 Retail Tech</span></p><p class=\"c2\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 816.50px; height: 139.06px;\"><img alt=\"\" src=\"https://i.postimg.cc/x81GgpMY/image1.png\" style=\"width: 816.50px; height: 139.06px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"\"></span></p><p class=\"c4\"><span class=\"c5\"></span></p></body></html>");
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
		email.setHtmlMsg("<html><head><meta content=\"text/html; charset=UTF-8\" http-equiv=\"content-type\"><style type=\"text/css\">@import url('https://themes.googleusercontent.com/fonts/css?kit=fvyYZ8D_r6q1snYdb-tnF6Gq3fd52zrAS7XUuAmYWWqZb8Ihm-RxbWLszD2ZWjk_DWcaFCKawO684pOIkIkblA');ol{margin:0;padding:0}table td,table th{padding:0}.c4{background-color:#ffffff;padding-top:0pt;padding-bottom:6pt;line-height:1.15;orphans:2;widows:2;text-align:left;height:36pt}.c13{background-color:#ffffff;padding-top:0pt;padding-bottom:6pt;line-height:1.15;orphans:2;widows:2;text-align:left}.c16{padding-top:0pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:left;height:11pt}.c0{background-color:#ffffff;padding-top:5pt;padding-bottom:14pt;line-height:1.625;orphans:2;widows:2;text-align:left}.c9{background-color:#ffffff;padding-top:5pt;padding-bottom:14pt;line-height:1.15;orphans:2;widows:2;text-align:left}.c1{color:#000000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:11pt;font-family:\"Lora\";font-style:normal}.c12{padding-top:10pt;padding-bottom:0pt;line-height:1.15;orphans:2;widows:2;text-align:left;height:11pt}.c17{padding-top:0pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:center;height:11pt}.c11{padding-top:10pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:center;height:11pt}.c15{padding-top:10pt;padding-bottom:0pt;line-height:1.0;orphans:2;widows:2;text-align:center}.c10{color:#0d1233;font-weight:700;font-size:12pt;font-family:\"Ubuntu\"}.c7{color:#0d1233;font-weight:700;font-size:16.5pt;font-family:\"Ubuntu\"}.c3{font-size:12pt;font-family:\"Ubuntu\";color:#434343;font-weight:400}.c6{color:#666666;font-weight:700;font-size:12pt;font-family:\"Lora\"}.c14{color:#434343;font-weight:700;font-size:12pt;font-family:\"Ubuntu\"}.c8{color:#0d1233;font-weight:700;font-size:18pt;font-family:\"Ubuntu\"}.c2{background-color:#ffffff;max-width:468pt;padding:54pt 72pt 54pt 72pt}.c5{text-decoration:none;vertical-align:baseline;font-style:normal}.title{padding-top:10pt;color:#000000;font-weight:700;font-size:12pt;padding-bottom:0pt;font-family:\"Lora\";line-height:1.0;orphans:2;widows:2;text-align:center}.subtitle{padding-top:0pt;color:#666666;font-size:10pt;padding-bottom:0pt;font-family:\"Quicksand\";line-height:1.0;orphans:2;widows:2;text-align:center}li{color:#000000;font-size:11pt;font-family:\"Lora\"}p{margin:0;color:#000000;font-size:11pt;font-family:\"Lora\"}h1{padding-top:10pt;color:#000000;font-size:36pt;padding-bottom:0pt;font-family:\"Lora\";line-height:1.0;orphans:2;widows:2;text-align:center}h2{padding-top:24pt;color:#000000;font-size:20pt;padding-bottom:0pt;font-family:\"Lora\";line-height:1.15;orphans:2;widows:2;text-align:left}h3{padding-top:6pt;color:#999999;font-size:11pt;padding-bottom:6pt;font-family:\"Lora\";line-height:1.3;orphans:2;widows:2;text-align:left}h4{padding-top:0pt;color:#434343;font-size:10pt;padding-bottom:0pt;font-family:\"Quicksand\";line-height:1.0;orphans:2;widows:2;text-align:center}h5{padding-top:8pt;color:#666666;font-size:11pt;padding-bottom:0pt;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h6{padding-top:8pt;color:#666666;font-size:11pt;padding-bottom:0pt;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;font-style:italic;orphans:2;widows:2;text-align:left}</style></head><body class=\"c2 doc-content\"><p class=\"c17\"><span class=\"c1\"></span></p><p class=\"c15 title\" id=\"h.y1cfga7ckpmi\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 154.50px; height: 92.11px;\"><img alt=\"\" src=\"https://i.postimg.cc/vT2rK7tn/image2.png\" style=\"width: 154.50px; height: 92.11px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"\"></span></p><p class=\"c11 title\" id=\"h.26uwcp8lt3xk\"><span class=\"c6 c5\"></span></p><p class=\"c11 title\" id=\"h.r0lfs2g5697e\"><span class=\"c6 c5\"></span></p><p class=\"c12\"><span class=\"c1\"></span></p><h1 class=\"c4\" id=\"h.t3uuyfixi9rn\"><span class=\"c5 c7\"></span></h1><h1 class=\"c13\" id=\"h.7t0ah5fh8p0s\"><span class=\"c7 c5\">Ol&aacute;, "+obj.getName()+" "+obj.getLast_name()+"!</span></h1><p class=\"c0\"><span class=\"c3\">Recebemos sua solicita&ccedil;&atilde;o de nova senha</span><span class=\"c3 c5\">. Abaixo seguem as informa&ccedil;&otilde;es principais para que voc&ecirc; possa efetuar seu login no aplicativo.</span></p><p class=\"c0\"><span class=\"c3\">Para seguran&ccedil;a da sua conta, voc&ecirc; receber&aacute; uma solicita&ccedil;&atilde;o de atualiza&ccedil;&atilde;o de senha no seu primeiro acesso. &nbsp;</span><span class=\"c5 c14\">Lembre que esses dados s&atilde;o privados e n&atilde;o devem ser compartilhados.</span></p><p class=\"c9\"><span class=\"c5 c8\">Email: "+obj.getEmail()+" <br>Senha: "+obj.getPassword()+"</span></p><p class=\"c0\"><span class=\"c3 c5\">Se voc&ecirc; n&atilde;o solicitou a redefini&ccedil;&atilde;o de senha, contate o suporte caso tenha d&uacute;vidas.</span></p><p class=\"c0\"><span class=\"c3\">Obrigado,<br></span><span class=\"c10 c5\">Equipe CD2 Retail Tech</span></p><p class=\"c0\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 816.50px; height: 139.06px;\"><img alt=\"\" src=\"https://i.postimg.cc/x81GgpMY/image1.png\" style=\"width: 816.50px; height: 139.06px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"\"></span></p><p class=\"c16\"><span class=\"c1\"></span></p></body></html>");
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
