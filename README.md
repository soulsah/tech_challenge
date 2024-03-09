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

    
 
## Event Storming

O projeto foi elaborado com base na Arquitetura Hexagonal seguindo os conceitos de DDD, cujo Event Storming pode ser acessado [aqui](https://miro.com/app/board/uXjVN4e5Mps=/?share_link_id=181314720008)

## Configurações da solução

### Banco de Dados
Configuração de produção utilizando o PostgreSQL:
https://github.com/andzedd/tech_challenge/blob/master/src/main/resources/application.properties

Relacionamento entre as entidades:


![image](https://github.com/andzedd/tech_challenge/blob/master/images/tabelas.png)



### Container


Criamos um container para aplicação e outro para o banco de dados e uma rede no modo bridge para ter acesso ao containers via localhost:


Também adicionamos o arquivo Dockerfile que gerencia o processo de build da aplicação através do Maven e JDK, já inicializando a aplicação:


Para criação dos container, compilar e rodar a applicação é necessário apenas o comando:

docker-compose up -d



### Documentação das APIS 
Adicionamos a geração automática da documentação através da biblioteca SpringDoc OpenAPI, a documentação pode ser acessada enquanto a aplicação estiver rodando em http://localhost:8080/swagger-ui/index.html#/:

![image](https://github.com/andzedd/tech_challenge/blob/master/images/clientes.png)
![image](https://github.com/andzedd/tech_challenge/blob/master/images/pedidos.png)
![image](https://github.com/andzedd/tech_challenge/blob/master/images/produtos.png)


 
## Requests Collection

A Collection para realização das requests pode ser encontrada [postman](https://github.com/andzedd/tech_challenge/blob/master/techChallengeCollection%20-%20postman) [insominia](https://github.com/andzedd/tech_challenge/blob/master/techChallengerCollection%20-insominia)


# Estrutura do Projeto - Tech Challenge

# application

## exception
- **Descrição:** Contém exceções específicas da aplicação.

## repository
- **Descrição:** Contém componentes relacionados ao armazenamento de dados.

## service
- **Descrição:** Interface que fornece serviços.

### impl
- **Descrição:** Implementação da interface service contendo as regras de negócio.

# domain

## model
- **Descrição:** Contém as entidades de domínio.

# infrastructure

## persistence
- **Descrição:** Contém componentes relacionados ao armazenamento de dados.

## web

### controller
- **Descrição:** Camada de interface do usuário . Responsável por receber e processar as requisições da interface.

### dto
- **Descrição:** Contém objetos de transferência de dados .

### exception
- **Descrição:** Contém exceções específicas do domínio.
