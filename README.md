# Arquiterura de Microsserviços com Spring, RabbitMQ, OpenFeign, Docker e mais! 🚀

Este repositório contém um projeto de **arquitetura de microserviços** desenvolvido em **Java** e **Spring**. O objetivo deste projeto é demonstrar como construir uma solução escalável e robusta utilizando tecnologias como **RabbitMQ**, **Keycloak**, **Spring Boot**, e outros componentes essenciais para uma arquitetura de microserviços. 🔧

## Tecnologias Utilizadas 🛠️

- **Java**: Linguagem principal utilizada para o desenvolvimento dos microserviços. ☕
- **Spring Boot**: Framework para construção dos microserviços. 🌱
- **RabbitMQ**: Sistema de mensageria para comunicação assíncrona entre os microserviços com protocolo AMQP.
- **OpenFeign**: Estabelece comunicação síncrona entre os microserviços. 📡
- **Docker**: Contêineres para facilitar o desenvolvimento e a execução dos microserviços. 🐳
- **Spring Cloud**: Ferramentas adicionais para construção de sistemas distribuídos. ☁️

## Funcionalidades ✨

- **Comunicação Assíncrona**: RabbitMQ para envio e recebimento de mensagens entre microserviços, garantindo comunicação desacoplada. 📨
- **Escalabilidade**: A arquitetura foi projetada para permitir o crescimento modular e escalável do sistema. 📈
- **Dockerização**: Todos os serviços são containerizados utilizando Docker para facilitar o deploy em diferentes ambientes. ⚙️

## Estrutura do Projeto 📂

- **Microservice Clientes**: Permite salvar um cliente e buscar os dados por CPF🔧
- **Microservice Cartoes**: Permite salvar um cartao, listar cartoes por renda e buscar cartao por cliente⚡
- **Microservice Avaliador de Credito**: Permite avaliar o credito de um cliente com base em sua renda e listar os cartoes disponiveis⚡
- **Gateway/Cloud Gateway**: Controla o tráfego entre os microserviços e oferece uma camada de segurança adicional com LoadBalancer. 🔀
- **RabbitMQ**: Responsável pela comunicação assíncrona entre os microserviços. 📦



