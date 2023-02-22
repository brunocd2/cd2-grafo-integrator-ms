# CD2 Grafo Integrator Ms

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Sistema responsável integração e insersão dos produtos de clientes internos e externos gerados no projeto CD2 Grafo Integrator.

  - Liberação de serviços para gestão e controle de Produtos.
  - Consumidor de protocolos e credenciais de acesso via Oauth 2.
  
# New Features!

- Autorização de Sistemas Clientes;
- Cadastrar Produtos;
- Pesquisa de Produtos;
- Alteração de Senha de Usuário;
- Reset de Senha;
- Remoção Lógica;
- Atualização do Usuário;
- Convite de Usuário;
- Pesquisa de Usuário

COMO PLUS:
 - Disponibilização do Swagger para auxiliar no uso e entendimento das regras do negócio;
 
### Tech

#### Arquitetura da Integração:

##### [Arquitetura C4Level](https://cd2.atlassian.net/wiki/spaces/JCDC/pages/14680065/Integradores+Domazzi+-++Apache+Airflow%3A+maestro+de+pipelines+de+tarefas+agendadas)


Tecnologias, frameworks e componentes utilizados:

* [Java 8] - Versão do java para compilação do sistema
* [Spring Framework] Utilização de alguns dos componentes spring para agilidade no desenvolvimento
* [Postman] - Utilizado para testes dos endpoints criados. Para import dos endpoints, basta exportar os mesmos do swagger para arquivo do tipo json.
* [Spring Boot] - Para otimização do trabalho e foco na regra de negócio
* [Tomcat Embeded] - Servidor web embarcado para fácil build e execulção do projeto.
* [H2/oracle] - Bancos de dados testados na aplicação. H2 facilita o uso devido a utilização em memória, porém os dados serão perdidos a cada novo rum. Oracle é um dos bancos relacionais mais utilizados e free. Foi testado na versão 11G .
* [maven] - para gestão de dependências
* [Swagger] - Para documentação dos serviços criados
* [Factory e MVC] - Para generalização e centralização dos códigos comuns assim como separação de regras de negócio, modelos, serviços, controladores e ultilitários
* [GIT] - Para gestão dos fontes do projeto
* Spring Data
* Spring Data Rest
* Hibernate Envers
* [OAUTH 2] - O OAuth 2.0 é um protocolo padrão para autorização. Permite que aplicativos como Web App, Mobile e Desktop obtenham acesso limitado às informações de Produtos através do protocolo HTTP.

##### Hibernate Envers
O Envers é um módulo que faz parte do projeto Hibernate ORM (Mapeamento objeto relacional), e ele provê uma maneira fácil de fazer auditoria e versionamento de suas classes entidades.

##### Spring Data REST
O Spring Data REST faz parte do projeto guarda-chuva Spring Data, e facilita a criação de serviços da Web REST baseados em hipermídia sobre os repositórios Spring Data;
Ele se baseia nos repositórios do Spring Data, analisa o modelo de domínio de seu aplicativo e expõe recursos HTTP orientados por hipermídia para agregados contidos no modelo.

Estrutura da aplicação
Estamos seguindo a estrategia de isolamento do dominio, para isso estamos seguindo conceitos importantes de desenvolvimento como clean arquitecture, DDD e Hexagonal.

A estrutura dos pacotes ficou definida como:

    │   │                       ├───application
    │   │                       │   ├───config
    │   │                       │   ├───controller
    │   │                       │   └───dto
    │   │                       ├───domain
    │   │                       │   ├───port
    │   │                       │   │   ├───inbound
    │   │                       │   │   └───outbound
    │   │                       │   └───service
    │   │                       └───infrastructure
    │   │                           └───amqp

Sendo:

Application: Porta de entrada da nossa aplicação, contem tudo que precisamos para conectar outros sistemas com o nosso domínio como, por exemplo, o controller com os endpoints da aplicação, seguindo o contrato da api. A comunicação dessa camada com o domain é feita através de interfaces definidas no inbound no pacote de domínio.

Domain: Essa camada vai conter toda a nossa regra de negócios, é aqui que fazemos a implementação dos nossos services (casos de uso) e das nossas classes de domínio.

Infrastructure: Toda a comunicação e configuração externa do nosso sistema. A comunicação com esse modulo é feito através de interfaces definidas no outbound do nosso sistema, visando o desacoplamento da solução com os detalhes de infraestrutura.

### Installation

Clonar o projeto de [Clone]().

Incorporar o projeto em seu IDE de preferencia (Eclipse, Netbeans, Intellj)

Após baixar o projeto e o mesmo estar configurado como 'boot' efetue as seguintes etapas:
- Caso não esteja habilitado como projeto  maven, habilite-o.
Executar os comandos do Maven:
- Maven Clean
- Maven Install
- E, caso não possua o plugin do spring boot, favor baixar e instalar;
- Antes de subir a aplicação, deve-se selecionar qual banco de dados será imcorporado, por padrão está no H2, porém, para alterar basta acessar o arquivo: application.properties. Nele você verá uma parte comentada que é a configuração do banco Mysql, para usar, basta descomentar o trecho e comentar a configuração do H2 ou vice-versa assim como ajustar as credenciais de autenticação da sua base de dados.
- Após este passo, executar o projeto como ----> - spring boot Aplication:
- Caso seja eclipse: Botão direito no projeto > Run as > Spring boot application.
- Aguardar o projeto subir. Não é preciso que você crie a base de dados. Ao alterar a configuração de qual banco usar, o sistema irá criar as tabelas assim como criar o cadastro de todos os estados para facilitar o uso. O arquivo com os scripts chama-se * data.sql
- para verificar se o sistema está no ar, basta acessar: http://localhost:8080
- Para utilização e teste dos endpoints, podem ser feitos pelo navegador ou pelo Postman.
- Para visualização dos endpoints e instruções de uso, basta acessar o swagger:
http://localhost:8080/swagger-ui.html
- Caso esteja usando o BD H2, segue dados para acesso:
- http://localhost:8080/h2-console/, JDBC URL= jdbc:h2:mem:Instivo-id, User=sa, Senha=

Vamos preparar um registro de cliente dinâmico com o OAuth2.0. O OAuth2.0 é uma estrutura de autorização que permite obter acesso limitado a contas de usuário em um serviço HTTP. O cliente OAuth2.0 é o aplicativo que deseja acessar a conta do usuário. Este cliente pode ser um aplicativo da web externo, um agente de usuário ou apenas um cliente nativo.

Para obter o registro de cliente dinâmico, vamos armazenar as credenciais no banco de dados, em vez da configuração codificada. O aplicativo que iremos estender foi inicialmente descrito no tutorial Spring REST API + OAuth2 .

