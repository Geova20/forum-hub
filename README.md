
## Descrição

ForumHub é uma API desenvolvida em Spring Boot que permite a gestão de fóruns online. Ela oferece endpoints para criação de tópicos, postagem de comentários, autenticação de usuários com Auth0 (um serviço de gerenciamento de identidade e acesso), entre outras funcionalidades essenciais para um sistema de fórum.


### Funcionalidades Principais

- **Autenticação**:
    - `POST /login`: Autentica o usuário e retorna um token JWT.

- **Tópicos**:
    - `POST /topicos`: Cria um novo tópico.
    - `DELETE /topicos/{id}`: Deleta um tópico pelo ID.
    - `PUT /topicos/{id}`: Atualiza um tópico existente.
    - `GET /topicos`: Retorna todos os tópicos paginados e ordenados.
    - `GET /topicos/{id}`: Retorna um tópico específico pelo ID.

- **Comentários**:
    - CRUD para gestão de comentários associados aos tópicos.

- **Segurança**:
    - Implementação de segurança com Spring Security e JWT para proteção dos endpoints.
### Tecnologias Usadas

- Java 17
- Spring Boot
- Spring Security
- Auth0
- Maven
- MySQL
- Lombok
- Flyway (migrações de banco de dados)
- MySQL Workbench (recomendado para gerenciamento do banco de dados)
## Configuração
Para executar o projeto localmente, siga os passos abaixo:

**Clonar o repositório:**

```bash
git clone https://github.com/sirkaue/forum-hub.git
```

**Configurar o banco de dados:**
- Crie um banco de dados MySQL localmente.
- Configure as credenciais do banco no arquivo `application.properties`.

**Configurar Auth0:**
- Configure suas credenciais do Auth0 no arquivo `application.properties` ou em variáveis de ambiente.

**Executar o projeto:**

```bash
mvn spring-boot
```

## Endpoints
- **POST /login**: Autentica o usuário e retorna um token JWT.
- **POST /topicos**: Cria um novo tópico.
- **DELETE /topicos/{id}**: Deleta um tópico pelo ID.
- **PUT /topicos/{id}**: Atualiza um tópico existente.
- **GET /topicos**: Retorna todos os tópicos paginados e ordenados.
- **GET /topicos/{id}**: Retorna um tópico específico pelo ID.
