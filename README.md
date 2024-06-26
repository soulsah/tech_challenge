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

## Aplicacao
Funcionamento da aplicacao
![image](https://github.com/andzedd/tech_challenge/blob/master/images/aplicacao.png)


## Deploy
desenho do deploy CI/CD

![image](https://github.com/andzedd/tech_challenge/blob/master/images/deployCi.png)
 

## Configurações da solução




# Justificação da escolha do banco de dados.
Nas etapas anteriores utilizamos como base de dados o Postgres, devido ao conhecimento prévio do grupo sobre o sistema, porém, nessa fase decidimos pela alteração para a base DynamoDB da AWS, fizemos essa escolha principalmente pela sinergia que o banco possuí com outras tecnologias da AWS que estamos utilizando, como o Lambda e o EC2.

DynamoDB oferece desempenho escalável e consistente, independentemente do tamanho do conjunto de dados ou da carga de trabalho, ideal para o processamento dos pedidos no sistema, assim como ele pode gerenciar automaticamente a distribuição de dados e as requisições para otimizar o desempenho, uma vez que não precisaremos nos preocupar com provisionamento de recursos ou ajustes de capacidade, reduzimos assim a sobrecarga operacional eliminando a necessidade de ajustes manuais de configuração como no Postgres.

Outro ponto importante aqui é a questão de custos no projeto, onde será cobrada apenas pelo armazenamento e pela capacidade de leitura/gravação provisionada, que num caso de uma lanchonete é variável durante a semana e até mesmo o dia. DynamoDB também possui resiliência integrada, que replica automaticamente os dados em várias zonas de disponibilidade para garantir alta disponibilidade e durabilidade dos dados.


### Container


Criamos um container para aplicação e outro para o banco de dados e uma rede no modo bridge para ter acesso ao containers via localhost:


Também adicionamos o arquivo Dockerfile que gerencia o processo de build da aplicação através do Maven e JDK, já inicializando a aplicação:


Para criação dos container, compilar e rodar a applicação é necessário apenas o comando:

docker-compose up -d



### Documentação das APIS 
Adicionamos a geração automática da documentação através da biblioteca SpringDoc OpenAPI, a documentação pode ser acessada enquanto a aplicação estiver rodando em http://localhost:8080/swagger-ui/index.html#/:

![image](https://github.com/andzedd/tech_challenge/blob/master/images/produtos.png)
![image](https://github.com/andzedd/tech_challenge/blob/master/images/webhook.png)
![image](https://github.com/andzedd/tech_challenge/blob/master/images/tipo_produto.png)
![image](https://github.com/andzedd/tech_challenge/blob/master/images/pedidos.png)
![image](https://github.com/andzedd/tech_challenge/blob/master/images/pagamento.png)
![image](https://github.com/andzedd/tech_challenge/blob/master/images/clientes.png)
![image](https://github.com/andzedd/tech_challenge/blob/master/images/cartao.png)



 
## Requests Collection

A Collection para realização das requests pode ser encontrada [Collection](https://github.com/andzedd/tech_challenge/blob/master/techChallengerCollection%20-insominia)


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


### Desenho da Arquitetura:

![arch](https://github.com/soulsah/tech_challenge/assets/60759001/2e738732-4024-4ed8-a48b-86d9e33d5600)

## Requisitos do Negócio

### Gestão de Pedidos:

- O sistema deve permitir que os clientes façam pedidos através de uma interface de autoatendimento.
- Deve ser possível selecionar itens do menu, personalizar pedidos e adicionar itens extras conforme necessário.
- Os pedidos devem ser preparados exatamente conforme especificado pelos clientes, sem erros ou omissões.

### Eficiência Operacional:

- O sistema deve garantir uma comunicação eficiente entre os dispositivos de autoatendimento e a cozinha.

### Integração com Pagamento:

- O sistema deve integrar-se a um sistema de pagamento para facilitar o pagamento dos pedidos pelos clientes.

### Escalabilidade:

- O sistema deve ser capaz de lidar com um grande volume de pedidos simultâneos, especialmente durante períodos de pico de atividade.

### Segurança dos Dados:

- Todas as informações dos clientes, como detalhes do pedido e informações de pagamento, devem ser armazenadas e transmitidas de forma segura.
