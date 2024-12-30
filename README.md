# Arquiterura de Microsserviços com RabbitMQ, Keycloak, e mais! 🚀

Este repositório contém um projeto de **arquitetura de microserviços** desenvolvido em **Java** e **Spring**. O objetivo deste projeto é demonstrar como construir uma solução escalável e robusta utilizando tecnologias como **RabbitMQ**, **Keycloak**, **Spring Boot**, e outros componentes essenciais para uma arquitetura de microserviços. 🔧

## Tecnologias Utilizadas 🛠️

- **Java**: Linguagem principal utilizada para o desenvolvimento dos microserviços. ☕
- **Spring Boot**: Framework para construção dos microserviços. 🌱
- **RabbitMQ**: Sistema de mensageria para comunicação entre os microserviços. 📡
- **Keycloak**: Solução de gerenciamento de identidades e controle de acesso (autenticação e autorização). 🔐
- **Docker**: Contêineres para facilitar o desenvolvimento e a execução dos microserviços. 🐳
- **Spring Security**: Segurança no acesso aos microserviços. 🔒
- **Spring Cloud**: Ferramentas adicionais para construção de sistemas distribuídos. ☁️

## Funcionalidades ✨

- **Autenticação e Autorização**: Integrado com o Keycloak para fornecer um mecanismo de login e controle de acesso seguro. 🔑
- **Comunicação Assíncrona**: RabbitMQ para envio e recebimento de mensagens entre microserviços, garantindo comunicação desacoplada. 📨
- **Escalabilidade**: A arquitetura foi projetada para permitir o crescimento modular e escalável do sistema. 📈
- **Dockerização**: Todos os serviços são containerizados utilizando Docker para facilitar o deploy em diferentes ambientes. ⚙️

## Estrutura do Projeto 📂

- **Microservice Clientes**: Permite salvar um cliente e buscar os dados por CPF🔧
- **Microservice Cartoes**: Permite salvar um cartao, listar cartoes por renda e buscar cartao por cliente⚡
- **Gateway/Cloud Gateway**: Controla o tráfego entre os microserviços e oferece uma camada de segurança adicional com LoadBalancer. 🔀
- **RabbitMQ**: Responsável pela comunicação assíncrona entre os microserviços. 📦
- **Keycloak**: Sistema de gerenciamento de identidade utilizado para autenticação e autorização dos usuários. 👤


