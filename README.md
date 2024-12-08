# Projeto Hoteliza

O Projeto Hoteliza é uma aplicação de gerenciamento de reservas de hotel, desenvolvida com Spring Boot. O sistema permite que os usuários façam reservas de quartos, verifiquem a disponibilidade e gerenciem suas reservas de forma eficiente.

## Funcionalidades Principais

### 1. Gerenciamento de Usuários
- **Registro de Usuários**: Os usuários podem se registrar no sistema, fornecendo informações como nome e e-mail.
- **Consulta de Usuários**: É possível buscar informações de um usuário pelo seu e-mail.

### 2. Gerenciamento de Reservas
- **Criação de Reservas**: Os usuários podem criar reservas de quartos, especificando as datas de check-in e check-out.
- **Verificação de Disponibilidade**: Antes de criar uma reserva, o sistema verifica se o quarto está disponível para as datas selecionadas.
- **Listagem de Reservas**: Os usuários podem listar todas as suas reservas ou consultar reservas específicas por ID.

### 3. Gerenciamento de Quartos
- **Consulta de Quartos**: O sistema permite consultar informações sobre os quartos disponíveis, incluindo tipo, número e status de disponibilidade.

### 4. Segurança
- **Autenticação**: O sistema utiliza autenticação para proteger as rotas de gerenciamento de reservas e usuários.
- **Controle de Acesso**: Apenas usuários autenticados podem acessar funcionalidades sensíveis, como a criação e listagem de reservas.

### 5. Multithreading
- **Monitoramento de Quartos**: Um serviço em segundo plano monitora a contagem total de quartos disponíveis, atualizando periodicamente as informações.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para acesso a dados e gerenciamento de entidades.
- **Lombok**: Para simplificar o código com anotações que geram getters, setters e construtores automaticamente.
- **Jakarta Validation**: Para validação de dados de entrada.

## Estrutura do Projeto

src ├── main │ ├── java │ │ └── phenrique │ │ └── com │ │ └── hoteliza │ │ ├── demo │ │ │ ├── api │ │ │ │ └── controller │ │ │ ├── domain │ │ │ │ ├── dto │ │ │ │ └── model │ │ │ ├── repository │ │ │ └── service │ │ └── thread │ └── resources │ └── application.properties └── test

## Como Executar o Projeto
1. Clone o repositório:
   ```bash
   https://github.com/PedroHenriqueSouzaFreitas/hoteliza.git

   cd projeto Hoteliza

    ./mvnw spring-boot:run
   ```
## Contribuidores
Agradecemos a todos os contribuidores que ajudaram a desenvolver este projeto:

- **Pedro Henrique**
- **Rujélio Lima**
- **Davi Alvez**
- **Iago Texeira**
