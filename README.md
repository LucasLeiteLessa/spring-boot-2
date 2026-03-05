# 📚 Sistema de Cadastro de Estudantes - API REST

## 📋 Sobre o Projeto

**Nome do Projeto:** Sistema de Cadastro de Estudantes  
**Descrição Breve:** API REST simples desenvolvida com Spring Boot para consultar informações sobre cursos e estudantes através de endpoints HTTP. O sistema retorna dados em formato JSON e utiliza dados inicializados automaticamente na aplicação.

**Desenvolvido por:** Lucas Lessa  
**Matrícula:** 20246881

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **H2 Database** (banco em memória)
- **Maven**
- **Lombok**

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 21 instalado
- Maven instalado (ou use o mvnw fornecido)

### Passos para Execução

1. **Abrir o prompt de comando (cmd.exe)**

2. **Navegar até a pasta do projeto**
   ```cmd
   cd "D:\Biopark\3 PERIODO\saas\aula 02\sistema_estudantes\spring-boot-2"
   ```

3. **Compilar o projeto (opcional)**
   ```cmd
   mvnw clean package -DskipTests
   ```

4. **Executar a aplicação**
   ```cmd
   mvnw spring-boot:run
   ```

5. **Verificar se a aplicação está rodando**
   - Você verá a mensagem: `Tomcat started on port(s): 8080 (http)`
   - A aplicação estará disponível em: **http://localhost:8080**

---

## 📡 Endpoints Disponíveis

### ✅ Endpoint 1: Informações do Sistema
- **Rota:** `/api/sistema/info`
- **Método:** `GET`
- **Descrição:** Retorna informações sobre o sistema
- **Retorno:** JSON com nome, versão, data/hora e status

**URL para testar:**
```
http://localhost:8080/api/sistema/info
```

**Exemplo de resposta:**
```json
{
    "nome": "Sistema de Cadastro de Estudantes",
    "versao": "1.0.0",
    "dataHora": "2026-03-05T19:53:41.123-03:00",
    "status": "operacional"
}
```

---

### ✅ Endpoint 2: Listar Cursos Disponíveis
- **Rota:** `/api/cursos`
- **Método:** `GET`
- **Descrição:** Lista todos os 5 cursos disponíveis
- **Retorno:** Array JSON com nomes dos cursos

**URL para testar:**
```
http://localhost:8080/api/cursos
```

**Exemplo de resposta:**
```json
[
    "Engenharia de Software",
    "Ciência da Computação",
    "Sistemas de Informação",
    "Análise e Desenvolvimento de Sistemas",
    "Engenharia de Computação"
]
```

---

### ✅ Endpoint 3: Buscar Curso por ID
- **Rota:** `/api/cursos/{id}`
- **Método:** `GET`
- **Descrição:** Busca um curso específico pelo ID (1 a 5)
- **Parâmetro:** `{id}` = número de 1 a 5

**URLs para testar:**
```
http://localhost:8080/api/cursos/1
http://localhost:8080/api/cursos/2
http://localhost:8080/api/cursos/3
http://localhost:8080/api/cursos/4
http://localhost:8080/api/cursos/5
```

**Exemplo de resposta para /api/cursos/1:**
```
"Engenharia de Software"
```

**Cursos cadastrados:**
- ID 1 → Engenharia de Software
- ID 2 → Ciência da Computação
- ID 3 → Sistemas de Informação
- ID 4 → Análise e Desenvolvimento de Sistemas
- ID 5 → Engenharia de Computação

---

### ✅ Endpoint 4: Informações de Estudante por Matrícula
- **Rota:** `/api/estudantes/{matricula}`
- **Método:** `GET`
- **Descrição:** Retorna informações completas de um estudante
- **Parâmetro:** `{matricula}` = matrícula do estudante (string)
- **Retorno:** JSON com matrícula, nome, curso e semestre

**URLs para testar:**
```
http://localhost:8080/api/estudantes/20240001
http://localhost:8080/api/estudantes/20240002
http://localhost:8080/api/estudantes/20240003
```

**Estudantes cadastrados:**

**GET /api/estudantes/20240001** - João Silva
```json
{
    "matricula": "20240001",
    "nome": "João Silva",
    "curso": "Engenharia de Software",
    "semestre": 3
}
```

**GET /api/estudantes/20240002** - Maria Santos
```json
{
    "matricula": "20240002",
    "nome": "Maria Santos",
    "curso": "Ciência da Computação",
    "semestre": 5
}
```

**GET /api/estudantes/20240003** - Pedro Oliveira
```json
{
    "matricula": "20240003",
    "nome": "Pedro Oliveira",
    "curso": "Sistemas de Informação",
    "semestre": 2
}
```

---

### 🎁 Endpoint 5: Endpoint Criativo - Listar Estudantes por Curso
- **Rota:** `/api/estudantes`
- **Método:** `GET`
- **Descrição:** Lista todos os estudantes (ENDPOINT EXTRA)
- **Retorno:** Array JSON com todos os estudantes e suas informações

**URL para testar:**
```
http://localhost:8080/api/estudantes
```

**Exemplo de resposta:**
```json
[
    {
        "id": 1,
        "nome": "João Silva",
        "email": "joao.silva@email.com",
        "matricula": "20240001",
        "semestre": 3,
        "curso": {
            "id": 1,
            "nome": "Engenharia de Software"
        }
    },
    {
        "id": 2,
        "nome": "Maria Santos",
        "email": "maria.santos@email.com",
        "matricula": "20240002",
        "semestre": 5,
        "curso": {
            "id": 2,
            "nome": "Ciência da Computação"
        }
    },
    {
        "id": 3,
        "nome": "Pedro Oliveira",
        "email": "pedro.oliveira@email.com",
        "matricula": "20240003",
        "semestre": 2,
        "curso": {
            "id": 3,
            "nome": "Sistemas de Informação"
        }
    }
]
```

---

## 📝 Resumo de Todos os Endpoints

| Endpoint | Método | Descrição | Retorno |
|----------|--------|-----------|---------|
| `/api/sistema/info` | GET | Informações do sistema | JSON com nome, versão, data/hora, status |
| `/api/cursos` | GET | Lista todos os cursos | Array JSON de 5 cursos |
| `/api/cursos/{id}` | GET | Busca curso por ID | Nome do curso (texto) |
| `/api/estudantes/{matricula}` | GET | Busca estudante por matrícula | JSON com matrícula, nome, curso, semestre |
| `/api/estudantes` | GET | Lista todos os estudantes | Array JSON de estudantes |

---

## ✅ Checklist de Requisitos Atendidos

- ✅ **Projeto Spring Boot** criado com sucesso
- ✅ **Estrutura de pacotes** adequada (controller, service, repository, model, config)
- ✅ **Convenções de nomenclatura Java** seguidas
- ✅ **Endpoint 1:** `/api/sistema/info` - Retorna nome, versão, data/hora e status
- ✅ **Endpoint 2:** `/api/cursos` - Lista 5 cursos disponíveis
- ✅ **Endpoint 3:** `/api/cursos/{id}` - Busca curso por ID (1-5)
- ✅ **Endpoint 4:** `/api/estudantes/{matricula}` - Busca estudante por matrícula (3+ estudantes)
- ✅ **Endpoint Criativo:** `/api/estudantes` - Lista todos os estudantes
- ✅ **Dados inicializados** - Carregados automaticamente na inicialização
- ✅ **Retorno em JSON** para todos os endpoints
- ✅ **README.md completo** com documentação
- ✅ **Exemplos de URLs** para testar cada endpoint
- ✅ **Nome e matrícula** do desenvolvedor inclusos

---

## 🧪 Como Testar os Endpoints

### Opção 1: Navegador Web
Copie e cole qualquer uma destas URLs na barra de endereço do seu navegador:
- http://localhost:8080/api/sistema/info
- http://localhost:8080/api/cursos
- http://localhost:8080/api/cursos/1
- http://localhost:8080/api/estudantes/20240001
- http://localhost:8080/api/estudantes

### Opção 2: Postman (Recomendado)
1. Abra o Postman
2. Crie uma nova requisição GET
3. Cole uma das URLs acima
4. Clique em "Send"
5. Veja a resposta em JSON

### Opção 3: cURL (Terminal)
```cmd
curl http://localhost:8080/api/sistema/info
curl http://localhost:8080/api/cursos
curl http://localhost:8080/api/cursos/1
curl http://localhost:8080/api/estudantes/20240001
curl http://localhost:8080/api/estudantes
```

---

## 📌 Informações Importantes

- **Porta padrão:** 8080
- **Banco de dados:** H2 em memória (não precisa de configuração externa)
- **Dados:** Carregados automaticamente na inicialização via `DataLoader`
- **Formato:** Todos os endpoints retornam JSON
- **Autenticação:** Não requerida

---

## 🔧 Estrutura do Projeto

```
spring-boot-2/
├── src/main/java/org/example/atividade1/
│   ├── Atividade1Application.java      (Classe principal)
│   ├── config/
│   │   └── DataLoader.java             (Carrega dados iniciais)
│   ├── controller/
│   │   ├── InfoController.java         (Endpoint: /api/sistema/info)
│   │   ├── CursoController.java        (Endpoints: /api/cursos)
│   │   └── AlunoController.java        (Endpoints: /api/estudantes)
│   ├── model/
│   │   ├── Aluno.java                  (Entidade de estudante)
│   │   └── Curso.java                  (Entidade de curso)
│   ├── repository/
│   │   ├── AlunoRepository.java        (Acesso a dados de alunos)
│   │   └── CursoRepository.java        (Acesso a dados de cursos)
│   └── service/
│       ├── AlunoService.java           (Lógica de alunos)
│       └── CursoService.java           (Lógica de cursos)
├── src/main/resources/
│   └── application.properties          (Configurações)
├── pom.xml                             (Dependências Maven)
└── README.md                           (Este arquivo)
```

---

## 📞 Suporte

Em caso de dúvidas ou problemas:
1. Certifique-se de que Java 21 está instalado: `java -version`
2. Verifique se Maven está instalado: `mvn -version`
3. Certifique-se de que a porta 8080 não está em uso
4. Reinicie a aplicação se necessário

---

**Desenvolvido por:** Lucas Lessa (20246881)  
**Data:** 2026-03-05
