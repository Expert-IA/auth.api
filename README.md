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

## Segurança

Rodamos uma ferramente de análise estática (semgrep)

![image](https://github.com/user-attachments/assets/140fb559-c6c4-4ea0-9ab8-84b09b165a24)

## Cloud / Azure

Essa aplicação a cada deploy na "main", é realizado um deploy na azure, segue a URL para testes na nuvem

```bash
https://expert-ia-dev-epbucva2bseadxbt.eastus-01.azurewebsites.net/swagger-ui
```

## Aplicação (Prints)

Rodamos uma ferramente de análise estática (semgrep)

![image](https://github.com/user-attachments/assets/b800a56c-aaf4-4ec9-9275-acd6054cb153)
![image](https://github.com/user-attachments/assets/18f32b6b-9287-42d5-916d-dac93b6799b2)
![image](https://github.com/user-attachments/assets/3f12fdcb-e02c-4320-b3fc-34f1efd576e7)

![image](https://github.com/user-attachments/assets/b9a90850-e9e3-455c-b48c-d7c2e572ff41)
![image](https://github.com/user-attachments/assets/c755155c-525f-42bb-81ec-70532aa1bd73)


## Integrantes

- Enricco Rossi de Souza Carvalho Miranda - RM551717
- Gabriel Marquez Trevisan - RM99227
- Guilherme Silva dos Santos - RM551168
- Samuel Ramos de Almeida - RM99134
- Laura Claro Mathias - RM98747

