
# Bexam

Sistema de busca e agendamento de exames

## Autores

- [Leandro Pinheiro](https://github.com/leaandropinheiro)
- [Gabriel Guidini](https://github.com/gabrielguidini)

## Stack utilizada

**Front-end:** Vue, Vuex e Vuetify

**Back-end:** Java e Spring

**Database:** PostgreSQL

## Funcionalidades

- Tela de login
- Tela para busca de exames
- Tela para listagem e comparação dos exames

## Diagrama

```mermaid
classDiagram
    class User {
        -id: UUID
        -name: String
        -email: String
        -document: String

        +isDocumentValid(String cpf): Boolean

    }

    class Exam {
        -id: UUID
        -name: String
    }

    class Schedule {
        -id: UUID
        -exam: Exam
        -user: User
        -payment: Payment
        -examDate: OffsetDateTime
    }

    class Payment{
        -id: UUID
        -paymentType:PaymentTypeEnum
        -value: Double

        +isValid(Payment): Boolean 
    }

    User <--* Schedule
    Exam <--* Schedule
    Payment <--* Schedule
```
