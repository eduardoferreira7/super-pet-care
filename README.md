# Documentação da API - Super Pet Care

Esta documentação descreve uma API RESTful para gerenciar os dados dos serviços prestados, categorizados por raças de animais. As operações CRUD (Criar, Ler, Atualizar, Deletar) podem ser realizadas para manter esses dados. Todas as solicitações e exemplos abaixo foram testados na ferramenta Postman.

**Link do Repositório:**
[Super Pet Care GitHub Repository](https://github.com/eduardoferreira7/super-pet-care)

## Operações CRUD

### 1. Criar (POST)
Cria um novo registro de serviço na tabela, contendo informações sobre raça, descrição do serviço, URL da imagem e valor do serviço.

**Endpoint:**
`POST http://localhost:8080/pets`

**Exemplo de Corpo da Solicitação:**
```json
{
   "breedName": "Golden Retriever",
   "serviceDescription": "tosa",
   "imageUrl": "url 4",
   "serviceValue": 150.0
}
```

**Exemplo de Resposta da Solicitação:**
```json
{
 "id": "60fcf64e-fd56-4dec-92ed-5275ee0eeed0",
 "breedName": "Golden Retriever",
 "serviceDescription": "tosa",
 "imageUrl": "url 4",
 "serviceValue": 150.0
}
```

### 2. Pesquisar Todos (GET)
Retorna uma lista de todos os serviços de pets armazenados no banco de dados.

**Endpoint:**
`GET http://localhost:8080/pets/`

**Exemplo de Resposta:**
```json
[
    {
        "id": "84507fa6-a55d-4c5f-b6a5-f9b50b4887db",
        "breedName": "Golden Retriever",
        "serviceDescription": "banho e tosa",
        "imageUrl": "url 4",
        "serviceValue": 100.0
    },
    {
        "id": "60fcf64e-fd56-4dec-92ed-5275ee0eeed0",
        "breedName": "Golden Retriever",
        "serviceDescription": "tosa",
        "imageUrl": "url 4",
        "serviceValue": 150.0
    }
]
```

### 3. Pesquisar por ID (GET)
Retorna detalhes de um serviço específico com base no ID fornecido.

**Endpoint:**
`GET http://localhost:8080/pets/84507fa6-a55d-4c5f-b6a5-f9b50b4887db`

**Exemplo de Resposta:**
```json
{
    "id": "84507fa6-a55d-4c5f-b6a5-f9b50b4887db",
    "breedName": "Golden Retriever",
    "serviceDescription": "banho e tosa",
    "imageUrl": "url 4",
    "serviceValue": 100.0
}
```

### 4. Pesquisar pela Descrição do Serviço (GET)
Retorna uma lista de serviços com base na descrição fornecida.

**Endpoint:**
`GET http://localhost:8080/service/tosa`

**Exemplo de Resposta:**
```json
[
   {
     "id": "60fcf64e-fd56-4dec-92ed-5275ee0eeed0",
     "breedName": "Golden Retriever",
     "serviceDescription": "tosa",
     "imageUrl": "url 4",
     "serviceValue": 150.0
   },
   {
     "id": "56e6cf88-b477-42df-8d59-2e23b7eeca6d",
     "breedName": "Pug",
     "serviceDescription": "tosa",
     "imageUrl": "url 1",
     "serviceValue": 40.0
   }
]
```

### 5. Pesquisar pela Raça do Cachorro (GET)
Retorna serviços associados a uma raça de cachorro específica.

**Endpoint:**
`GET http://localhost:8080/breed/pug`

**Exemplo de Resposta:**
```json
[
   {
     "id": "56e6cf88-b477-42df-8d59-2e23b7eeca6d",
     "breedName": "Pug",
     "serviceDescription": "tosa",
     "imageUrl": "url 1",
     "serviceValue": 40.0
   }
]
```

### 6. Atualizar (PUT)
Atualiza um serviço pelo ID selecionado.

**Endpoint:**
`PUT http://localhost:8080/pets/84507fa6-a55d-4c5f-b6a5-f9b50b4887db`

**Exemplo de Corpo da Solicitação:**
```json
{
    "breedName": "Golden Retriever",
    "serviceDescription": "banho e tosa",
    "imageUrl": "url 4",
    "serviceValue": 110.0
}
```

**Exemplo de Resposta da Solicitação:**
```json
{
    "id": "84507fa6-a55d-4c5f-b6a5-f9b50b4887db",
    "breedName": "Golden Retriever",
    "serviceDescription": "banho e tosa",
    "imageUrl": "url 4",
    "serviceValue": 110.0
}
```

### 7. Deletar (DELETE)
Exclui um serviço pelo ID.

**Endpoint:**
`DELETE http://localhost:8080/pets/84507fa6-a55d-4c5f-b6a5-f9b50b4887db`

**Exemplo de Resposta da Solicitação:**
    `204 No Content`: O serviço foi excluído com sucesso.

## Códigos de Resposta

- `200 OK`: A solicitação foi bem-sucedida.
- `201 Created`: O serviço foi criado com sucesso.
- `204 No Content`: O serviço foi excluído com sucesso.
- `400 Bad Request`: A solicitação possui dados inválidos ou ausentes.
- `401 Unauthorized`: Falha na autenticação ou token de autenticação ausente.
- `404 Not Found`: A raça de cachorro, serviço ou ID não foi encontrado.
- `500 Internal Server Error`: Ocorreu um erro interno no servidor.
