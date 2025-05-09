# 🧾 Microserviço - User

SE DESEJAR EXECUTAR O PROJECTO, SIGA AS INSTRUÇOES ABAIXO. SE OCORRER ALGUM PROBLEMA, AVISA-ME E TE AJUDAREI A ULTRAPASAR O PROBLEMA.
Meu email de suporte eh: jonascportugal30@gmail.com

Este microserviço é responsável por cadastrar usuários e publicar uma mensagem em uma fila RabbitMQ, que será consumida pelo microserviço `email`.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web -> para criar os endpoints
- Spring AMQP (RabbitMQ) →Para trabalhar com o protocolo de mensageria e realizar a comunicação assincronamente entre os microserviços
- Spring validation → para fazer validações dos dados
- Spring data Jpa →Para realização a conexão e interação com a bd
- Spring PostgreSQL -> SGBD
- Cloud AMQP ->Para gerenciar a fila e as mensagens do RaabitMQ
- Maven ->Gerenciador de dependências

---

## 🧩 Funcionalidades

- Cadastro de usuários via REST API
- Envio de mensagem para o RabbitMQ ao cadastrar um novo usuário
- Comunicação assíncrona com o microserviço `email`

---

## 🧪 Como executar

### Pré-requisitos

- RabbitMQ (ou criar uma conta no CloudAMQP)
- Java 17 ou superior
- Maven 3+
- PostgreSQL instalado

### Passos

```bash
# Clone este repositorio
«
# Abra o projecto no seu IDE (Ex: IntelJ, ou um outro)

# Configure o application.properties com suas credenciais.Eis abaixo os atributos a definir os valores

server.port=8081 (aqui coloque a sua porta de preferência)
spring.datasource.url=jdbc:postgresql://localhost:5432/NOME_DO_SEU_BANCO_DE_DADOS_1
spring.datasource.username=postgres   (coloque o username do seu postgres)
spring.datasource.password=root       (coloque o a password do seu postgres)
spring.jpa.hibernate.ddl-auto=update  

spring.rabbitmq.addresses=URL_DO_RabbitMQ   (aqui adicione a url da fila do seu MabbitMq)
broker.queue.email.name=default.email

ATENCÃO: Execute primeiro o microseriço de email.

# Agora Execute esta aplicação

#Faça teste no postman ou insomnia
url: http://localhost/api/users

corpo da solicitação:

{
  "name": "Jonas",
  "email": "jonascportugal@gmail.com"
}

#Abra o Clound AMQP para visualizar as mesnagens que estão chegando na fila
