<h1 align="center">dsList</h1>

API para visualização e gerenciamento de lista de jogos que faz parte [desse intensivão](https://github.com/devsuperior/dslist-backend) para pessoas desenvolvedoras backend

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Validation](https://spring.io/guides/gs/validating-form-input/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)
- [postgresql](https://www.postgresql.org)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/dslist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080)
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com):

- Visualizar os jogos
```
curl --location --request GET 'http://localhost:8080/games?size=5' --header 'Content-Type: application/json'
```

- Visualizar jogo específico
```
curl --location --request GET 'http://localhost:8080/games/1' --header 'Content-Type: application/json'
```

- Visualizar lista de jogos
```
curl --location --request GET 'http://localhost:8080/gameLists' --header 'Content-Type: application/json'
```

- Visualizar lista de jogos com seus jogos cadastrados
```
curl --location --request GET 'http://localhost:8080/gameLists/1/games' --header 'Content-Type: application/json'
```
- Alterar a posição dos jogos na lista
```
curl --location --request POST 'http://localhost:8080/gameLists/2/replacement' --header 'Content-Type: application/json' --data '{
    "sourceIndex": 1,
    "destinationIndex": 1
}'
```
