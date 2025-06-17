# Auth Module

Este projeto é um microserviço de autenticação desenvolvido em **Spring Boot** e **Spring Security**. Ele disponibiliza uma API REST para cadastro e autenticação de usuários, emitindo tokens JWT que protegem os demais serviços da aplicação.

## Visão geral

- **Linguagem:** Java 17
- **Build:** Maven
- **Banco de dados:** H2 (memória)
- **Segurança:** Spring Security com tokens JWT

## Arquitetura

O código segue uma organização em camadas, separando responsabilidades de forma clara:

| Camada / Pacote                         | Responsabilidade principal                                         |
|----------------------------------------|--------------------------------------------------------------------|
| `controllers`                          | Exposição de endpoints REST e tratamento das requisições           |
| `application`                          | Casos de uso e DTOs que orquestram a lógica de negócio             |
| `domain`                               | Entidades e repositórios de abstração (DAO)                        |
| `infra`                                | Implementações concretas de persistência, segurança e filtros      |
| `services`                             | Serviços auxiliares utilizados por outras camadas                  |

```text
src/
├── main
│   ├── java
│   │   └── com/adv_investor/auth_module
│   │       ├── application
│   │       ├── controllers
│   │       ├── domain
│   │       ├── infra
│   │       └── services
│   └── resources
│       └── application.properties
└── test
    └── java/com/adv_investor/auth_module
```

## Executando localmente

1. Certifique-se de ter **Java 17** instalado.
2. Execute o comando abaixo para iniciar a aplicação:

```bash
./mvnw spring-boot:run
```

Os testes automatizados podem ser executados com:

```bash
./mvnw test
```

## Integrantes

- Enricco Rossi de Souza Carvalho Miranda - RM551717
- Gabriel Marquez Trevisan - RM99227
- Guilherme Silva dos Santos - RM551168
- Samuel Ramos de Almeida - RM99134
- Laura Claro Mathias - RM98747

