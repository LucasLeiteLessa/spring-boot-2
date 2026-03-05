# Sistema de Estudantes - API REST

## Projeto
**Nome do Projeto:** Sistema de Gestão de Estudantes  
**Descrição Breve:** API REST desenvolvida com Spring Boot para gerenciar alunos e cursos. A aplicação utiliza arquitetura em camadas (Controller → Service → Repository) e retorna apenas JSON em todos os endpoints.

**Desenvolvido por:** Lucas Lessa  
**Matrícula:** 20246881

---

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **H2 Database** (banco em memória)
- **Lombok** (redução de boilerplate)
- **Maven**

---

## Como Executar o Projeto

### Pré-requisitos
- Java 21 instalado
- Maven instalado
- Git (opcional)

### Passos para Execução

1. **Clonar ou baixar o repositório**
   ```bash
   cd sistema_estudantes/spring-boot-2
   ```

2. **Compilar o projeto**
   ```bash
   mvn clean package -DskipTests
   ```

3. **Executar a aplicação**
   ```bash
   mvn spring-boot:run
   ```

4. **Verificar se a aplicação está rodando**
   - A aplicação estará disponível em: **http://localhost:8080/api**
   - Console H2: **http://localhost:8080/api/h2-console**

---

## Lista de Todos os Endpoints Disponíveis

### 1. Alunos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/alunos` | Listar todos os alunos |
| GET | `/alunos/{id}` | Buscar aluno por ID |
| POST | `/alunos` | Criar novo aluno |
| PUT | `/alunos/{id}` | Atualizar aluno |
| DELETE | `/alunos/{id}` | Excluir aluno |
| GET | `/alunos/saudacao/{id}` | Obter saudação personalizada |

### 2. Cursos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/cursos` | Listar todos os cursos |
| GET | `/cursos/{id}` | Buscar curso por ID |
| POST | `/cursos` | Criar novo curso |
| PUT | `/cursos/{id}` | Atualizar curso |
| DELETE | `/cursos/{id}` | Excluir curso |

### 3. Informações da Aplicação

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/info` | Informações gerais da aplicação |
| GET | `/info/saude` | Health check da aplicação |

---

## Exemplos de Uso - URLs para Testar Cada Endpoint

### Base URL
```
http://localhost:8080/api
```

### 1. Listar todos os alunos
```
GET http://localhost:8080/api/alunos
```
**Resposta esperada (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "Eduardo Longen Correa",
    "email": "eduardo.longen@email.com",
    "curso": "Engenharia de Software",
    "matricula": "20222720"
  },
  {
    "id": 2,
    "nome": "Maria Bordignon",
    "email": "maria.bordignon@email.com",
    "curso": "Ciência da Computação",
    "matricula": "2025002"
  }
]
```

### 2. Buscar aluno por ID
```
GET http://localhost:8080/api/alunos/1
```
**Resposta esperada (200 OK):**
```json
{
  "id": 1,
  "nome": "Eduardo Longen Correa",
  "email": "eduardo.longen@email.com",
  "curso": "Engenharia de Software",
  "matricula": "20222720"
}
```

### 3. Criar novo aluno
```
POST http://localhost:8080/api/alunos
Content-Type: application/json

{
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "curso": "Ciência da Computação",
  "matricula": "2025004"
}
```
**Resposta esperada (201 Created):**
```json
{
  "id": 4,
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "curso": "Ciência da Computação",
  "matricula": "2025004"
}
```

### 4. Atualizar aluno
```
PUT http://localhost:8080/api/alunos/1
Content-Type: application/json

{
  "nome": "Eduardo Longen Correa - Atualizado",
  "email": "eduardo.novo@email.com",
  "curso": "Engenharia de Software",
  "matricula": "20222720"
}
```
**Resposta esperada (200 OK):**
```json
{
  "id": 1,
  "nome": "Eduardo Longen Correa - Atualizado",
  "email": "eduardo.novo@email.com",
  "curso": "Engenharia de Software",
  "matricula": "20222720"
}
```

### 5. Excluir aluno
```
DELETE http://localhost:8080/api/alunos/4
```
**Resposta esperada (204 No Content)** - sem corpo na resposta

### 6. Saudação personalizada
```
GET http://localhost:8080/api/alunos/saudacao/1
```
**Resposta esperada (200 OK):**
```json
{
  "saudacao": "Olá, Eduardo Longen Correa! Bem-vindo(a) ao Spring Boot!"
}
```

---

### 7. Listar todos os cursos
```
GET http://localhost:8080/api/cursos
```
**Resposta esperada (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "Engenharia de Software"
  },
  {
    "id": 2,
    "nome": "Ciência da Computação"
  }
]
```

### 8. Buscar curso por ID
```
GET http://localhost:8080/api/cursos/1
```
**Resposta esperada (200 OK):**
```json
{
  "id": 1,
  "nome": "Engenharia de Software"
}
```

### 9. Criar novo curso
```
POST http://localhost:8080/api/cursos
Content-Type: application/json

{
  "nome": "Ciência de Dados"
}
```
**Resposta esperada (201 Created):**
```json
{
  "id": 4,
  "nome": "Ciência de Dados"
}
```

### 10. Atualizar curso
```
PUT http://localhost:8080/api/cursos/1
Content-Type: application/json

{
  "nome": "Engenharia de Software Avançada"
}
```
**Resposta esperada (200 OK):**
```json
{
  "id": 1,
  "nome": "Engenharia de Software Avançada"
}
```

### 11. Excluir curso
```
DELETE http://localhost:8080/api/cursos/2
```
**Resposta esperada (204 No Content)** - sem corpo na resposta

---

### 12. Informações gerais da aplicação
```
GET http://localhost:8080/api/info
```
**Resposta esperada (200 OK):**
```json
{
  "aplicacao": "Sistema de Estudantes",
  "versao": "1.0.0",
  "descricao": "API REST para gerenciar alunos e cursos"
}
```

### 13. Health check da aplicação
```
GET http://localhost:8080/api/info/saude
```
**Resposta esperada (200 OK):**
```json
{
  "status": "UP",
  "mensagem": "Aplicação está funcionando normalmente"
}
```

---

## Estrutura do Projeto

```
src/main/java/org/example/atividade1/
├── Atividade1Application.java          # Classe principal da aplicação
├── config/
│   └── DataLoader.java                 # Carrega dados iniciais (3 alunos)
├── controller/
│   ├── AlunoController.java            # REST endpoints de alunos
│   ├── CursoController.java            # REST endpoints de cursos
│   └── InfoController.java             # REST endpoints de informação
├── model/
│   ├── Aluno.java                      # Entidade Aluno com JPA
│   └── Curso.java                      # Entidade Curso com JPA
├── repository/
│   ├── AlunoRepository.java            # JPA Repository para Aluno
│   └── CursoRepository.java            # JPA Repository para Curso
└── service/
    ├── AlunoService.java               # Lógica de negócio - Aluno
    └── CursoService.java               # Lógica de negócio - Curso

src/main/resources/
└── application.properties               # Configurações da aplicação
```

---

## Dados Iniciais

A aplicação carrega automaticamente 3 alunos de exemplo ao iniciar:
1. **Eduardo Longen Correa** - Engenharia de Software - Matrícula: 20222720
2. **Maria Bordignon** - Ciência da Computação - Matrícula: 2025002
3. **Daemon Targaryen** - Sistemas de Informação - Matrícula: 2025003

---

## Banco de Dados

A aplicação utiliza **H2 Database** (banco de dados em memória).

### Acessar Console H2
- **URL:** http://localhost:8080/api/h2-console
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** (deixe em branco)

---

## Tratamento de Erros

A API retorna os seguintes códigos HTTP:

| Código | Descrição | Exemplo |
|--------|-----------|---------|
| **200** | OK - Requisição bem-sucedida | GET, PUT com sucesso |
| **201** | Created - Recurso criado | POST com sucesso |
| **204** | No Content - Sucesso sem resposta | DELETE com sucesso |
| **400** | Bad Request - Requisição inválida | JSON malformado |
| **404** | Not Found - Recurso não encontrado | ID inexistente |
| **500** | Internal Server Error - Erro do servidor | Exceção não tratada |

---

## Como Testar os Endpoints

### Opção 1: Usar o arquivo `requests.http`
O projeto inclui um arquivo `requests.http` que pode ser usado com extensões como REST Client do VS Code para testar todos os endpoints.

### Opção 2: Usar cURL (linha de comando)
```bash
# Listar alunos
curl http://localhost:8080/api/alunos

# Criar novo aluno
curl -X POST http://localhost:8080/api/alunos \
  -H "Content-Type: application/json" \
  -d '{"nome":"João Silva","email":"joao@email.com","curso":"Computação","matricula":"2025004"}'

# Buscar aluno específico
curl http://localhost:8080/api/alunos/1

# Atualizar aluno
curl -X PUT http://localhost:8080/api/alunos/1 \
  -H "Content-Type: application/json" \
  -d '{"nome":"Novo Nome","email":"novo@email.com","curso":"Nova Curso","matricula":"20246881"}'

# Excluir aluno
curl -X DELETE http://localhost:8080/api/alunos/1
```

### Opção 3: Usar Postman ou Insomnia
1. Importe as URLs acima nos seus clientes REST
2. Configure o Content-Type como `application/json` para POST e PUT
3. Teste cada endpoint

---

## Logging

A aplicação gera logs detalhados durante a execução:
- **INFO** - Logs gerais da aplicação
- **DEBUG** - Requisições HTTP e queries SQL
- **TRACE** - Binding de parâmetros SQL

As configurações de logging podem ser ajustadas em `application.properties`.

---

## Notas Importantes

- ✅ Todos os endpoints retornam **apenas JSON**
- ✅ Arquitetura em **3 camadas** (Controller → Service → Repository)
- ✅ Banco de dados **H2 em memória** (dados perdidos ao reiniciar)
- ✅ **Validação de erros** com tratamento de exceções
- ✅ **DataLoader** carrega dados iniciais automaticamente
- ✅ **CORS** habilitado para requisições de diferentes origens

---

## Autor
**Nome:** Lucas Lessa  
**Matrícula:** 20246881  
**Disciplina:** Arquitetura de Sistemas (SaaS)
