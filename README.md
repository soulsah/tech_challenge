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


### Kubernetes

Para utilizar a estrutura de Kubernetes para a aplicação e o banco de dados, consideramos a implementação de um sistema de autoescalabilidade horizontal baseado no uso de CPU e memória. Inicialmente, a aplicação é configurada com 2 PODs, distribuídos igualmente entre a aplicação e o banco de dados, totalizando 1 POD para cada componente.

Ao monitorar o uso de CPU e memória, caso qualquer POD atinja 70% de sua capacidade máxima de CPU ou memória, um novo POD é adicionado automaticamente para garantir a disponibilidade e o desempenho contínuos do sistema. Essa estratégia de autoescalabilidade ajuda a otimizar o uso dos recursos, garantindo que a aplicação possa lidar com picos de demanda sem comprometer a performance ou a disponibilidade.

![image](https://github.com/andzedd/tech_challenge/blob/master/images/k8s.png)

Comandos necessários para subir o kubernetes local:
kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml

kubectl apply -f https://raw.githubusercontent.com/pythianarora/total-practice/master/sample-kubernetes-code/metrics-server.yaml

kubectl create -f k8s\deployment.yaml

kubectl create -f k8s\service.yaml

kubectl create -f k8s\hpa.yaml


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
