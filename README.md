## Membros do Grupo
* Matheus dos Santos Souza - RM351686
* Guilherme Oliveira
* Marcos Alves
* Danilo Silva

## 1- Relatório Técnico
Tecnologias e ferramentas utilizadas

* Linguagem de programação: 

    * Java 17

* Framework:
    * Spring Boot 3.1.5

* Bibliotecas:
  * Spring Web
  * OpenAPI
  * Lombok
    
* Banco de dados:
  * PostgreSQL
* Outras ferramentas:
  * Docker
 
## Requests Collection

A Collection para realização das requests pode ser encontrada [aqui](https://github.com/andzedd/tech_challenge/blob/master/Tech_challenge_Collection.json)
 
## Event Storming

O projeto foi elaborado com base na Arquitetura Hexagonal seguindo os conceitos de DDD, cujo Event Storming pode ser acessado [aqui](https://miro.com/app/board/uXjVN4e5Mps=/?share_link_id=181314720008)

## Configurações da solução

### Banco de Dados
Configuração de produção utilizando o PostgreSQL:
https://github.com/andzedd/tech_challenge/blob/master/src/main/resources/application.properties

Relacionamento entre as entidades:


### Container


Criamos um container para aplicação e outro para o banco de dados e uma rede no modo bridge para ter acesso ao containers via localhost:


Também adicionamos o arquivo Dockerfile que gerencia o processo de build da aplicação através do Maven e JDK, já inicializando a aplicação:


Para criação dos container, compilar e rodar a applicação é necessário apenas o comando:

docker-compose up -d


# Estrutura do Projeto - Tech Challenge

## Adapters (ou Port Adapters):

### controller

- **Descrição:** Camada de interface do usuário representada pelo `ClienteController`. Responsável por receber e processar as requisições da interface do usuário.

### dto

- **Descrição:** Contém objetos de transferência de dados relacionados a clientes, como `ClienteDto`.

### exception

- **Descrição:** Contém classes relacionadas ao tratamento de exceções, como `CustomExceptionHandler`.

### repository

- **Descrição:** Contém componentes relacionados ao armazenamento de dados, como `ClienteRepositoryDB`.

## Application:

### clienteService

- **Descrição:** Interface que fornece serviços relacionados a clientes.

### impl

- **Descrição:** Contém a implementação concreta dos serviços, como `ClienteServiceImpl`. Esta camada utiliza a camada de domínio para realizar operações de negócios e chama o `ClienteRepository` para acessar dados.

## Domain:

### exception

- **Descrição:** Contém exceções específicas do domínio, como `CadastroClienteException` e `BadRequestException`.

### model

- **Descrição:** Contém as entidades de domínio, como `Cliente`.

### repository

- **Descrição:** Contém interfaces relacionadas ao acesso a dados, como `ClienteRepository`. Responsável por fazer a ponte com a camada de adapters e chamar o `ClienteRepositoryDB`.

### Postman
- Disponibilizamos um arquivo JSON com todas as requisições Postman para testar a API, disponível no seguinte link:
