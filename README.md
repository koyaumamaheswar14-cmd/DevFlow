# DevFlow

DevFlow is a microservices-based DevOps platform built using Spring Boot. It provides a centralized API Gateway for routing requests to multiple backend services and is designed as the foundation for a scalable CI/CD platform.

## Features

- Microservices Architecture
- Spring Cloud Gateway
- API Gateway Routing
- User Service
- Repository Service
- Build Service
- Deploy Service Routing
- RESTful APIs
- Maven-based Project Structure

## Architecture

```
                        +----------------------+
                        |     API Gateway      |
                        |      Port: 8080      |
                        +----------+-----------+
                                   |
        ---------------------------------------------------------
        |                  |                 |                  |
        |                  |                 |                  |
+---------------+  +----------------+  +---------------+  +----------------+
| User Service  |  | Repo Service   |  | Build Service |  | Deploy Service |
| Port: 8082    |  | Port: 8081     |  | Port: 8083    |  | Port: 8084     |
+---------------+  +----------------+  +---------------+  +----------------+
```

## Tech Stack

- Java
- Spring Boot
- Spring Cloud Gateway
- Maven
- REST APIs

## Project Structure

```
devflow/
│
├── gateway-service/
├── user-service/
├── repo-service/
├── build-service/
├── deploy-service/
└── README.md
```

## API Gateway Routes

| Service | Endpoint | Port |
|---------|----------|------|
| User Service | `/api/users/**` | 8082 |
| Repository Service | `/api/repos/**` | 8081 |
| Build Service | `/api/builds/**` | 8083 |
| Deploy Service | `/api/deployments/**` | 8084 |

## Current Implementation

- Configured Spring Cloud Gateway for centralized request routing.
- Implemented User Service APIs.
- Implemented Repository Service APIs.
- Implemented Build Service APIs.
- Configured Deploy Service routing through the API Gateway.
- Developed REST APIs using Spring Boot.
- Designed a modular microservices architecture for scalability and maintainability.

## Planned Features

- Git Repository Integration
- Automated Build Execution (Maven/Gradle)
- Docker Containerization
- JWT Authentication & Authorization
- Build Status Tracking
- Build Logs
- Deployment Automation
- CI/CD Pipeline
- Monitoring & Notifications

## Getting Started

### Clone Repository

```bash
git clone https://github.com/<your-username>/DevFlow.git
```

### Build

```bash
mvn clean install
```

### Run Services

Start the following services individually:

- Gateway Service (8080)
- User Service (8082)
- Repository Service (8081)
- Build Service (8083)
- Deploy Service (8084)

After starting all services, access them through the API Gateway.

## API Endpoints

### User Service

| Method | Endpoint |
|--------|----------|
| GET | http://localhost:8080/api/users |
| GET | http://localhost:8080/api/users/{id} |
| POST | http://localhost:8080/api/users |
| PUT | http://localhost:8080/api/users/{id} |
| DELETE | http://localhost:8080/api/users/{id} |

### Repository Service

| Method | Endpoint |
|--------|----------|
| GET | http://localhost:8080/api/repos |
| GET | http://localhost:8080/api/repos/{id} |
| POST | http://localhost:8080/api/repos |
| PUT | http://localhost:8080/api/repos/{id} |
| DELETE | http://localhost:8080/api/repos/{id} |

### Build Service

| Method | Endpoint |
|--------|----------|
| GET | http://localhost:8080/api/builds |
| GET | http://localhost:8080/api/builds/{id} |
| POST | http://localhost:8080/api/builds |
| PUT | http://localhost:8080/api/builds/{id} |
| DELETE | http://localhost:8080/api/builds/{id} |

### Deploy Service

| Method | Endpoint |
|--------|----------|
| GET | http://localhost:8080/api/deployments |
| GET | http://localhost:8080/api/deployments/{id} |
| POST | http://localhost:8080/api/deployments |
| PUT | http://localhost:8080/api/deployments/{id} |
| DELETE | http://localhost:8080/api/deployments/{id} |
## API Testing

The REST APIs were tested using Postman.

**Postman Collection:**

* [https://your-postman-collection-link](https://koyaumamaheswar14-cmd-2520415.postman.co/workspace/Api-v2~c27e8093-3c3b-44db-b122-2214286c20ac/folder/51740919-8df2824a-6311-4956-af24-0fb04251a075?action=share&source=copy-link&creator=51740919)

**Base URL:**

```
http://localhost:8080
```

Example Endpoints:

* `GET /api/users`
* `GET /api/repos`
* `GET /api/builds`
* `GET /api/deployments`


## Future Scope

DevFlow is being developed as a cloud-native DevOps platform capable of automating repository management, build execution, deployment, authentication, and CI/CD workflows using a scalable microservices architecture.

## Author

**Uma Maheswar Koya**

GitHub: https://github.com/your-username
