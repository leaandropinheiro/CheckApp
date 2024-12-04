
# CheckApp

Sistema de busca e agendamento de exames

## Autores

- [Leandro Pinheiro](https://github.com/leaandropinheiro)
- [Gabriel Guidini](https://github.com/gabrielguidini)

## Stack utilizada

**Front-end:** Vue, Vuex e Vuetify

**Back-end:** Java e Spring

**Database:** PostgreSQL

**Deployment:** Docker/Azure

## Funcionalidades

- Tela de login
- Tela para busca de exames
- Tela para listagem e comparação dos exames

## Diagrama

```mermaid
classDiagram

    class Exam {
        -id: UUID
        -examName: String
        -examCode: Long
        -examValue: Double
    }

    class Schedule {
        -id: UUID
        -exam: Exam
        -user: User
        -payment: Payment
        -createDate: String
        -scheduleDate: OffsetDateTime
        -createdAt: OffsetDateTime
        -updatedAt: OffsetDateTime
        -unit: Unit
    }

    class Unit {
        -id: UUID
        -unitName: String
        -region: String
        -specialty: String
        -services: String
        -unitId: Long
    }

    class UnitExam {
        -id: UUID
        -examName: String
        -examCode: Long
        -unitId: Long
        -examValue: Long
    }

    class Payment{
        -id: UUID
        -paymentType:PaymentTypeEnum
        -value: Double
    }

    Exam <--* Schedule
    Payment <--* Schedule
    UnitExam <--* Unit
    Exam <--* UnitExam
```
