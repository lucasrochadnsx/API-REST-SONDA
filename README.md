# ✈️ Aeronaves – Documentação Técnica do Sistema

Documentação técnica do sistema **Aeronaves**, destinada a desenvolvedores que desejam **clonar, entender, executar e evoluir** a aplicação.  
O sistema é composto por **Backend (Spring Boot)** e **Frontend (React)**, comunicando-se via API REST.

---

## 📦 Visão Geral do Sistema

O sistema Aeronaves permite o gerenciamento de aeronaves comerciais e executivas, oferecendo:

- Cadastro, atualização e remoção de aeronaves
- Consultas e listagens
- Agrupamentos por fabricante e por década
- Indicadores de status de venda

A solução foi projetada com foco em **arquitetura limpa**, **baixo acoplamento** e **clareza técnica**.

---

## 🧱 Arquitetura (Visão Técnica)

- Arquitetura em camadas inspirada em **Clean Architecture**
- Separação clara entre:
  - API (Controllers)
  - Casos de uso (UseCases / Services)
  - Domínio (Entidades e contratos)
  - Infraestrutura (Persistência, Flyway, Configurações)

Fluxo principal:

```
HTTP → Controller → UseCase/Service → Domain → Repository → Database
```

---

## 🛠️ Stack Tecnológica

### Backend
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Flyway
- MySQL 8
- Maven

### Frontend
- React
- TypeScript
- Vite
- Axios
- Node.js 18+

---

## 📁 Estrutura do Repositório

```
/
├── aeronaveV2/
│   └── aeronaveV2/        # Backend (Spring Boot)
│       ├── src/main/java
│       └── src/main/resources
│
├── aeronaves-frontend/    # Frontend (React + Vite)
│   ├── src/
│   └── package.json
│
└── README.md
```

---

## 🚀 Como Executar Localmente

### Pré-requisitos
- Java 17+
- Maven
- MySQL 8
- Node.js 18+
- npm

---

## 🗄️ Banco de Dados

O sistema utiliza **MySQL** com versionamento de schema via **Flyway**.

Schema padrão:
```
aeronave_db
```

As migrations ficam em:
```
backend/src/main/resources/db/migration
```

Exemplo:
- `V1__create_aeronaves.sql`
- `V2__seed_aeronaves.sql`

---

## ▶️ Executando o Backend

```bash
cd aeronaveV2/aeronaveV2
mvn clean spring-boot:run
```

Backend disponível em:
```
http://localhost:8080
```

### Endpoints principais

Base path: `/aeronaves`

| Método | Endpoint |
|------|---------|
| GET | /aeronaves |
| GET | /aeronaves/{id} |
| GET | /aeronaves/por-decada |
| GET | /aeronaves/por-decada/resumo |
| GET | /aeronaves/por-fabricante |
| GET | /aeronaves/por-fabricante/resumo |
| POST | /aeronaves |
| PUT | /aeronaves/{id} |
| PATCH | /aeronaves/{id} |
| DELETE | /aeronaves/{id} |

---

## ▶️ Executando o Frontend

```bash
cd aeronaves-frontend
npm install
npm run dev
```

Frontend disponível em:
```
http://localhost:5173
```

---

## 🔐 Integração Frontend ↔ Backend

- Backend: `http://localhost:8080`
- Frontend: `http://localhost:5173`
- CORS liberado para ambiente local

A configuração da API pode ser ajustada em:
```
aeronaves-frontend/src/api/api.ts
```

---

## 🧪 Testes

### Backend
```bash
mvn test
```

### Frontend
```bash
npm run lint
npm run build
```

---

## 🧯 Troubleshooting

### Flyway não cria tabelas
- Verifique se os arquivos SQL estão em `src/main/resources/db/migration`
- Confirme se eles aparecem em `target/classes/db/migration` após o build
- Verifique a tabela `flyway_schema_history`

### Erro de conexão com MySQL
- Confirme usuário, senha, porta (3306) e schema
- Teste a conexão externamente (Workbench / CLI)

---

## 📈 Possíveis Evoluções

- Autenticação e autorização (JWT / OAuth2)
- Paginação avançada
- Swagger / OpenAPI
- Observabilidade (Actuator, métricas)
- Cache distribuído

---

## 📄 Licença

Projeto de uso educacional/técnico, desenvolvido como **teste técnico**.

---

## 👤 Autor

Desenvolvido por **Lucas Rocha**  
Projeto com foco em arquitetura, qualidade de código e boas práticas.
