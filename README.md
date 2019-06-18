## Spring Cliente Rest com API  ipvigilante e metaweather

### Como usar os serviços
Para usar o serviço será utilizado comandos Curl, pode ser utilizado o console git para executar (Git Bash, https://git-scm.com). Porém, caso necessário, é possível utilizar algum programa instalado no ambiente como Postman(https://www.getpostman.com/products) ou o Curl para windowns (https://curl.haxx.se/windows).
###### Comandos curl:
- **Criar cliente:** 
		curl -X POST -H "Content-Type: application/json" -d '{"nome":"Matheus Oliveira", "idade" : 23 }' "http://localhost:8080/cliente"
- **Atualizar cliente:** 
		curl -X PUT -H "Content-Type: application/json" -d '{"id" : substiruirPeloID, "nome":"Matheus Souza", "idade" : 24 }' "http://localhost:8080/cliente"
- **Buscar cliente:** 
		curl -X GET -H "Content-Type: application/json" "http://localhost:8080/cliente/substituirPeloID"
- **Listar todos os clientes:** 
		curl -X GET -H "Content-Type: application/json" "http://localhost:8080/cliente/listar"
- **Apagar cliente:** 
		curl -X DELETE -H "Content-Type: application/json" "http://localhost:8080/cliente/substiruirPeloID"

**OBS:** Substitur **"substiruirPeloID"** dos comandos pelo **id** do cliente.

É possível também verificar os dados inseridos através do banco pelo link http://localhost:8080/h2. O usuário padrão é "uol" e a senha "123", mas podem ser modificados no arquivo src/main/resources/application.properties.
### Quais ferramentas foram usadas (e porque essas foram as escolhidas)
- Eclipse IDE Java EE 4.11.0 (https://www.eclipse.org/downloads)
		Porque: A ferramenta foi utilizada pela experiência com a plataforma para agilizar o desenvolvimento.
- Maven 3.6.1 (https://maven.apache.org/download.cgi)
		Porque: O Maven foi utilizado por ser uma ferramenta amplamente utilziada no mercado, como alternativa, poderia ter sido utilizado o gradle.
- Redis x64 - 3.2.1 (https://github.com/microsoftarchive/redis/releases/tag/win-3.2.100)
		Porque: O redis foi utilizado para agilizar consultas com cacheamento, a escolha se deu por uma pesquisa rápida por opções para essa finalidade, optando assim por essa ferramenta por conta de exemplos de utilização do redis com o spring. 
- H2 Database (utilizado no projeto via maven)
		Porque: A utilização desse banco foi feita exclusivamente pela facilidade para realizar os testes posteriormente, não necessitando instalar nada no ambiente.
- Spring Boot 2.1.5.RELEASE (utilizado no projeto via maven)
		Porque: Requisito do projeto e framework amplamente utilizada no mercado.
- Git Bash (https://git-scm.com)
		Porque: Terminal Linux do git para Windows, foi utlizado para facilitar a execução dos comandos curl sem instalações adicionais e também para os commits do código-fonte.
		
### Qualquer infraestrutura adicional necessária para executar, testar, empacotar e entregar seu projeto
- **Redis:** É necessário baixar e instalar o redis, a porta utilizada no projeto foi a padrão. 

### Como executar, testar, empacotar e entregar o seu projeto
1. Baixar e instalar o Java >= 1.8
2. Baixar e instalar o Maven.
3. Baixar e instalar o Redis.
4. Iniciar o Redis, navegar através do Prompt até a pasta de instalação do Redis e exceutar o redis-server.exe.
5. Clonar o repositório: 
		git clone https://github.com/matheusesoft/springclientrest.git
6. Empacotar projeto e executar. 
		mvn clean install
- É possível executar o projeto após o comando anterior navengando até a pastar target do projeto e executar o comando:
		java -jar clientrest-0.0.1.jar
- ou Executar o projeto sem necessidade de gerar o arquivo jar com o comando mvn clean install:
		mvn spring-boot:run
7. Utilizar serviço conforme seção **Como usar os serviços**.
### Instruções para como montar o ambiente de produção onde seus serviços devem ser executados
1. JDK 8 deve estar instalado na máquina que o serviço irá rodar.
2. Redis deve estar rodando (redis-server.exe).
3. Modificar arquivo src/main/resources/application.properties caso necessário mudar o banco de dados, porta ou ip local.
4. Executar aplicação conforme na seção **Como executar, testar, empacotar e entregar o projeto**.
