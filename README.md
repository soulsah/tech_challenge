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

### Exemplo JSON Novo Pedido:
```
{
  "pedido":{
    "clienteId": 1,
    "status": "RECEBIDO"
  },
  "itensPedido": [
    {
      "produto": 1,
      "quantidade": 2
    },
    {
      "produto": 2,
      "quantidade": 3
    }
  ]
}
```
