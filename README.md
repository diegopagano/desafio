# Desafio API REST

O projeto tem como objetivo entregar um endpoint /todos permitindo as operações CRUD.

## Tecnologias Escolhidas
Escolhi programar em Java com o framework Spring, pois é a linguagem que eu tenho maior dominio, devido a utilizarmos ela na faculdade, o mesmo vale para a escolha do banco MySQL.

## Pré-Requisitos
Para conseguirmos rodar a API precisaremos das seguintes tecnologias e ferramentas:

### Essenciais
Uma base de dados em MySQL.

Java SE 1.8. (https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).

IDE Eclipse EE(https://www.eclipse.org/).

### Para testar
-Postman (https://www.postman.com/).

## Instalação

Deve-se instalar o Eclipse para que possamos abrir o projeto.

Para começar deve-se baixar o zip com o projeto em:

https://github.com/DudaMoraes/desafioapi

Com o seu Eclipse aberto, importe a pasta do projeto(springbootapi-master) e espere ele baixar as dependencias do maven.
Dentro do Eclipse ache o arquivo src/main/resources/aplication-properties
Edite as seguintes linhas colocando os dados necessários para acesso ao banco de dados:

spring.datasource.url=jdbc:mysql://nome-do-host/nome-da-base

spring.datasource.username=usuario-da-base

spring.datasource.password=senha-da-base

Instale também o Postman para podermos realizar testes.

## API Endpoints

Todas as operações são disponibilizadas no endpoint:
http://localhost:8080/todos

As operações PUT e DELETE devem ser especificadas pelo id.
http://localhost:8080/todos/{id}

É possivel utilizar o GET com o id mas não é obrigatório.

## Testando

Dentro do eclipse selecione a classe com o main() com nome de DemoApplication.java e de um run as Java Application.

Espere até ele iniciar completamente o servidor.

Pronto, agora é possivel realizar os testes de cada operação CRUD.

### Teste

Para testar iremos utilizar a ferramenta Postman.

Dentro do postman, ao colocar o endpoint para fazer as operações, é necessario clicar em:
Body > opção raw, e aonde estiver selecionado text selecionar json.

#### Respostas
##### GET
Procura e retorna todos registro dentro da tabela dos todos.

```
200 OK
```
A requisição retornou com sucesso, mostrando todos os 4 atributos description,
completed, createdAt, updatedAt de todos os "todos" registrados no banco em formato JSON.

Ou também caso tente dar GET pelo id de um todo existente no banco.

```
404 Not Found
```
Caso tente dar um GET pelo id de um todo que não se encontra no banco.


##### POST
Publica um novo todo. 

```
201 Created
```
Caso o campo description seja diferente de null ou empty retornará 201.
```
400 Bad Request
```
Caso tente adicionar um todo com o campo de description null ou empty ele retorna erro 400.

##### PUT
Atualiza um todo a partir do seu id. 

```
200 OK
```
Caso o campo description seja diferente de null ou empty retornará 200.
O campo completed não é de preenchimento obrigatorio, por padrão, caso nao seja instanciado permacerá false, caso queria muda-lo junto da descrição é possível.
```
400 Bad Request
```
Caso tente atualizar um todo com o campo de description null ou empty ele retorna erro 400.

```
404 Not Found
```
Caso tente atualizar um todo que não se encontra no banco.

##### DELETE
Deleta um todo a partir do seu id. 

```
200 OK
```
Caso o id apresentado esteja dentro do banco ele irá apagar aquele registro.
```
404 Not Found
```
Caso tente deletar um todo que não se encontra no banco.

## Feito Com

* [Spring](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Eclipse EE](https://www.eclipse.org/) - IDE.
* [Java SE JDK 8](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) - Language.
