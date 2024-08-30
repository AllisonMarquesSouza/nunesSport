# Nunes Sports API

Esta API permite a criação, listagem, filtragem, atualização e exclusão de produtos da empresa fictícia Nunes Sports. 

## Tecnologias Utilizadas

- **Java**: Linguagem de programação.
- **Spring Boot**: Framework para construção de aplicações Java.
- **MySQL**: Banco de dados relacional.
- **Flyway**: Gerenciamento de migrações de banco de dados.
- **Lombok**: Biblioteca para reduzir código boilerplate.
- **OpenAPI (Swagger)**: Ferramenta para documentação de APIs.

## Funcionalidades da API

1. **Criar Produto**: Adiciona um novo produto à base de dados.
2. **Listar Todos os Produtos**: Retorna todos os produtos cadastrados.
3. **Filtrar Produtos**: Filtra produtos por nome ou descrição com base nos Params.
4. **Buscar Produto por Código (UUID)**: Retorna detalhes de um produto específico usando o código único.
5. **Atualizar Produto**: Atualiza as informações de um produto existente.
6. **Deletar Produto**: Remove um produto da base de dados.

## Endpoints da API

| Método | Endpoint               | Descrição                                            |
|--------|------------------------|------------------------------------------------      |
| POST   | `/api/product/create`  | Cria um novo produto                                 |
| GET    | `/api/product/listAll` | Lista todos os produtos                              |
| GET    | `/api/products/filter` | Filtra produtos por nome ou descrição                |
| GET    | `/api/product/{id}`    | Busca um produto pelo código UUID                    |
| PUT    | `/api/product/update`  | Atualiza as informações de um produto existente      |
| DELETE | `/api/products/delete` | Deleta um produto                                    |



