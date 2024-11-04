# Nunes Sports API

This API allows the creation, listing, filters, updates, and deletion of products of the company fictitious Nunes Sports. 

## Technologies used

- **Java**: Language of Programming.
- **Spring Boot**: Framework to build Applications Java.
- **MySQL**: Data Base relational.
- **Flyway**: Manegement of migrations of database tables.
- **Lombok**: The library will reduce the code in some parts.
- **OpenAPI (Swagger)**: To document the API.

## Features API

1. **Create product**: ADD a new product in the data database.
2. **List all products**: Return all products registered.
3. **Filter products**: Filter products by name or description agreed with params.
4. **Find by code (UUID)**: Return details and specifics of the product using the unique code.
5. **Update product**: Update a product's information that ever exists.
6. **Delete product**: Delete one product of database.

## Endpoints API

| Method | Endpoint               | Description                                          |
|--------|------------------------|------------------------------------------------      |
| POST   | `/api/product/create`  | Create a new product                                 |
| GET    | `/api/product/listAll` | List all products                                    |
| GET    | `/api/products/filter` | Filter products by name or description               |
| GET    | `/api/product/{id}`    | Find one product by code (UUID)                      |
| PUT    | `/api/product/update`  | Update the information of a product that ever exist  |
| DELETE | `/api/products/delete` | Delete product                                       |


## How to Run the API
## Requirements

#### Java 22 Instaled.
#### Docker: Required to run MySQL database with Docker Compose.
#### Docker Compose: Required to orchestrate the database container.

## Steps to run
#### 1. Clone the repository**:
```sh
git clone https://github.com/AllisonMarquesSouza/nunesSport.git
```

#### 2. Go to the directory project and open the Idea of your preference:
```sh
cd <DIRETORIO_DO_PROJETO>
```

#### 3. Run the docker compose in the terminal inside the directory of the project, and wait to load the image of a database:
OBS: You can change the user, password, network, or anything. Remember if you change something, then uptade in the properties of the project.
```sh
docker compose up -d
```

#### 4. Run the application in Idea and go to url:
```sh
http://localhost:8080/swagger-ui/index.html#/ 
```
#### From this, all endpoints are available there.




