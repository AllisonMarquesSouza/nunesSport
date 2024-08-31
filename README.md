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


## Como Executar a API
## Pré-requisitos

**Java 22: Certifique-se de ter o JDK instalado.**
**Docker: Necessário para rodar o banco de dados MySQL com Docker Compose.**
**Docker Compose: Necessário para orquestrar o container do banco de dados.**

**Passos para Executar**
1. **Clone o Repositório**:
git clone https://github.com/AllisonMarquesSouza/nunesSport.git

**2.Va até o diretórito do projeto e abra em uma Idea de preferência**
cd <DIRETORIO_DO_PROJETO>

**3.Execute o docker compose no terminal dentro do diretorio do projeto, irá carregar a imagem do banco de dados**
OBS :Você pode mudar o user, password, nome de rede ou qualquer coisa . Só lembre de modificar no properties do projeto as mudanças.
docker compose up -d 

**4.Execute a aplicação em sua Idea e vá até  http://localhost:8080/swagger-ui/index.html#/ , lá estarão todos os endpoints disponíveis para uso!!**




